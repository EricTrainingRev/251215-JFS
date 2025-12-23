import { Component, signal, WritableSignal } from '@angular/core';
import { PokeSubscriber } from '../../classes/poke-subscriber';
import { PokeService } from '../../services/poke-service';
import { PokeText } from '../poke-text/poke-text';

@Component({
  selector: 'app-poke-type',
  imports: [PokeText],
  templateUrl: './poke-type.html',
  styleUrl: './poke-type.css',
})
export class PokeType extends PokeSubscriber{

  pokeTypes: WritableSignal<Array<string>> = signal([])

  constructor(private pokeService: PokeService){
    super();
    this.subscription = this.pokeService.getPokemonSubject().subscribe( pokeData => {
      const newPokeTypes = [];
      for(const typeObj of pokeData.types){
        newPokeTypes.push(typeObj.type.name)
      }
      this.pokeTypes.set(newPokeTypes);
    });
  }

}
