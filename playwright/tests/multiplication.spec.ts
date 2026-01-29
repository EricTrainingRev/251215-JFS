import { test, expect } from '@playwright/test';

/*
  This test was made using codegen. Codegen is a fantastic tool for rapid prototyping of tests, but
  you should be careful about generating the code and then leaving it. It does not make use of
  any of your custom fixtures, nor does it account for tests running in parallel, so for any large
  test suite you should take the time to transform the generated code into something that can be
  more easily maintained (actions facilitated through poms, locator data stored in custom fixtures,
  etc.)
*/
test('Multiplication should be supported', async ({ page }) => {
  await page.goto('http://localhost:3000/');
  await page.getByRole('button', { name: '5' }).click();
  await page.getByRole('button', { name: '×' }).click();
  await page.getByRole('button', { name: '6' }).click();
  await page.getByRole('button', { name: '=' }).click();
  await expect(page.locator('#display')).toContainText('30');
});