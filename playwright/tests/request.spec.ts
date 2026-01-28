import { test, expect } from "@playwright/test";

test('Playwright can make http requests', async ({request}) => {
    const response = await request.post(
        'http://localhost:3000/api/add',{
            data: {
                a:5,
                b:6
            }
        }
    );
    expect(response.status()).toBe(200);
    const responseBody = await response.json();
    expect(responseBody.result).toBe(11);
});