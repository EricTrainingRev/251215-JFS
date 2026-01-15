# HTML Quick Reference Guide

## Overview of HTML

HTML (HyperText Markup Language) is the standard language for creating web pages. It describes the structure and content of a webpage using markup tags. The DOM (Document Object Model) is the browser's representation of the HTML page as a tree of objects, allowing scripts to interact with and modify the content.

**Key Points:**
- HTML is a markup language, not a programming language.
- It structures content for the web (text, images, links, etc.).
- Browsers read HTML and build the DOM to display web pages.
- The DOM lets JavaScript change the document structure, style, and content.

```html
<!-- A simple HTML example -->
<p>Hello, world!</p>
```

---

## HTML Document Structure

Every HTML document has a basic structure. Here’s a minimal example:

```html
<!DOCTYPE html>
<html>
    <head>
        <title>Page Title</title>
    </head>
    <body>
        <h1>Heading</h1>
        <p>Paragraph text.</p>
    </body>
</html>
```

**Key Parts:**
- `<!DOCTYPE html>`: Declares the document type.
- `<html>`: Root element.
- `<head>`: Metadata, links, title.
- `<body>`: Visible page content.

---

## HTML Tags

Tags are the basic building blocks of HTML. Most tags have an opening `<tag>` and closing `</tag>`, but some are self-closing (void tags).

**Tag Types:**
- Opening/closing tags: `<p>...</p>`, `<div>...</div>`
- Self-closing tags: `<img>`, `<br>`, `<hr>`, `<input>`

```html
<div>
    <p>This is a paragraph inside a div.</p>
    <img src="logo.png" alt="Logo">
</div>
```

---

## Common Tags

Some tags are used very frequently in web development:

- `<h1>` to `<h6>`: Headings
- `<p>`: Paragraph
- `<a>`: Link
- `<img>`: Image
- `<ul>`, `<ol>`, `<li>`: Lists
- `<div>`: Generic container
- `<span>`: Inline container
- `<br>`: Line break

```html
<h1>Main Heading</h1>
<p>This is a paragraph.</p>
<a href="https://example.com">Visit Example</a>
<ul>
    <li>Item 1</li>
    <li>Item 2</li>
</ul>
```

---

## Elements and Attributes

Elements are the building blocks of HTML, defined by tags. Attributes provide additional information about elements and are always included in the opening tag.

**Common Attributes:**
- `href`: Specifies the URL for links (`<a>`)
- `src`: Image source (`<img>`)
- `alt`: Alternative text for images
- `id`: Unique identifier
- `class`: Class name(s) for CSS/JS

```html
<img src="logo.png" alt="Site Logo" width="100" height="100">
<a href="https://www.example.com" target="_blank">Open in new tab</a>
```

---

## Inline and Block Elements

HTML elements are either block-level or inline-level:

- **Block elements** (e.g., `<div>`, `<h1>`, `<p>`, `<ul>`) start on a new line and take up the full width available.
- **Inline elements** (e.g., `<span>`, `<a>`, `<img>`, `<strong>`) do not start on a new line and only take up as much width as necessary.

```html
<div>
    <span>This is inline</span>
    <p>This is block</p>
</div>
```

---

## Input Elements and Input Types

Input elements allow users to enter data. The `<input>` tag supports many types for different kinds of data entry.

**Common Input Types:**
- `text`: Single-line text
- `password`: Password field
- `email`: Email address
- `number`: Numeric input
- `checkbox`: Checkbox
- `radio`: Radio button
- `submit`: Submit button

```html
<form>
    <input type="text" placeholder="Your name">
    <input type="email" placeholder="Your email">
    <input type="password" placeholder="Password">
    <input type="checkbox"> I agree
    <input type="submit" value="Send">
</form>
```