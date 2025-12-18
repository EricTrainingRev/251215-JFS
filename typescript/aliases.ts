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

type FullName = string;
type Age = number;

let valueOne: FullName;
let valueTwo: Age;

valueOne = "Billy Bob";
// valueTwo = "thirty seven"; the compiler recognizes that the string here is not a valid "Age"
valueTwo = 37;

/*
    The examples above are simple, we can make our custom types much more complex: we can indicate
    that a value accepts one of multiple types, and we can even set type information for more 
    complex resources like objects
*/

// we can specify specific values acceptable for our custom type
type Grade = "A" | "B" | "C" | "D" | "F";
const myGrade: Grade = "B";
const yourGrade: Grade = "A";

// we can also allow multiple possible types for a value
type PossibleReturnValues = number | void;

function checkValidNumber(num: number): PossibleReturnValues {
    if (10 < num && num < 20){
        return num;
    }
}

/*
    As a reminder, in both JavaScript and TypeScript objects are fundamentally a collection of
    key-value pairs. We can create custom types that define the structure of these key-value
    pairs
*/

type Person = {
    name: string,
    age: number,
    // etc.
}

// if we leave off name or age or try to add more properties we will get an error
const billy: Person = {name:"Billy", age: 12};

/*
    You can use the type keyword in order to make custom types for your objects, but the more
    standardized way of doing so is through custom interfaces
*/

interface PersonInterface {
    name: string,
    age: number
}

const sally: PersonInterface = {name:"Sally", age: 37};