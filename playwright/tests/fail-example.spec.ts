import { test, expect } from "@playwright/test";

// you can run this test to see the defect report Playwright generates
test('Playwright can intercept network requests and alter the way they are handled', async ({ page }) => {
    await page.goto("http://localhost:3000");
    await page.locator('button[data-value="5"]').click();
    await page.locator('button[data-op="+"]').click();
    await page.locator('button[data-value="6"]').click();
    await page.locator('#equals').click();
    await expect(page.locator('#display')).toHaveText("This is a stubbed result");
});