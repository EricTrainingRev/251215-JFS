# Rest Assured Quick Reference Guide

## Rest Assured Overview

REST Assured is a Java library for testing and validating REST APIs. It simplifies HTTP request construction, response validation, and supports BDD (Behavior-Driven Development) style syntax. It integrates well with JUnit/TestNG and supports JSON, XML, and other content types.

**Key Features:**
- Easy HTTP request/response handling
- Supports BDD syntax (`given-when-then`)
- Built-in assertions for status, headers, body, etc.
- Supports authentication, cookies, and session management
- Integrates with popular Java test frameworks

## Global Configurations

Global configurations allow you to set default behaviors for all REST Assured requests in your test suite. This includes base URI, base path, default headers, and authentication.

**Examples:**
```java
RestAssured.baseURI = "https://api.example.com";
RestAssured.basePath = "/v1";
RestAssured.port = 8080;
RestAssured.authentication = basic("user", "pass");
```

**Config Object:**
```java
RestAssured.config = RestAssuredConfig.config().logConfig(LogConfig.logConfig().enableLoggingOfRequestAndResponseIfValidationFails());
```

## Given

The `given()` method is used to set up the request specification. This includes query parameters, path parameters, headers, cookies, request body, and authentication.

**Examples:**
```java
given()
	.header("Authorization", "Bearer token")
	.queryParam("search", "keyword")
	.pathParam("id", 123)
	.cookie("sessionId", "abc123")
	.contentType(ContentType.JSON)
	.body("{\"name\":\"John\"}");
```
If using the Jackson or GSON data binding libraries you can pass an entity to the body method and it will be converted into JSON when the request is made.

## When

The `when()` method is used to specify the HTTP action to perform (GET, POST, PUT, DELETE, etc.). It follows the `given()` setup and triggers the request.

**Examples:**
```java
when()
	.get("/users/{id}")
	.post("/users")
	.put("/users/{id}")
	.delete("/users/{id}");
```

## Then

The `then()` method is used to validate the response. You can assert status codes, headers, response body, and more. Supports Hamcrest matchers for flexible assertions.

**Examples:**
```java
then()
	.statusCode(200)
	.header("Content-Type", equalTo("application/json"))
	.body("name", equalTo("John"))
	.body("items", greaterThan(0));
```

**Chaining Example:**
```java
given()
	.header("Authorization", "Bearer token")
	.body("{\"name\":\"John\"}")
when()
	.post("/users")
then()
	.statusCode(201)
	.body("id", notNullValue());
```