/// <reference types="cypress" />>
describe('Login feature', () => {
  it('allows users to log in with valid credentials', () => {
    cy.visit('http://localhost:4200');
    cy.get('#username').type('admin');
    cy.get('#password').type('admin');
    cy.get('button').click();
    cy.get('p').should('have.text', 'admin works!');
  })
});
