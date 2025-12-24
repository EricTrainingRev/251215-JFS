import { Component, Input, WritableSignal } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-pokedex-button',
  imports: [],
  templateUrl: './pokedex-button.html',
  styleUrl: './pokedex-button.css',
})
export class PokedexButton {

  @Input()
  buttonText!: string;

  constructor(private router: Router){

  }

  updateRouterOutlet(){
    this.router.navigate([`/${this.buttonText}`])
  }

}
