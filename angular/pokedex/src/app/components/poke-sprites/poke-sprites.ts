import { Component, signal, WritableSignal } from '@angular/core';
import { PokeSubscriber } from '../../classes/poke-subscriber';
import { PokeService } from '../../services/poke-service';


@Component({
  selector: 'app-poke-sprites',
  imports: [],
  templateUrl: './poke-sprites.html',
  styleUrl: './poke-sprites.css',
})
export class PokeSprites extends PokeSubscriber {

  /*
    Don't forget to save your data in a signal: you will run into errors if you don't
  */
  spriteData: WritableSignal<Array<string>> = signal([]);

  altText: string = "spriteImage"

  constructor(private pokeService: PokeService){
    // super is used to pass any necessary data into a parent class constructor
    super()
    this.subscription = this.pokeService.getPokemonSubject().subscribe( pokeData => {
      /*
        Because the signal stores an array of strings we set the elements inside of our array and
        then use the set function for this signal to update the stored array
      */
      const newSpriteData = [];
      newSpriteData.push(pokeData.sprites.back_default);
      newSpriteData.push(pokeData.sprites.front_default);
      this.spriteData.set(newSpriteData);
    });
  }

}
