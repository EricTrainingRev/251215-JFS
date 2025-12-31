import { Injectable } from '@angular/core';
import { TokenTransport } from '../interfaces/token-transport';
import { HttpClient } from '@angular/common/http';
import { JwtStorage } from './jwt-storage';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root',
})
export class LoginService {
  
  constructor (
    private httpClient: HttpClient, 
    private jwtStorage: JwtStorage,
    private router: Router
  ){}

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
            this.router.navigate(['/admin'])
          }
        },
        error: err => {
          console.error(err);
        }
      });
  }

}
