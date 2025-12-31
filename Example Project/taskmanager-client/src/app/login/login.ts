import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-login',
  imports: [FormsModule],
  templateUrl: './login.html',
  styleUrl: './login.css',
})
export class Login {

  usernameInput = '';
  passwordInput = '';

  constructor (private httpClient: HttpClient){}

  adminLogin(){
    this.httpClient.post(
      "http://localhost:8080/login/admin",
      {
        username:this.usernameInput,
        password:this.passwordInput
      },
      {
        observe:"response"
      }
  ).subscribe({
        next: response => {
          console.log(response.status);
        },
        error: err => {
          console.error(err);
        }
      });
  }

}
