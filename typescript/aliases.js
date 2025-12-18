/*
    One of the benefits of the type system is we can provide greater context for the variables
    and their types. Consider the following code: while this is valid type hinting, it does not
    provide much detail for what the data is intended to be used for (full name and age). One way
    we could provide further context is to create aliases for the types we are using. An Alias
    is a custom name for a type that we can use in our code to provide extra context for our
    variables

    let valueOne: string;
    let valueTwo: number;

    We can create a custom type based off the built-in types provided by TypeScript in order to
    provide extra context for the data we work with. The reason it is called an alias is because
    our custom type still represents a real type in the language, we simply use an alternate name
    for the purpose of providing context

*/
let valueOne;
let valueTwo;
valueOne = "Billy Bob";
// valueTwo = "thirty seven"; the compiler recognizes that the string here is not a valid "Age"
valueTwo = 37;
const myGrade = "B";
const yourGrade = "A";
function checkValidNumber(num) {
    if (10 < num && num < 20) {
        return num;
    }
}
export {};
