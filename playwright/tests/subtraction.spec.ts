import { test, expect} from "./fixtures/calculator-fixtures";

const {describe, beforeEach} = test;

describe('Calculator does Math', ()=>{

    beforeEach(async ({page})=>{
        await page.goto("http://localhost:3000");
    });

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