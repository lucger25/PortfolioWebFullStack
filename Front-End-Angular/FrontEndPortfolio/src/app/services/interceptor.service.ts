import { Injectable } from '@angular/core';
import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AuthenticatorService } from './authenticator.service';

@Injectable({
  providedIn: 'root'
})
export class InterceptorService implements HttpInterceptor{

  constructor( private authenticatorService:AuthenticatorService) { }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    
    var currentUser=this.authenticatorService.AuthUser;

    if (currentUser && currentUser.accessToken) 
    {
      req = req.clone(
        {
          setHeaders:{
            Authorization: 'Bearer ${currentUser.accessToken}'
          }
        })
    }

    return next.handle(req)
  }

}
