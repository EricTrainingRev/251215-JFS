// we set an alias for the Playwright test object to make it a bit less confusing extending it
import { test as base, expect } from '@playwright/test';

// this custom type data is needed for Typescript to not get angry with us
type TestData = {
    testData: Array<string|number|boolean>
}

/*
    Playwright gives us the capability to "extend" the test object. This is how you can add your
    own custom test fixtures to your test cases. This can be test data, page object models, page
    resources with specific user profiles or configurations set up, anything you want Playwright
    to provide for test execution is set up in this way
*/
const test = base.extend<TestData>({
    testData: async ({}, use)=>{
        const data = [
            'button[data-value="5"]',
            "button",
            '-',
            true,
            '6',
            'button',
            14,
            '#display',
            '-1'
        ]
        use(data);
    }
});