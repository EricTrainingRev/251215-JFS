import { test, expect } from "@playwright/test";

/*
    Playwright can intercept network requests, which gives us the capability to stub web requests
    made via the page. This can be useful if you want to perform unit/integration testing on the
    web page, or if you need to run tests without worrying about whether the server is working
    correctly or not.
*/
test('Playwright can intercept network requests and alter the way they are handled', async ({ page }) => {
    await page.pause();
    await page.goto("http://localhost:3000");
    await page.route('**/api/add', async (route) => {
        await route.fulfill({
            body: JSON.stringify(
                {
                    result:"This is a stubbed result"
                }
            ),
            status:200,
            contentType: 'application/json'
        })
    })
    await page.locator('button[data-value="5"]').click();
    await page.locator('button[data-op="+"]').click();
    await page.locator('button[data-value="6"]').click();
    await page.locator('#equals').click();
    await expect(page.locator('#display')).toHaveText("This is a stubbed result");
});