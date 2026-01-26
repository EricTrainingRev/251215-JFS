import { Login } from "../../src/app/login/login"

describe('login component', () => {
  it('should render', () => {
    cy.mount(Login);
    cy.get('input').first().type('admin');
  })
})