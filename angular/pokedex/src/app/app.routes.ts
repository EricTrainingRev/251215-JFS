import { Routes } from '@angular/router';
import { RouteExample } from './components/route-example/route-example';
import { RouteExampleTwo } from './components/route-example-two/route-example-two';
import { PokeType } from './components/poke-type/poke-type';
import { PokeSprites } from './components/poke-sprites/poke-sprites';
import { PokeMove } from './components/poke-move/poke-move';

/*
    Angular's routing feature is how you really make your SPA pop. With a well configured set of
    routes you can optimize the delivery of your application and its various views. In this Routes
    resource you set the urls for your routes, the components that should be rendered, any guards
    to control access to those routes, and any other configurations you may need for your routes.
*/

export const routes: Routes = [
    // bare-bones route example: provide the url and component to be rendered
    {path:'example', component:RouteExample},
    {path:'exampleTwo', component:RouteExampleTwo},
    {path:'type', component:PokeType},
    {path:'sprite', component:PokeSprites},
    {path:'move', component:PokeMove},
    // if setting a default view in your routes use an empty path and set pathMatch to "full"
    {path:'', component:PokeSprites, pathMatch:"full"}
];
