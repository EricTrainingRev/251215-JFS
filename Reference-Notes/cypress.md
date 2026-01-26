# Cypress Study Guide

## Cypress Overview
**Cypress** is a modern end-to-end testing framework for web applications. It runs in the browser, providing fast, reliable, and easy-to-write tests for UI and API interactions. Cypress offers time-travel debugging, automatic waiting, and a rich interactive UI for test development.

## Installation
Install Cypress via npm:
```bash
npm install cypress --save-dev
```
Open Cypress Test Runner:
```bash
npx cypress open
```
Or run tests headlessly:
```bash
npx cypress run
```

## Test Structure
Cypress tests are written in JavaScript or TypeScript using Mocha's BDD syntax (`describe`, `it`, `before`, `after`, etc.).
```js
describe('My First Test Suite', () => {
  before(() => {
    // runs once before all tests
  });

  beforeEach(() => {
    // runs before each test
  });

  it('should visit the homepage', () => {
    cy.visit('https://example.com');
  });

  afterEach(() => {
    // runs after each test
  });

  after(() => {
    // runs once after all tests
  });
});

```

## Basic UI Test
A simple UI test might check for the presence of an element or interaction:
```js
it('logs in successfully', () => {
  cy.visit('/login');
  cy.get('input[name="username"]').type('user1');
  cy.get('input[name="password"]').type('password123');
  cy.get('button[type="submit"]').click();
  cy.contains('Welcome, user1').should('be.visible');
});
```

## Element Selection
Cypress uses `cy.get()` to select elements. Prefer using data attributes for stable selectors:
```js
cy.get('[data-cy=submit-button]').click();
```
Other selectors:
- By class: `cy.get('.my-class')`
- By id: `cy.get('#my-id')`
- By text: `cy.contains('Some Text')`

## Async & API Testing
Cypress can test APIs using `cy.request()` and handle async actions with automatic waiting:
```js
cy.request('POST', '/api/login', { username: 'user', password: 'pass' })
  .its('status')
  .should('eq', 200);
```
Cypress automatically waits for commands and assertions to complete before moving on.

## Debugging Tests
Cypress provides several debugging tools:
- `.debug()` command to pause and inspect
- `cy.pause()` to stop test execution
- Use browser DevTools and Cypress's time-travel UI
- Add `debugger;` statements in your test code

## Custom Commands
You can define reusable custom commands in `cypress/support/commands.js`:
```js
Cypress.Commands.add('login', (username, password) => {
  cy.get('input[name="username"]').type(username);
  cy.get('input[name="password"]').type(password);
  cy.get('button[type="submit"]').click();
});
```
Usage:
```js
cy.login('user1', 'password123');
```

## Cypress Studio
**Cypress Studio** allows you to generate tests interactively by recording actions in the Cypress. For each action taken by the user Cypress will generate a code step to reflect the action. You can right click on an element to open a context menu with assertion options for that element. By default Cypress provides positive assertions, so for any "not" assertions you will need to go into the generated code and add the not keyword. This tool is particularly helpful when creating E2E tests for pre-existing features and user stories, not so much when implementing Test Driven Development. Also, Cypress Studio currently does not support Component Testing.

## Component Testing
Cypress supports component testing for frameworks like React, Vue, and Angular. Example (React):
```js
import { mount } from 'cypress/angular-zoneless';
import { MyComponent } from './MyComponent';

it('renders component', () => {
  mount(MyComponent);
  cy.contains('Hello World').should('exist');
});
```
Once your component is loaded you can run your tests like it was part of any regular web page
## Dashboards
The **Cypress Dashboard** is a cloud service for recording, viewing, and sharing test results. It provides insights, screenshots, and video recordings of test runs. Requires project setup and a Cypress account.

## Data Driven Testing
Cypress supports data-driven tests using `cy.fixture()` for static data or by iterating over arrays:
```js
const users = [
  { username: 'user1', password: 'pass1' },
  { username: 'user2', password: 'pass2' }
];

users.forEach((user) => {
  it(`logs in as ${user.username}`, () => {
    cy.visit('/login');
    cy.get('input[name="username"]').type(user.username);
    cy.get('input[name="password"]').type(user.password);
    cy.get('button[type="submit"]').click();
    cy.contains('Welcome').should('be.visible');
  });
});
```

## Accessibility Testing
Cypress can integrate with accessibility tools like `cypress-axe`:
```js
import 'cypress-axe';

it('has no detectable accessibility violations', () => {
  cy.visit('/');
  cy.injectAxe();
  cy.checkA11y();
});
```

## Visual Regression
Cypress supports visual regression testing via plugins like `cypress-image-snapshot`:
```js
import { addMatchImageSnapshotCommand } from 'cypress-image-snapshot/command';
addMatchImageSnapshotCommand();

it('matches previous screenshot', () => {
  cy.visit('/');
  cy.matchImageSnapshot();
});
```