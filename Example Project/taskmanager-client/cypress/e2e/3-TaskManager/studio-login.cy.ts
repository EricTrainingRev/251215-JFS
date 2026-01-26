describe('Studio generated login test', () => {
  /*
    This test was generated with Cypress studio, but it had to manually be moved into the
    describe block.
  */
  it('Login via Studio', function() {
      cy.visit('localhost:4200')
      
      cy.get('#username').click();
      cy.get('#username').type('admin');
      cy.get('#password').type('admin');
      cy.get('button').click();
      cy.get('p').should('have.text', 'admin works!');
      
  });
});

