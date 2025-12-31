import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { TokenTransport } from '../interfaces/token-transport';
import { LoginService } from '../services/login-service';

@Component({
  selector: 'app-login',
  imports: [FormsModule],
  templateUrl: './login.html',
  styleUrl: './login.css',
})
export class Login {

  usernameInput = '';
  passwordInput = '';

  constructor (private loginService: LoginService){}

  login(){
    this.loginService.adminLogin(this.usernameInput, this.passwordInput);
  }

}
