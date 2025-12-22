import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { PokeService } from '../../services/poke-service';

@Component({
  selector: 'app-poke-search',
  imports: [FormsModule],
  templateUrl: './poke-search.html',
  styleUrl: './poke-search.css',
})
export class PokeSearch {

  pokeIdInput = "";
  buttonPrompt = "Search for Pokemon!";

  constructor(private pokeService: PokeService){}

  searchForPokemon(){
    this.pokeService.searchForPokemon(this.pokeIdInput);
  }

}
