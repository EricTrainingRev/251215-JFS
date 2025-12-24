import { Component, signal, WritableSignal } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterOutlet, RouterLinkWithHref, Router } from '@angular/router';
import { PokeName } from './components/poke-name/poke-name';
import { PokeSearch } from "./components/poke-search/poke-search";
import { PokeService } from './services/poke-service';
import { PokeSprites } from './components/poke-sprites/poke-sprites';
import { PokeType } from './components/poke-type/poke-type';
import { PokeMove } from './components/poke-move/poke-move';


/*
  This Component decorator tells Angular that our class represents a Component. Components are the
  fundamental building blocks for our Angular apps. They contain html, css (or other styling), and
  code to make the component functional
*/
@Component({
  selector: 'app-root', // how to reference the component 
  /*
    what other resources the component needs access to. In this case, we have access to the RouterOutlet to control routing, and
    the FormsModule to gain access to the ngModel directive in our template
  */
  imports: [
    RouterOutlet,
    FormsModule,
    PokeName,
    PokeSearch,
    PokeSprites,
    PokeType,
    PokeMove,
    RouterLinkWithHref
],
  templateUrl: './app.html', // a link to the component html or the raw html itself
  styleUrl: './app.css' // link to styling,
})
/* 
  classes in TypeScript and JavaScript are still fundamentally key value pair objects, but they
  allow us to use a more standardized syntax we would expect to use in other languages like Java.
*/
export class App {
  protected readonly title = signal('pokedex');

  pokeNamePresent: WritableSignal<boolean> = signal(false);

  /*
    In order to conditionally display the pokedata components we can subscribe to the subject
    here in the app component and check if the data in the subject is present. If it is not, we
    do not render the pokedata components. If it is present, then we do render the components, and let
    them handle subscribing to the subject to update their specific resources

    We are also adding a Router service to this component: this will allow us to programmatically
    navigate the various routes of our application
  */
  constructor(private pokeService: PokeService, private router: Router){
    this.pokeService.getPokemonSubject().subscribe( pokeData => {
      this.pokeNamePresent.set(pokeData.name != "");
    })
  }

  /*
    Here we are defining variables to hold the data we want displayed on our page. This centralizes the definition of data here in the
    component class, and we can focuses purely on displaying this data in our html template
  */

  // this makes the headerText variable a property of the App class
  headerText: string = "Welcome to the Pokedex!";
  searchInstructions: string = "Use the search option below to look up Pokemon information: you may use the id of the pokemon or its name";
  buttonText: string = "Whose's that Pokemon?";
  searchType: string = "text"; // value for search type attribute
  placeholderText: string = "enter id or name here" // value for input placeholder attribute

  /*
    A core resource for making reactive web pages is signals: the default type of signal created by the signal function is a
    WritableSignal: this object allows for updates to its data (set by a generic), and anytime the data is updated the signal emits
    a "signal", which Angular detects and then updates the rendered view with the new content
  */
  pokemonName: WritableSignal<string> = signal("");

  /*
    This pokemonIdentifier variable will be connected to the value attribute of our search input in the template. Any changes to either
    the variable below or the input value in the web page will be reflected in both places.
  */
  pokemonIdentifier: string = "";

  // note we just provide the function signature when defining a function in a class
  updateDisplayedPokemonName(){
    this.pokemonName.set(this.pokemonIdentifier);
  }

  renderRouteExampleTwo(){
    this.router.navigate(['/exampleTwo']);
  }
}
