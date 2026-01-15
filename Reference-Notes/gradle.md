# Gradle Quick Reference Guide

## What is Gradle?

Gradle is a powerful build automation tool used for building, testing, and deploying software. It supports multiple languages, but is most commonly used for Java projects.

**Key Points:**
- Gradle uses Groovy or Kotlin DSL for configuration.
- It automates compiling, testing, packaging, and deploying code.

---

## Installation

You can install Gradle via package managers or manually:

- **Windows:** Use [Chocolatey](https://chocolatey.org/) or download from the [Gradle website](https://gradle.org/install/).
- **macOS:** Use Homebrew: `brew install gradle`
- **Linux:** Use SDKMAN: `sdk install gradle`

Verify installation:
```bash
gradle --version
```

---

## Configure Java Project

To set up a basic Java project, use the following structure and configuration:

**Directory Structure:**
- `src/main/java` — Java source files
- `src/test/java` — Test source files

**Sample build.gradle:**
```groovy
plugins {
	id 'java'
}

group = 'com.example'
version = '1.0.0'

repositories {
	mavenCentral()
}

dependencies {
	testImplementation 'org.junit.jupiter:junit-jupiter:5.8.1'
}

test {
	useJUnitPlatform()
}
```

---

## Dependency Management

Gradle uses repositories and the `dependencies` block to manage libraries:

- `implementation`: For main dependencies
- `testImplementation`: For test dependencies
- `runtimeOnly`: only used at runtime

**Example:**
```groovy
dependencies {
	implementation 'com.google.guava:guava:31.0.1-jre'
	testImplementation 'org.junit.jupiter:junit-jupiter:5.8.1'
}
```

---

## Scripts and Tasks

Gradle tasks automate build steps. You can use built-in tasks or define your own. When creating your own tasks use `doFirst` and/or `doLast` for your custom instructions.

**Common Tasks:**
- `gradle build` — Build the project
- `gradle test` — Run tests
- `gradle clean` — Remove build files

**Custom Task Example:**
```groovy
task hello {
	doLast {
		println 'Hello, Gradle!'
	}
}
```

---

## Plugins

Plugins extend Gradle's functionality. The most common is the Java plugin, but there are many others for code quality, packaging, and deployment.

**Applying Plugins:**
```groovy
plugins {
	id 'java'
	id 'application'
}

application {
	mainClass = 'com.example.Main'
}
```