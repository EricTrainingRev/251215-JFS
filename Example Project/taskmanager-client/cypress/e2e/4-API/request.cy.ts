describe('Cypress can make http requests', () => {
  it('allows direct communication with an API', () => {
    cy.request(
      'POST',
      'http://localhost:8080/login/admin',
      {username:"admin", password:'admin'}
    ).then((response) => {
      expect(response.status).to.eq(200);
      expect(response.body).to.exist;
    });
  })
})