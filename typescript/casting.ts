/*
    It is not uncommon to need to cast from one type to another: as long as you are explicit about
    the casting the TypeScript compiler will allow it

    Note the export keyword below: this will allow us to import the function into another module
    and use it
*/

export function convertStringNumberToNumber(stringNumber: string): number{
    return Number(stringNumber);
}

const result = convertStringNumberToNumber("22");
console.log(result);