import { convertStringNumberToNumber } from "./casting.js";
/*
    If you want to execute your code with node you simply reference it after the node command. Keep
    in mind if working with ts you can't directly execute your ts code: you must first use the
    TypeScript compiler (tsc) to compile your code from ts into js, then you can execute it

    step 1 -> write your TypeScript code
    step 2 -> compile your TypeScript code using npx tsc
    step 3 -> execute your newly compiled JavaScript code
*/
console.log("Hello world!");
// to indicate the type of a variable use a colon and then write out the actual type
let value;
value = "Some string value";
// value = 10; invalid code since 10 is a number, not a string
console.log(value);
console.log(convertStringNumberToNumber("50"));
