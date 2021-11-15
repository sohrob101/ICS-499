import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class AuthapiService {

  constructor(private http: HttpClient) { }

  public login(username: string, password: string){
    sessionStorage.setItem('username', username)
    sessionStorage.setItem('password', password)
    const headers = new HttpHeaders({Authorization: 'Basic' + btoa(username+":"+password)})
    return this.http.get("http://localhost:8082/",{headers,responseType: 'text' as 'json'})
  }
}
