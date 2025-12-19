import { bootstrapApplication } from '@angular/platform-browser';
import { appConfig } from './app/app.config';
import { App } from './app/app';

/*
  The main.ts file is the entrypoint for all Angular applications. The bootstrap function requires
  two primary inputs:
  1. the root component of the application
  2. the configuration details for the application
*/
bootstrapApplication(App, appConfig)
  .catch((err) => console.error(err));
