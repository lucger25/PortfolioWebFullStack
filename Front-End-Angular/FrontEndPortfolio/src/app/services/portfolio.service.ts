import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PortfolioService {

  constructor(private http:HttpClient) { }
    
    GetbyUserName():Observable<any>
    {
      return this.http.get("url donde pedimos los datos");
    }
}
