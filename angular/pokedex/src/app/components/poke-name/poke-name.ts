import { Component, OnDestroy, signal, WritableSignal } from '@angular/core';
import { PokeService } from '../../services/poke-service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-poke-name',
  imports: [],
  templateUrl: './poke-name.html',
  styleUrl: './poke-name.css',
})
export class PokeName implements OnDestroy {
  // the OnDestroy interface gives us access to the lifecycle method ngOnDestroy. This triggers before the component is destroyed

  pokemonNameValue: WritableSignal<string> = signal("");

  /*
    Subjects tend to be long-lived in an application: the components that subscribe to them are not. If you have subscribers that are
    constantly being created and deleted, you run the risk of adding memory leaks to your application if you do not unsubscribe from your
    subject/observable when the resource is destroyed. To manage the subscription you can save the actual Subscription object created
    by the subscribe function and then unsubscribe when the resource is destroyed
  */
  private subscription: Subscription

  /*
    This is how you implement constructor dependency injection: you declare a private property and
    set its type to the resource you want injected. As long as it is an injectable resource Angular
    will automatically handle the dependency injection for the component when it is used
  */
  constructor(private pokeService: PokeService){
    this.subscription = this.pokeService.getPokemonSubject().subscribe( pokemonData => this.pokemonNameValue.set(pokemonData.name));
  }

  /*
    This method is automatically triggered when the component is set to be destroyed. This is a good candidate for facilitating the
    unsubscribing from the pokemon data subject. If we don't do this, the subject will maintain a reference to this instance of the
    component, preventing garbage collection from removing it from memory, which is what makes the potential memory leak
  */
  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }

}
