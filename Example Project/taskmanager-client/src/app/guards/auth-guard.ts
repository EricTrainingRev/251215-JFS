import { inject } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';
import { JwtStorage } from '../services/jwt-storage';
import { HttpClient } from '@angular/common/http';
import { catchError, map, of } from 'rxjs';

/*
  Route Guards are a way of creating conditions for navigating across the various routes of your
  application. a CanActivate guard is a way of specifying the conditions under which a user 
  navigation is permitted for the protected route. We will be using this Route Guard to make sure
  that only admin users, validated by their JWT, can access the admin page
*/

export const authGuard: CanActivateFn = (route, state) => {
  // because our JwtStorage service is an Injectable we can use inject() to get access to it
  const jwtStorage = inject(JwtStorage);
  const router = inject(Router);
  // if the token does not exist, automatically prevent access to the admin route
  if(!jwtStorage.getToken()){
    router.navigate(['']);
    return false;
  }
  const httpClient = inject(HttpClient);
  let isAuthorized = false;
  return httpClient.get(
    "http://localhost:8080/auth/admin",
    {
      observe:"response",
      headers:{
        Authorization:`Bearer ${jwtStorage.getToken()}`
      }
    }
  ).pipe(
    map( response => {
      isAuthorized = response.status === 204;
      if(!isAuthorized){
        router.navigate(['']);
      }
      return isAuthorized;
    }),
    catchError(() => {
      router.navigate(['']);
      return of(false);
    })
  );
  
  
  return true;
};
