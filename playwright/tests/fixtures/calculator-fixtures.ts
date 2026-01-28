// we set an alias for the Playwright test object to make it a bit less confusing extending it
import { test as base, expect as baseExpect } from '@playwright/test';

// this custom type data is needed for Typescript to not get angry with us
type TestData = {
    stringData: Array<string>,
    isExact: boolean,
    buttonPosition: number
}

/*
    Playwright gives us the capability to "extend" the test object. This is how you can add your
    own custom test fixtures to your test cases. This can be test data, page object models, page
    resources with specific user profiles or configurations set up, anything you want Playwright
    to provide for test execution is set up in this way
*/
export const test = base.extend<TestData>({
    stringData: async ({}, use)=>{
        const data = [
            'button[data-value="5"]',
            "button",
            '−',
            '6',
            '#display',
            '-1'
        ]
        await use(data);
    },
    isExact: async ({}, use) =>{
        await use(true);
    },
    buttonPosition: async ({}, use) => {
        await use(14);
    }
});

// This is not necessary, but it is a way to keep your imports a bit cleaner
export const expect = baseExpect;