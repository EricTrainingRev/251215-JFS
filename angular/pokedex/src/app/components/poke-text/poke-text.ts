import { TitleCasePipe } from '@angular/common';
import { Component, Input } from '@angular/core';
import { PokeTextConverterPipe } from '../../pipes/poke-text-converter-pipe';

@Component({
  selector: 'app-poke-text',
  imports: [TitleCasePipe, PokeTextConverterPipe],
  templateUrl: './poke-text.html',
  styleUrl: './poke-text.css',
})
export class PokeText {

  /*
    This component will be used to provide a standardized API for rendering pokemon text data
    in the pokedex. We will use it specifically for the types and move data, since both of these
    are simple collection of text data. To get access to the parent data in the child element 
    we need to use the input decorator
  */

  @Input()
  textData: string = "";

}
