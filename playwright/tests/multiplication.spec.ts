import { test, expect } from '@playwright/test';

test('Multiplication should be supported', async ({ page }) => {
  await page.goto('http://localhost:3000/');
  await page.getByRole('button', { name: '5' }).click();
  await page.getByRole('button', { name: '×' }).click();
  await page.getByRole('button', { name: '6' }).click();
  await page.getByRole('button', { name: '=' }).click();
  await expect(page.locator('#display')).toContainText('30');
});