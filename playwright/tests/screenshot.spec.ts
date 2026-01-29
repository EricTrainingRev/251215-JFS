import { test } from "@playwright/test";

test('Playwright can take screenshots', async ({ page }) => {
    await page.goto('http://localhost:3000');
    await page.screenshot({path:`screenshots/example-${Date.now()}.png`, fullPage:false});
    await page.locator('button[data-value="5"]').screenshot({path:`screenshots/button-five-${Date.now()}.png`})
})