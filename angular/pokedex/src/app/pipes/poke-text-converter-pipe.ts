import { Pipe, PipeTransform } from '@angular/core';

/*
  When we make our own pipes there are a few resources to be aware of:
  - name property in Pipe decorator -> this is how we actually utilize the pipe in our template statements
  - transform method -> this controls the actual code executed when we use our pipe. It is how we control what happens when the pipe is used
*/

@Pipe({
  name: 'pokeTextConverter',
})
export class PokeTextConverterPipe implements PipeTransform {

  /*
    Pipes are often chained together, and sometimes they pass along extra data. The extra data is stored in the args parameter, when present
  */
  transform(value: string, ...args: unknown[]): string {
    /*
      The intended use-case for this pipe is to take type and move data and make all words in it title-cased. Also, just because, let's
      remove the dashes and put a space instead 
    */
    const textSplit = value.split("-");
    const textTransformed = textSplit.map( text => {
      let first = text[0];
      let firstUpper = first.toUpperCase();
      return firstUpper + text.slice(1);
    });
    return textTransformed.join("-")
  }

}
