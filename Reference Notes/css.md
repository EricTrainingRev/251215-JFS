# CSS Quick Reference Guide

## Overview of CSS

CSS (Cascading Style Sheets) is the language used to style and layout web pages. It controls the look and feel of HTML elements and separates content from presentation.

**Key Points:**
- CSS can be reused across multiple pages.
- Browsers read CSS to render styled web pages.

```css
/* Simple CSS example */
p {
	color: blue;
}
```

---

## CSS Box Model

The box model describes how elements are rendered as rectangular boxes on the page.

**Key Parts:**
- `content`: The actual content (text, image, etc.).
- `padding`: Space between content and border.
- `border`: Surrounds the padding (and content).
- `margin`: Space outside the border, separating from other elements.

```css
div {
	margin: 10px;
	padding: 20px;
	border: 1px solid #333;
}
```

---

## CSS Properties

Properties define what aspect of the element you want to style.

**Examples:**
- `color`: Text color
- `background-color`: Background color
- `font-size`: Size of text
- `margin`, `padding`, `border`: Spacing and borders
- `width`, `height`: Size of elements

```css
body {
	background-color: #f0f0f0;
	font-size: 16px;
}
```

---

## Responsive Web Design

Responsive design ensures web pages look good on all devices (desktops, tablets, phones).

**Key Points:**
- Uses flexible layouts, images, and CSS media queries.
- Adapts to different screen sizes and orientations.

**Tips for More Reactive Styles:**
- Use relative units like `em`, `rem`, `%`, and `vw/vh` instead of fixed `px` for font sizes, spacing, and layout.
- Use `max-width` and `min-width` to allow elements to scale.
- Use CSS Flexbox or Grid for flexible layouts.
- Set images and videos to `max-width: 100%` and `height: auto` for responsiveness.

```css
.container {
	display: flex;
	gap: 2rem;
	padding: 2vw;
}

h1 {
	font-size: 2.5rem;
}

.sidebar {
	width: 30%;
	min-width: 200px;
}

img {
	max-width: 100%;
	height: auto;
}
```

---

## Inline, Internal, and External Styling

There are three main ways to add CSS to HTML:

- **Inline:** Directly in the element using the `style` attribute.
- **Internal:** Inside a `<style>` tag in the HTML `<head>`.
- **External:** In a separate `.css` file linked to the HTML.

```html
<!-- Inline -->
<p style="color: green;">Inline style</p>

<!-- Internal -->
<style>
	p { color: purple; }
</style>

<!-- External -->
<link rel="stylesheet" href="styles.css">
```

---

## Class and ID Selectors

Selectors target HTML elements to apply styles. Class and ID selectors are commonly used for targeting specific elements.

- `.class`: Selects all elements with a given class.
- `#id`: Selects the element with a specific ID.

```css
.highlight {
	background: yellow;
}
#main {
	border: 2px solid blue;
}
```

---

## Sibling Selectors

Sibling selectors target elements that share the same parent.

- `element + element`: Adjacent sibling selector (selects the next sibling).
- `element ~ element`: General sibling selector (selects all following siblings).

```css
h2 + p {
	color: orange;
}
h2 ~ p {
	color: teal;
}
```

---

## Element Selectors

Element selectors target all elements of a given type.

```css
h1 {
	color: red;
}
ul {
	list-style: none;
}
```

---

## Advanced Selectors

Advanced selectors allow for more complex targeting:

- `element.class`: Element with a specific class
- `element, element`: Grouping selector
- `element element`: Descendant selector
- `element > element`: Child selector
- `*`: Universal selector

```css
p.note {
	font-style: italic;
}
h2, h3 {
	margin-bottom: 0.5em;
}
nav ul {
	list-style: none;
}
ul > li {
	padding: 4px;
}
* {
	box-sizing: border-box;
}
```

---

## Animations

CSS animations allow elements to change style over time.

```css
@keyframes fadeIn {
	from { opacity: 0; }
	to { opacity: 1; }
}

.fade-in {
	animation: fadeIn 2s ease-in;
}
```

---

## Flexbox

Flexbox is a layout model for arranging items in a container, even when their size is unknown or dynamic.

```css
.flex-container {
	display: flex;
	justify-content: space-between;
	align-items: center;
}
.flex-item {
	flex: 1;
	margin: 10px;
}
```

---

## CSS Grid

CSS Grid is a powerful layout system for creating complex, responsive grid-based designs.

```css
.grid-container {
	display: grid;
	grid-template-columns: 1fr 2fr;
	gap: 20px;
}
.grid-item {
	background: #eee;
	padding: 10px;
}
```

---

## CSS Variables

CSS variables (custom properties) allow you to store values for reuse throughout your stylesheets.

```css
:root {
	--main-color: #3498db;
	--padding: 16px;
}

.box {
	background: var(--main-color);
	padding: var(--padding);
}
```

---

## Media Queries

Media queries apply styles based on device characteristics (like width, height, orientation).

```css
@media (max-width: 600px) {
	body {
		background: lightgray;
	}
}
```