import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthenticatorService {

  url:string="http://localhost:8080/api/portfolio/1";
  //token;
  currentUserSubject: BehaviorSubject<any>;

  constructor(private http:HttpClient, private router:Router) {
    this.currentUserSubject= new BehaviorSubject<any>(JSON.parse(sessionStorage.getItem('currentUser') || '{}'))
   }

   /*login(user:string, password:string){
    this.http.post(this.url+'/auth',{user: user, password: password})
    .subscribe((resp: any) => {
      this.router.navigate(['/portfolio/1']);
      localStorage.setItem('auth_token', resp.token);
    })
   }

   logout(){
     localStorage.removeItem('token');
   }*/


   SessionStart(credenciales:any):Observable<any>
   {
     return this.http.post(this.url, credenciales).pipe(map(data=>{

      sessionStorage.setItem('currentUser', JSON.stringify(data));
      this.currentUserSubject.next(data);
      
       return data
     }))
   }

   get AuthUser()
   {
     return this.currentUserSubject.value;
   }

}
