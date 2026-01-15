# TypeScript Quick Reference Guide

## What is TypeScript?

TypeScript is a superset of JavaScript that adds static typing and other features to help catch errors early and improve code quality. TypeScript code compiles to plain JavaScript and can run anywhere JavaScript runs.

**Key Points:**
- Adds optional static types to JavaScript
- Supports modern JavaScript features
- Improves tooling and code safety

```typescript
let message: string = "Hello, TypeScript!";
```

---

## JavaScript vs TypeScript

| Feature         | JavaScript | TypeScript         |
|-----------------|------------|--------------------|
| Typing          | Dynamic    | Static (optional)  |
| Compilation     | Interpreted| Compiled to JS     |
| Tooling         | Basic      | Advanced           |
| Error Checking  | Runtime    | Compile-time       |

**Example:**

JavaScript:
```javascript
let num = 42;
num = "hello"; // Allowed
```

TypeScript:
```typescript
let num: number = 42;
// num = "hello"; // Error: Type 'string' is not assignable to type 'number'
```

---

## tsc (TypeScript Compiler)

`tsc` is the TypeScript compiler. It converts `.ts` files to JavaScript.

**Common Commands:**
- `tsc file.ts` — Compile a single file
- `tsc` — Compile the whole project (requires `tsconfig.json`)
- `tsc --init` — Creates an initial `tsconfig.json` file

**Sample tsconfig.json:**
```json
{
	"compilerOptions": {
		"target": "es6",
		"module": "commonjs",
		"strict": true
	}
}
```

---

## tsconfig basics

`tsconfig.json` is the configuration file for TypeScript projects. It defines how TypeScript code is compiled and what options are enabled.

**Key Points:**
- Placed in the root of your project
- Controls compiler behavior and project structure
- Created with `tsc --init`

---

## target

The `target` option specifies the JavaScript version to compile to (e.g., ES5, ES6, ES2020).

**Example:**
```json
{
	"compilerOptions": {
		"target": "es6"
	}
}
```

---

## compiler options

`compilerOptions` is a section in `tsconfig.json` that controls many aspects of TypeScript compilation.

**Common Options:**
- `module`: Module system (e.g., `commonjs`, `esnext`)
- `outDir`: Output directory for compiled files
- `rootDir`: Root directory of source files
- `strict`: Enable all strict type-checking options
- `esModuleInterop`: Compatibility with CommonJS modules

**Example:**
```json
{
	"compilerOptions": {
		"module": "commonjs",
		"outDir": "./dist",
		"rootDir": "./src",
		"strict": true,
		"esModuleInterop": true
	}
}
```

---

## strict

The `strict` option enables a set of strict type-checking features for safer code.

**Features Enabled:**
- `strictNullChecks`: Prevents null/undefined errors
- `noImplicitAny`: Requires explicit types
- `strictFunctionTypes`, `strictPropertyInitialization`, etc.

**Example:**
```json
{
	"compilerOptions": {
		"strict": true
	}
}
```

---

## TypeScript Installation

TypeScript can be installed globally or locally using npm:

- Global: `npm install -g typescript`
- Local (recommended for projects): `npm install --save-dev typescript`

Check installation:
```bash
tsc --version
```

---

## Simple Types

TypeScript supports basic types for variables:

- `number`: Numeric values
- `string`: Text
- `boolean`: True/false

```typescript
let age: number = 30;
let name: string = "Alice";
let isActive: boolean = true;
```

## Special Types

Special types help handle more complex scenarios:

- `any`: Disables type checking for a variable
- `unknown`: Like `any`, but safer (must be checked before use)
- `void`: No value returned (used in functions)
- `never`: Function never returns (throws or infinite loop)
- `null` and `undefined`: Absence of value

```typescript
let value: any = 42;
let input: unknown = "data";
function log(): void {
	console.log("Logging...");
}
function fail(): never {
	throw new Error("Failed!");
}
```

## Object Types

Object types describe the shape of objects:

```typescript
let user: { name: string; age: number } = {
	name: "Bob",
	age: 25
};
```

## Type Aliases & Interfaces

Type aliases and interfaces define custom types for objects and functions. Type aliases can be set for objects and primitives; interfaces only work with objects.

**Type Alias:**
```typescript
type Point = { x: number; y: number };
let p: Point = { x: 10, y: 20 };

type Name = string;
let myName: Name = "Alice";
```

**Interface:**
```typescript
interface Person {
	name: string;
	age: number;
}
let person: Person = { name: "Alice", age: 30 };
```

## Union Types

Union types allow a variable to be one of several types:

```typescript
let id: number | string;
id = 123;
id = "abc";
```

## Tuples

Tuples are fixed-length arrays with specific types for each element:

```typescript
let tuple: [string, number] = ["age", 30];
```

## String Enums

String enums define a set of named string constants:

```typescript
enum Color {
	Red = "RED",
	Green = "GREEN",
	Blue = "BLUE"
}
let c: Color = Color.Green;
```

## Numeric Enums

Numeric enums define a set of named numeric constants:

```typescript
enum Direction {
	Up = 1,
	Down,
	Left,
	Right
}
let d: Direction = Direction.Left;
```

---

## Classes

Classes are blueprints for creating objects with properties and methods.

```typescript
class Animal {
	name: string;
	constructor(name: string) {
		this.name = name;
	}
	speak(): void {
		console.log(`${this.name} makes a sound.`);
	}
}

const dog = new Animal("Rex");
dog.speak();
```

## Basic Generics

Generics allow you to write reusable, type-safe code.

```typescript
function identity<T>(value: T): T {
	return value;
}

let num = identity<number>(42);
let str = identity<string>("hello");
```

## Array Generics

You can use generics with arrays to specify the type of elements:

```typescript
let numbers: Array<number> = [1, 2, 3];
let strings: Array<string> = ["a", "b", "c"];
```

## Casting

Casting lets you tell TypeScript to treat a value as a specific type.

```typescript
let value: unknown = "hello";
let strLength = (value as string).length;
```

## Utility Types

TypeScript provides built-in utility types to transform types:

- `Partial<T>`: Makes all properties optional
- `Readonly<T>`: Makes all properties read-only
- `Pick<T, K>`: Selects a subset of properties
- `Record<K, T>`: Creates an object type with specified keys and values

```typescript
interface User {
	id: number;
	name: string;
}

let partialUser: Partial<User> = {};
let readonlyUser: Readonly<User> = { id: 1, name: "Sam" };
let pickedUser: Pick<User, "id"> = { id: 1 };
let record: Record<string, number> = { a: 1, b: 2 };
```

## Keyof

`keyof` gets the keys of a type as a union of string literals.

```typescript
interface Car {
	make: string;
	model: string;
}

type CarKeys = keyof Car; // "make" | "model"
```

## Decorators

Decorators are special annotations for classes and members (experimental feature, must be enabled in tsconfig).

```typescript
function Log(target: any, propertyKey: string) {
	console.log(`Property: ${propertyKey}`);
}

class Example {
	@Log
	name: string = "test";
}
```
- Typescript 5.0 introduced new decorator support with special types provided to standardize decorator use

## Functions

Functions can have typed parameters and return values.

```typescript
function add(a: number, b: number): number {
	return a + b;
}

const greet = (name: string): string => `Hello, ${name}`;
```