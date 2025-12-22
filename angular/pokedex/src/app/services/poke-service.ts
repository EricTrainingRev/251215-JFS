import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { PokemonIdentifiers } from '../types/custom-types';
import { PokemonData } from '../interfaces/pokemon-data';

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
  
  constructor(private httpClient: HttpClient){}


  /*
    For this function I am allowing it to accept either a string or number value. Because of this
    flexibility I do have to make sure I check what type the value is if I wish to perform any
    type specific functions (think toLowerCase() for a string value). Note the PokeAPI accepts all
    casing for pokemon names, so we do not need to worry about transforming the pokemon name if we
    provide a name, and the number will be converted to a string when injected into the url, so we
    should be ok to just pass the identifier into the url without any transformations
  */
  searchForPokemon(pokemonIdentifier: PokemonIdentifiers){
    /*
      The httpClient is Angular's tool for making HTTP requests: it has multiple helper methods for
      making specific kinds of requests (get, post, etc) and allows us via a generic to specify the
      data in the response body we want to interact with. Keep in mind the generic we provide is only
      telling Angular what data we are wanting to work with, it does not need to perfectly match all
      the possible data in the response body. It just needs to match the data we want to interact with.
      In the future, if we want to access more data in the response, we have to update our interface
      we are using as our generic

      the http client methods return an observable: this is a tool provided by the RxJS library, and 
      you can think of it as a more powerful promise. Unlike promises that execute immediately, Observables
      are more reactive. When they have a change in their data they emit a signal to subscribers informing
      them of the data change, so that any subscribers can perform associated actions.
    */
    this.httpClient.get<PokemonData>(`https://pokeapi.co/api/v2/pokemon/${pokemonIdentifier}`)
    .subscribe({
      next: responseData => {
        console.log(responseData);
      },
      error: err => {
        console.log(err);
      }
    });
  }

}
