import { Injectable, OnInit } from '@angular/core';

/*
  Many components and services are going to need access to the JWT provided when a user logs in.
  How we save the JWT will have an impact on the accessibility and flow of the application

  Saving token information in a field of the service: this is relatively secure from misuse due to 
  the token living in memory: this prevents the token from being exposed to common attack vectors. However,
  it makes the token ephemeral: once the user leaves the page the token is no longer stored in memory

  Local Storage: This is a solution for long-term persistence for your tokens. It allows the user to leave 
  the page for a bit then come back and continue their work (at least for the lifespan of the token). This is
  convenient, but it is more susceptible to common attack vectors on the web.
*/

@Injectable({
  providedIn: 'root',
})
export class JwtStorage {

  /*
    If going the local storage route make sure the key to access your token in local storage
    is somewhat unique
  */
  private TOKEN_KEY = 'TASK_MANAGER_TOKEN';

  setToken(jwt: string){
    localStorage.setItem(this.TOKEN_KEY, jwt);
  }

  getToken(){
    return localStorage.getItem(this.TOKEN_KEY);
  }

  clearToken(){
    localStorage.removeItem(this.TOKEN_KEY);
  }

}
