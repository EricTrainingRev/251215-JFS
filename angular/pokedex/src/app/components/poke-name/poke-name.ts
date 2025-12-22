import { Component } from '@angular/core';
import { PokeService } from '../../services/poke-service';

@Component({
  selector: 'app-poke-name',
  imports: [],
  templateUrl: './poke-name.html',
  styleUrl: './poke-name.css',
})
export class PokeName {

  /*
    This is how you implement constructor dependency injection: you declare a private property and
    set its type to the resource you want injected. As long as it is an injectable resource Angular
    will automatically handle the dependency injection for the component when it is used
  */
  constructor(private pokeService: PokeService){}

}
