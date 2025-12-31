import { Injectable } from '@angular/core';
import { TokenTransport } from '../interfaces/token-transport';
import { HttpClient } from '@angular/common/http';
import { JwtStorage } from './jwt-storage';

@Injectable({
  providedIn: 'root',
})
export class LoginService {
  
  constructor (private httpClient: HttpClient, private jwtStorage: JwtStorage){}

  adminLogin(username: string, password: string){
    this.httpClient.post<TokenTransport>(
      "http://localhost:8080/login/admin",
      {
        username: username,
        password: password
      },
      {
        observe:"response"
      }
  ).subscribe({
        next: response => {
          console.log(response.status);
          if(response.body){
            console.log(response.body.token)
            this.jwtStorage.setToken(response.body.token);
          }
        },
        error: err => {
          console.error(err);
        }
      });
  }

}
