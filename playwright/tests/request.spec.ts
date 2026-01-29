import { test, expect } from "@playwright/test";

/*
    The APIRequestContext can be accessed via the request fixture. This tool provides the ability
    to make HTTP requests. This can be used for API testing and for setup/teardown actions
*/
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