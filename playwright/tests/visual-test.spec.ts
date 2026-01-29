import { test, expect } from "@playwright/test";

test('Playwright can do basic visual testing', async ({page}) => {
    await page.goto("http://localhost:3000");
    await expect(page).toHaveScreenshot();
})