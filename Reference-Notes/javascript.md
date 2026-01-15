# JavaScript Quick Reference Guide

## What is JavaScript?

JavaScript is a versatile, high-level programming language primarily used for web development. It enables interactive and dynamic content in browsers, and is also used for server-side development (Node.js).

**Key Points:**
- Runs in browsers and on servers (Node.js)
- Supports object-oriented, functional, and imperative styles
- Dynamically typed and interpreted

```javascript
console.log('Hello, JavaScript!');
```

---

## Datatypes

JavaScript supports several basic datatypes:

- `Number`: Numeric values (e.g., `42`, `3.14`)
- `String`: Text (e.g., `'hello'`, `"world"`)
- `Boolean`: `true` or `false`
- `Null`: Intentional absence of value
- `Undefined`: Variable declared but not assigned
- `Object`: Key-value pairs, arrays, functions
- `Symbol`: Unique identifiers
- `BigInt`: Large integers

```javascript
let num = 10;
let str = "hello";
let isActive = true;
let obj = { name: "Alice" };
let arr = [1, 2, 3];
```

---

## Variable Scopes

Scope determines where variables are accessible:

- **Global scope:** Accessible everywhere
- **Function scope:** Accessible only within a function
- **Block scope:** Accessible only within a block (`{ ... }`)
- **Lexical scope:** available to an inner function

```javascript
var globalVar = "I am global";
function testScope() {
	var functionVar = "I am function-scoped";
	if (true) {
		let blockVar = "I am block-scoped";
	}
}
// Lexical scope example
function outer() {
	let outerVar = 'outer';
	function inner() {
		console.log(outerVar); // 'outer' is accessible here
	}
	inner();
}
```

---

## let and const

`let` and `const` are modern ways to declare variables:

- `let`: Block-scoped, can be reassigned
- `const`: Block-scoped, cannot be reassigned

```javascript
let count = 5;
count = 10; // OK

const PI = 3.14;
// PI = 3.15; // Error
```

---

## Type Coercion

JavaScript automatically converts values between types when needed (type coercion):

- `"5" + 2` results in `'52'` (string)
- `"5" - 2` results in `3` (number)
- `true + 1` results in `2`

Use `===` for strict equality (no coercion), `==` for loose equality (with coercion).

```javascript
console.log("5" == 5);   // true
console.log("5" === 5);  // false
```

---

## Arrays

Arrays store ordered lists of values:

```javascript
let fruits = ["apple", "banana", "cherry"];
console.log(fruits[1]); // "banana"
fruits.push("date");
console.log(fruits.length); // 4
```

---

## Functions

Functions are reusable blocks of code:

```javascript
function greet(name) {
	return "Hello, " + name;
}

const add = (a, b) => a + b;

console.log(greet("Sam"));
console.log(add(2, 3));
```

---

## The "this" Keyword

`this` refers to the context in which a function is called:

- In global scope, `this` refers to the global object (window in browsers)
- In object methods, `this` refers to the object
- In arrow functions, `this` is inherited from the parent scope

```javascript
const person = {
	name: "Alex",
	greet: function() {
		console.log("Hi, " + this.name);
	}
};
person.greet(); // "Hi, Alex"

function show() {
	console.log(this);
}
show(); // global object
```

---

## Selecting Elements from the DOM

JavaScript can select elements from the HTML document using various methods:

- `document.getElementById('id')`: Selects a single element by ID
- `document.querySelector('selector')`: Selects the first element matching a CSS selector
- `document.querySelectorAll('selector')`: Selects all elements matching a CSS selector (returns a NodeList)

```javascript
const title = document.getElementById('main-title');
const firstItem = document.querySelector('.item');
const allItems = document.querySelectorAll('.item');
```

---

## DOM Manipulation

You can change the content, attributes, and style of DOM elements:

- Change text: `element.textContent = 'New text';`
- Change HTML: `element.innerHTML = '<b>Bold</b>';`
- Change attribute: `element.setAttribute('src', 'image.png');`
- Change style: `element.style.color = 'red';`

```javascript
const para = document.querySelector('p');
para.textContent = 'Updated text!';
para.style.fontWeight = 'bold';
```

---

## Events and Listeners

JavaScript responds to user actions using events and listeners:

- Add a listener: `element.addEventListener('event', handler)`
- Common events: `click`, `input`, `submit`, `mouseover`, etc.

```javascript
const button = document.querySelector('button');
button.addEventListener('click', function() {
	alert('Button clicked!');
});
```

---

## Bubbling & Capturing

When an event occurs, it travels through the DOM in two phases:

- **Capturing phase:** Event moves from the root down to the target element
- **Bubbling phase:** Event bubbles up from the target to the root (default)

You can specify the phase with the third argument of `addEventListener`:

```javascript
element.addEventListener('click', handler, true); // Capturing
element.addEventListener('click', handler, false); // Bubbling (default)
```

Most event listeners use bubbling by default.

---

## Fetch API

The Fetch API is used to make HTTP requests in modern JavaScript. It returns a Promise. You can pass a second argument to `fetch` to specify the HTTP method, headers, and body (for POST, PUT, etc.):

```javascript
fetch('https://api.example.com/data', {
	method: 'POST', // or 'PUT', 'DELETE', etc.
	headers: {
		'Content-Type': 'application/json',
		'Authorization': 'Bearer TOKEN'
	},
	body: JSON.stringify({
		name: 'Alice',
		age: 30
	})
})
.then(response => response.json())
.then(data => {
	console.log(data);
})
.catch(error => {
	console.error('Error:', error);
});
```

---

## Promises

A Promise represents a value that may be available now, later, or never. It is used for asynchronous operations.

**States:**
- Pending
- Fulfilled
- Rejected

```javascript
let promise = new Promise((resolve, reject) => {
	setTimeout(() => resolve('Done!'), 1000);
});

promise.then(result => console.log(result)); // 'Done!'
```

---

## async and await Keywords

`async` and `await` simplify working with Promises, making asynchronous code look synchronous.

- `async` marks a function as asynchronous (returns a Promise)
- `await` pauses execution until the Promise resolves

```javascript
async function fetchData() {
	try {
		const response = await fetch('https://api.example.com/data');
		const data = await response.json();
		console.log(data);
	} catch (error) {
		console.error('Error:', error);
	}
}

fetchData();
```

---

## Template Literals

Template literals allow for multi-line strings and embedded expressions using backticks (`` ` ``):

```javascript
const name = 'Sam';
const greeting = `Hello, ${name}!`;
console.log(greeting); // Hello, Sam!

const multiline = `This is line 1
This is line 2`;
```

---

## Arrow Functions

Arrow functions provide a concise syntax for writing functions. They do not have their own `this` binding.

```javascript
const add = (a, b) => a + b;
const square = x => x * x;

// With no parameters
const sayHi = () => console.log('Hi!');
```

---

## Closures

A closure is a function that remembers its outer variables even after the outer function has finished executing.

```javascript
function makeCounter() {
	let count = 0;
	return function() {
		count++;
		return count;
	};
}

const counter = makeCounter();
console.log(counter()); // 1
console.log(counter()); // 2
```

---

## Node.js

Node.js is a runtime environment that allows you to run JavaScript on the server. It provides modules for interacting with the file system, networking, and more.

**Key Points:**
- Run JavaScript outside the browser
- Use `require()` to import modules
- Commonly used for backend development

**Modern Module Syntax (ES Modules):**
- Use `import` and `export` instead of `require()` and `module.exports`.
- Supported in Node.js with `.mjs` files or by setting `"type": "module"` in `package.json`.

```javascript
// math.js
export function add(a, b) {
	return a + b;
}

// main.js
import { add } from './math.js';
console.log(add(2, 3)); // 5
```

```javascript
// hello.js
console.log('Hello from Node.js!');

// Run in terminal:
// node hello.js
```

---

## npm

npm (Node Package Manager) is the default package manager for Node.js. It is used to install, share, and manage dependencies.

**Common Commands:**
- `npm init` — Create a new package.json
- `npm install package` — Install a package
- `npm install` — Install all dependencies listed in package.json
- `npm run script` — Run a script defined in package.json

```bash
npm init -y
npm install express
npm start
```