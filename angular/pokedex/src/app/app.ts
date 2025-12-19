import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';


/*
  This Component decorator tells Angular that our class represents a Component. Components are the
  fundamental building blocks for our Angular apps. They contain html, css (or other styling), and
  code to make the component functional
*/
@Component({
  selector: 'app-root', // how to reference the component 
  imports: [RouterOutlet], // what other resources the component needs access to
  templateUrl: './app.html', // a link to the component html or the raw html itself
  styleUrl: './app.css' // link to styling,
})
/* 
  classes in TypeScript and JavaScript are still fundamentally key value pair objects, but they
  allow us to use a more standardized syntax we would expect to use in other languages like Java.
*/
export class App {
  protected readonly title = signal('pokedex');
}
