// Note we are importing from our custom fixture module
import { test, expect} from "./fixtures/calculator-fixtures";

const {describe, beforeEach} = test;

describe('Calculator does Math', ()=>{

    beforeEach(async ({page})=>{
        await page.goto("http://localhost:3000");
    });
    /*
        Because we are using our extended test object we can access our custom fixtures in the
        test. This way of injecting data into your tests allows for easier adjustment in the future:
        instead of having to find every test where updated test data needs to be adjusted, you instead
        store the data in your custom fixture and make the change their once.
    */
    test("Subtraction works", async ({page, stringData, isExact, buttonPosition}) => {
        const [
            buttonFiveSelector,
            buttonSelector,
            subtractText,
            sixText,
            displayId,
            negativeOne
        ] = stringData;
        await page.locator(buttonFiveSelector).click();
        await page.getByRole('button',{name:subtractText, exact:isExact}).click();
        await page.getByText(sixText).click();
        await page.locator(buttonSelector).nth(buttonPosition).click();
        await expect(page.locator(displayId)).toHaveText(negativeOne);
    });

});