import { Component, signal, WritableSignal } from '@angular/core';
import { PokeText } from '../poke-text/poke-text';
import { PokeSubscriber } from '../../classes/poke-subscriber';
import { PokeService } from '../../services/poke-service';

@Component({
  selector: 'app-poke-move',
  imports: [PokeText],
  templateUrl: './poke-move.html',
  styleUrl: './poke-move.css',
})
export class PokeMove extends PokeSubscriber{

  pokeMoves: WritableSignal<Array<string>> = signal([]);

  constructor(private pokeService: PokeService){
    super();
    this.subscription = this.pokeService.getPokemonSubject().subscribe( pokeData => {
      const newPokeMoves = [];
      for(const moveObj of pokeData.moves){
        newPokeMoves.push(moveObj.move.name);
      }
      this.pokeMoves.set(newPokeMoves);
    });
  }

}
