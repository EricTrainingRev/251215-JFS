/// <reference types="cypress" />>
describe('Login feature', () => {
  it('allows users to log in with valid credentials', () => {
    cy.visit('http://localhost:4200');
  })
})