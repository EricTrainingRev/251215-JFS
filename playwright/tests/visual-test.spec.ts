import { test, expect } from "@playwright/test";

/*
    Playwright can compare screenshot data to perform basic visual tests. The degree of difference
    can be configured, and elements can even be covered. This capability is useful for checking
    snapshots of your page state. It should not be a substitute for any other accessibility testing.
*/
test('Playwright can do basic visual testing', async ({page}) => {
    await page.goto("http://localhost:3000");
    await expect(page).toHaveScreenshot();
})