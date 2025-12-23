import { Component } from '@angular/core';
import { PokeSubscriber } from '../../classes/poke-subscriber';
import { PokeService } from '../../services/poke-service';


@Component({
  selector: 'app-poke-sprites',
  imports: [],
  templateUrl: './poke-sprites.html',
  styleUrl: './poke-sprites.css',
})
export class PokeSprites extends PokeSubscriber {

  private spriteData: Array<string> = []

  constructor(private pokeService: PokeService){
    // super is used to pass any necessary data into a parent class constructor
    super()
    this.subscription = this.pokeService.getPokemonSubject().subscribe( pokeData => {
      this.spriteData = []; // make sure to clear out old sprite links
      // for (var in obj) is used to iterate through object keys, for (var of arr) is used for arrays
      for(const link of Object.values(pokeData.sprites)){
        this.spriteData.push(link);
      }
      console.log(this.spriteData);
    });
  }

}
