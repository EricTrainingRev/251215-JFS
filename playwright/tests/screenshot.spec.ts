import { test } from "@playwright/test";

test('Playwright can take screenshots', async ({ page }) => {
    await page.goto('http://localhost:3000');
    await page.screenshot({path:`screenshots/example-${Date.now()}.png`, fullPage:false});
})