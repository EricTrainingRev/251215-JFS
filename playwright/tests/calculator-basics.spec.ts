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
        /*
            The pause method can be used to stop your test and bring up a debugging view of the
            test. You can resume execution, go step by step, and inspect the page at your leisure.
            Keep in mind the pause method does not work if running tests in parallel
        */
        await page.pause();
        /*
            If you need to provide a custom locator using either standard css selectors or using
            xpath the locator function is your best bet. Playwright will detect whether you are
            using a css selector or xpath, but you can also specify in the string which you are 
            using

            the click method when called via a locator object tells Playwright to perform the
            click action on the element located
        */
       await page.locator('button[data-value="5"]').click();
       /*
            You can tell Playwright to look for elements based on their role on the page. Most
            elements will have an associated role you can check in the accessibility tab in the
            browser inspector. If there are multiple elements with the same role on the page you
            can further specify which element you want by providing the name of that element, also
            found in the accessibility tab. This will typically match the text content of the element,
            but this is not always the case. By default Playwright will check for substrings matching
            the name, but you can set the exact property of the option to true to look for the specific
            name
       */
       await page.getByRole("button", {name:'+', exact:true}).click();
       /*
            Note here we are just checking the text content of all elements on the page and
            looking for the one that has 6 as a substring of the text content. Like the getByRole
            above this can be adjusted to look for an exact match
       */
       await page.getByText('6').click();

       /*
            if a locator resolves to more than one element all the elements will be returned. In 
            these scenarios, unless you are specifically looking to perform actions on all the
            returned elements you will need to tell Playwright what element you want to perform 
            the action on. You can use the first, last, and nth functions to specify which element
            to act on. nth is 0 based for accessing the index of the element.
       */
       await page.locator('button').nth(14).click()

       // NOTE: locator returns a Locator object, instructions for finding an element, so no need
       // to await the method call
       const displayLocator = page.locator('#display');

       await expect(displayLocator).toHaveText('11');

    });

});



