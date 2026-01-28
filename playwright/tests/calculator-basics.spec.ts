import { expect, test } from "@playwright/test";

/*
    You can deconstruct your test object if you want to access your hooks and describe blocks
    directly
*/
const {describe, beforeEach} = test; 

/*
    The describe method provided by the test function can be used to group similar tests together.
    The name of the group is pre-pended to the test name in the final test report. Note that the
    describe block callback function is NOT asynchronous
*/
describe('Basic Happy Path', ()=>{

    /*
        Any actions you want to be executed before each test (or before all tests) can be set up
        in a beforeEach and/or beforeAll. Note that these hooks are limited to the scope of the
        spec file they are defined in
    */
    beforeEach(async ({page})=>{
        await page.goto("http://localhost:3000");
    });

    /*
        The way Playwright tests are set up is in the following:
        - test function declares a test case
            - first argument is the test name
            - second is an async callback function that is provided with the default Playwright test 
            fixtures.
            - It is common to deconstruct the fixtures object to only have access to the specific
                fixtures you need for the text
    */
    test('Calculator page opens', async ({page}) => {
        await expect(page).toHaveTitle("Web Calculator");
    });    

    test('Calculator can do addition', async ({page}) => {
        page.getBy
    });

});



