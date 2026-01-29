import { test } from "@playwright/test";

/*
    If you need to get a visual of the page state at any given time you can manually take a
    screenshot with Playwright (full page, viewport, or individual elements). Screenshot and video
    recording can also be configured in the config file for all tests and for individual projects.

    When configured in the config Playwright will store the data in the test-results directory, and
    they can be viewed in the test report Playwright generates
*/
test('Playwright can take screenshots', async ({ page }) => {
    await page.goto('http://localhost:3000');
    await page.screenshot({path:`screenshots/example-${Date.now()}.png`, fullPage:false});
    await page.locator('button[data-value="5"]').screenshot({path:`screenshots/button-five-${Date.now()}.png`})
})