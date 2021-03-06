import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PortfolioService {

  url:string="http://localhost:8080/api/portfolio/1";

  constructor(private http:HttpClient) { }
    
    GetbyUserId():Observable<any>
    {
      return this.http.get<any>(this.url);
    }
}
