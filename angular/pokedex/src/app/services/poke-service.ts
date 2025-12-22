import { Injectable } from '@angular/core';

/*
  Anytime you need to share data in your components you should use a service. Services are Angular's
  built in way to provide shared resources and are provided via dependency injection. The providedIn
  property of the Injectable annotation tells Angular the service should be available in all parts
  of the application
*/

@Injectable({
  providedIn: 'root',
})
export class PokeService {
  
}
