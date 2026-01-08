# BDD-Gherkin-Cucumber Study Guide

## Behavior Driven Development

### BDD Intro
**Behavior Driven Development (BDD)** is the practice of performing development from the perspective of the end user. It takes into account the user experience, expectations, actions, and overall interaction with the application. This methodology emphasizes collaboration among developers, testers, and non-technical stakeholders to ensure that everyone has a shared understanding of the desired behavior of the application.

In **BDD**, the focus is on creating clear and concise specifications that describe how the application should behave in various scenarios. These specifications are often written in a natural language format that is easy for all team members to understand. This approach should influence the way the team thinks about all parts of the application, from the initial design to the final implementation. It encourages critically thinking about the user's journey and how each feature contributes to their overall satisfaction. By framing development tasks in terms of **User Stories** and **Acceptance Criteria**, **BDD** helps teams stay focused on the core features and requirements of the service being developed

### User Story
**User Stories** are structured to capture the perspective and needs of various types of users, such as customers, employees, new users, potential users, long-time users, etc. To create effective **User Stories**, a specific syntax is used to guide the process. Each **User Story** begins with the phrase **As a**, followed by the type of user, such as "customer," "employee," or "new user." This is followed by the phrase **I want**, which specifies the action the user wishes to perform, such as "to log in," "to log out," "to add a specific item to my shopping cart," "to scratch the furniture," etc. It is important to note that these **I want** statements should be specific when possible. The final part of the **user story** is the **So that** clause, which explains the reason or benefit behind the user's action. For example, "So that I can order my coffee," "So that I can save it for ordering later," or "So that I can get my owner to pay attention to me." This structure helps to ensure that each **User Story** is complete and provides a clear understanding of the user's goals and motivations. Some example **User Stories**:
- As a long-time customer, I want to register an account with my local coffee shop, so that I can earn rewards on my coffee purchases
- As a manager, I want to schedule employee shifts, so that the business is covered during all hours of operation
- As a cat, I want to scratch the furniture, so that my owner will pay attention to me

When creating **User Stories**, it is important to keep in mind the documentation will likely need to be changed or updated over time. Therefore, it is essential to use a tool that is flexible and allows for easy modifications to ensure that **User Story** information remains accurate and up-to-date

### Acceptance Criteria
Once **User Stories** are created (or at least the initial versions, as updates may be necessary), the next step is to define the steps the user must take in order to complete your **User Stories**. This is achieved through the use of **Acceptance Criteria**. **Acceptance Criteria** is a collection of actions the user takes to complete the **User Story**. These steps should be clear and specific, outlining the conditions that must be met for the **User Story** to be considered complete. These criteria help ensure that all team members have a shared understanding of what needs to be achieved and provide a foundation for creating tests

An example of **Acceptance Criteria** for a customer creating an account with a coffee shop:
- The customer can access the registration page from the coffee shop's website or app
- The registration form includes fields for name, email, password, and phone number
- The system sends a confirmation email upon successful registration
- The customer can log in using their email and password
- The customer can view their rewards balance and transaction history after logging in

## Cucumber Core Testing

### End to End Testing
**End-to-end (E2E)** testing involves validating that user actions can successfully complete **User Stories** by meeting the story's specified **Acceptance Criteria**, ensuring the system has the intended functionality and meets user needs. During **E2E** testing, **Acceptance Criteria** serve as the basis for test cases. Testers validate that each user action can be performed as described and that the system behaves as expected. By integrating **User Stories** and **Acceptance Criteria** into **E2E** testing, testers can comprehensively validate the system works as a whole, providing a seamless and functional user experience. This approach helps identify any gaps or issues that might not be apparent when testing individual components in isolation

### Cucumber Framework
**Cucumber** is a testing framework that can integrate **User Stories** and **Acceptance Criteria** into easily organized **E2E** tests. It makes use of plain language that can be understood by anyone working on the project (tester, developer, stakeholder, business analyst, marketing team, etc). At its core, **Cucumber** parses **Feature files** to determine the test **Scenarios** and then **maps the steps of those scenarios to executable code**. The parsing of data and mapping to executable code is facilitated through the plain text language **Gherkin**.

### Feature
**Cucumber** **Feature Files** provide a high-level description of a **User Story** or a group of related **User Stories**. They serve as blueprints for the behavior of the system from the user's perspective. Within the **feature file** the **Gherkin** keyword **Feature** should be used to label the contents of the file, and a description can be provided after the **Feature** declaration
```gherkin
Feature: User registration
    New users should be able to register with the coffee house
# File continues below
```

### Scenario
A **Cucumber** **Scenario** provides an explicit and direct description of a **User Story** being implemented. It outlines the specific steps and conditions under which the **User Story** is tested. **Scenarios** can represent both positive and negative tests, ensuring that the system behaves correctly when both paths are followed. Additionally, a **feature file** can contain multiple **Scenarios**, each addressing different aspects or variations of the **User Story**
```gherkin
Feature: User registration
    New users should be able to register with the coffee house

  Scenario: Users can register with valid User data
    # steps go here
  Scenario: Users can not register with invalid User data
    # steps go here
```

### Step Syntax
**Scenarios** in **Gherkin** use specific keywords to organize their acceptance criteria steps. The keyword **Given** indicates a starting point or precondition for executing the **Acceptance Criteria**. **When** represents an action that must be taken to complete the **Scenario**. **Then** describes the intended outcome of completing the **Acceptance Criteria** and should be written as normative statements, such as "Then the user should be registered with the coffee house." The keywords **And** and **But** can be used in place of **Given**, **When**, or **Then** when multiple steps of the same type occur in a row, making the steps easier to read. Additionally, a star icon **\*** can be used in place of any of the step keywords. Keep in mind these distinctions are purely syntax for the human reader: **Cucumber** makes no distinction of the intent between these step keywords. As far as the framework is concerned, these keywords simply indicate a new step has been reached in the **Scenario**
```gherkin
Feature: User registration
    New users should be able to register with the coffee house

  Scenario: Users can register with valid User data
    Given   the user is on the register page
    When    the user enters valid credentials
    Then    the user should be registered with the coffee house

  Scenario: Users can not register with invalid User data
    Given   the user is on the register page
    When    the user enters invalid credentials
    Then    the user should be notified the credentials are invalid
```

These steps are meant to be modular: instead of creating new steps for each scenario you can reuse steps that perform similar actions, when possible. To accommodate the need for new data in different runs you can have **Cucumber** inject your test data at runtime
```gherkin
  Scenario: Users can register with valid User data
    Given   the user is on the register page
    When    the user enters username "Javal1fe" and password "soSecur3"
    Then    the user should be told "account created successfully"

  Scenario: Users can not register with invalid User data
    Given   the user is on the register page
    When    the user enters username "invalid" and password "not secure"
    Then    the user should be told "account creation failed"
```
the syntax above tells **Cucumber** the String values need to be inject to the associated step methods. To link a method with a step the associated method is annotated with a step provided by **Cucumber**

```java
/*
    the three methods below are linked to the six steps written above: for each scenario, if there is any data that is unique to the
    scenario and the step in that scenario, Cucumber will provide it at run time. Note that which annotation you use is programatically irrelevant: the only benefit of matching the annotation with the step type is to make it clearer to the reader what step is being handled by the method. The @And annotation could be used for all three of these methods, and Cucumber would still match them correctly. This is 
    because the text of the step is used by Cucumber to match the step with the method, the Gherkin keyword simply tells the framework a new
    step has been reached
 */

@Given("the user is on the register page")
public void starting_step() {
    // setup is handled here
}

@When("the user enters username {string} and password {string}")
public void action_step(String username, String password) {
    // attempt to create account is handled here
}

@Then("the user should be told {string}")
public void result_step(String result) {
    // validation of results is handled here
}
```
By parameterizing your steps you can reuse them, cutting down on the total number of steps you need to implement. **Cucumber** has 11 different types it supports by default (taken from Cucumber documentation):
| Parameter Type  | Description |
| --------------- | ----------- |
| `{int}`         | Matches integers, for example `71` or `-19`. Converts to a 32-bit signed integer if the platform supports it.|
| `{float}`       | Matches floats, for example `3.6`, `.8` or `-9.2`. Converts to a 32 bit float if the platform supports it. |
| `{word}`        | Matches words without whitespace, for example `banana` (but not `banana split`). |
| `{string}`      | Matches single-quoted or double-quoted strings, for example `"banana split"` or `'banana split'` (but not `banana split`). Only the text between the quotes will be extracted. The quotes themselves are discarded. Empty pairs of quotes are valid and will be matched and passed to step code as empty strings. |
| `{}` anonymous  | Matches anything (`/.*/`). |
| `{bigdecimal}`  | Matches the same as `{float}`, but converts to a `BigDecimal` if the platform supports it. |
| `{double}`      | Matches the same as `{float}`, but converts to a 64 bit float if the platform supports it. |
| `{biginteger}`  | Matches the same as `{int}`, but converts to a `BigInteger` if the platform supports it. |
| `{byte}`        | Matches the same as `{int}`, but converts to an 8 bit signed integer if the platform supports it. |
| `{short}`       | Matches the same as `{int}`, but converts to a 16 bit signed integer if the platform supports it. |
| `{long}`        | Matches the same as `{int}`, but converts to a 64 bit signed integer if the platform supports it. |

### Cucumber Options
**Cucumber** requires specific configuration information to function correctly. The "features" configuration specifies where the **feature files** are located, which can include directories and individual files. If no feature file information is provided, **Cucumber** will scan the entire project for files. The "glue" configuration indicates where the code implementation of the **Scenario** steps are located, targeting packages and individual classes. Similarly, if no glue information is provided, **Cucumber** will scan the entire project for files. Although not technically required, "plugins" can be used to enhance tests and test reports. For example, the "pretty" plugin makes the CLI readout of test results easier to read, while the "html" plugin generates an HTML test report at the specified location

### Executing Tests
To execute Cucumber tests with Gradle, you have several options. If you are using a Cucumber/Gherkin plugin in your IDE, you can "execute" your feature files directly. Alternatively, you can create a test runner and facilitate test execution through the runner class. Another method is to use the Gradle "test" task to trigger your tests from the command line, which also allows for specifying individual tests to execute.

Note that if you have missing step implementations for your feature files suggested step methods will be generated for you: these can be used to jump-start creating the implementation steps for your tests

## Cucumber Auxiliary Features

### Scenario Outline & Examples
Often **Scenarios** will need to be run multiple times with the only difference being the data used in the steps. In these instances you can create a **Scenario Outline**; these types of **Scenarios** are the same as your regular **Scenarios**, but they also tell **Cucumber** you have a collection of data you need to use with the **Scenario Outline**. **Cucumber** will run your **Scenario Outline** once for each collection of data you provide in an **Examples** table. **Cucumber** will look for the column titles of your data wrapped in diamond brackets and replace them with the data in the data table. **Cucumber** will run the **Scenario Outline** below two times: once for each row of data in the **Examples** table
```gherkin
Scenario Outline: user registration should enforce business rules
    Given   the user is on the registration page
    When    the user enters "<username>"
    When    the user enters "<password>"
    Then    the user should receive "<result>" message

Examples
|username|password|result|
|valid   |valid   |success|
|invalid |valid   |failure|
```

### Background
**Scenarios** will often have some sort of shared pre-condition (one or more **Given** statement) that needs to be set up as part of the **Scenario** before the **Acceptance Criteria** can be completed. When the **Scenarios** in a **feature file** share starting conditions you can use a **Background** section to tell **Cucumber** what steps to enact before each **Scenario** in the file. If an action is not shared by ALL **Scenarios** in the **feature file** then the step should go in the individual **Scenario** it applies to
```gherkin
Background: Users need to be logged in to use the coffee house app
    Given   The user is logged in to their coffee house account

Scenario: check account reward points
    When    the user clicks the My Rewards button
    ...

Scenario: check order status
    When    the user clicks the Check Order button
    ...
```

### Rule
Added in version 6 of **Cucumber**, the **Rule** keyword can be used to indicate a specific business rule/requirement that is being addressed in the **feature file**. If a **Feature** being tested has a large collection of associated business rules then the **Rule** keyword can be used to specify what **Scenarios** address specific business rules
```gherkin
Feature: User Registration
    Users can register with the coffee house to track their purchase history and accumulate points

    Rule: Usernames must be unique
    Scenario: trying to register with a non-unique username fails
        Given   the user is on the registration page
        When    the user provides a non-unique username
        Then    the user should be alerted the name is already taken

    Rule: Usernames must include specific types of characters
    Scenario: trying to register with a username that does not include the required characters fails
        Given   the user is on the registration page
        When    the user provides a username without all the required characters
        Then    the user should be alerted the name is missing one or more required characters
```

### Example
In **Cucumber** the **Scenario** and **Example** keywords are synonymous: they are interchangeable in your **feature files**. Similar to the steps they organize, they provide varied syntactical understanding to the programmer, but **Cucumber** views them as the same: an indicator of a new test
```gherkin
Feature: User Registration
    Users can register with the coffee house to track their purchase history and accumulate points

    # Since all business rules are being adhered to Scenario is a reasonable indicator to use
    Scenario: users can register with valid credentials
        Given   the user is on the registration page
        When    the user provides valid credentials
        Then    the user should be informed they registered successfully

    # Since the unique username rule is being broken the Rule and Example keywords can be used to specify what is being tested
    Rule: Usernames must be unique
    Example: trying to register with a non-unique username fails
        Given   the user is on the registration page
        When    the user provides a non-unique username
        Then    the user should be alerted the name is already taken

    # Since the specific character types rule is being broken Rule and Example are again reasonable keywords to use
    Rule: Usernames must include specific types of characters
    Example: trying to register with a username that does not include the required characters fails
        Given   the user is on the registration page
        When    the user provides a username without all the required characters
        Then    the user should be alerted the name is missing one or more required characters
```

### Hooks
**Given** statements are used to set up **Scenario** starting conditions, but sometimes further setup is needed that goes beyond the bounds of the **Scenario** being tested. For instance, in order for a user to be logged into a service, their account credentials need to be present in the service system. These kinds of pre-conditions are not always manageable using just your **Given** statements, and if they were handled in your **Given** statements the readability of your **Scenario** would be diminished. In a similar vein, you may want to perform some action based on the results of your **Scenarios**, which would not make sense to have defined within each of the individual **Scenarios**. For instance, if testing a web based application, you may want to take a screen shot of the web page to get a visual of its state if a step fails: this is not something that can easily be added to each **Scenario** in the **feature file** 

All the examples in the previous paragraph are reasonable candidates to be handled in **Hook** steps. **Cucumber** **Hooks** have three primary categories:
- **Global Hooks**
- **Scenario Hooks**
- **Step Hooks**

**Global hooks** are methods that execute a single time either before or after all **Scenarios** are executed. These **hooks** can be used as setup or tear down methods that only need to happen one time (think expensive resource creation, static resource creation, or logging done after all tests are run)
```java
// Note the methods are static
@BeforeAll
public static void beforeAll() {
    // Runs before all scenarios
}

@AfterAll
public static void afterAll() {
    // Runs after all scenarios
}
```

**Scenario hooks** are methods that execute for each individual **Scenario**, so if you have two **Scenarios** in your test suite, your **Scenario hooks** will trigger twice. Similar to **global hooks**, they can trigger before or after a **Scenario** runs, which makes them useful for setting up and resetting dynamic test data, and for performing post failure **Scenario** actions like taking a screen shot of a web page. **After** hooks can also be passed a `Scenario` object to check values such as the status of the **Scenario**, steps executed, and any error messages generated
```java
// Note the methods are instance scoped
@Before
public void doSomethingBefore() {
  // performs one or more actions before each Scenario
}

@After
public void doSomethingAfter(Scenario scenario){
    // performs one or more actions after each Scenario
}
```

Finally, **step hooks** can be used to trigger actions before and after individual **Scenario** steps. Both the pre and post option can take in a `Scenario` object as an argument
```java
// These are also instance scoped
@BeforeStep
public void doSomethingBeforeStep(Scenario scenario){ }

@AfterStep
public void doSomethingAfterStep(Scenario scenario){ }
```

### Tags
**Cucumber** supports **tags** as a way to organize and document your **feature files**. The following **Gherkin** keywords support tagging:
- **Feature**
- **Rule**
- **Scenario**
- **Scenario Outline**
- **Examples**

**Tags** can be used to specify what resources to test, and they can also be used to create **conditional hooks**: the following **Scenario hook** will only trigger after **Scenarios** tagged with `@someTag`:
```java
@After("@someTag")
public void doSomethingAfter(Scenario scenario){
}
```
When applying **tags** you need to keep in mind that viable **Gherkin** resources inherit tags from their parent resources: for instance, if you **tag** a **Feature** with `@registration` all **Rule**, **Scenario**, **Scenario Outline**, and **Examples** associated with the **Feature** will inherit the `@registration` tag. Similarly, **tags** on a **Scenario Outline** will be inherited by associated **Examples**

## Cucumber Integrations

### Junit Integration
**Cucumber** is a framework that works with multiple programming languages, and in some of those languages the framework functions well as a standalone testing framework. Working as a standalone framework in Java is possible, but not ideal: other frameworks such as Junit and TestNG are better suited to drive the testing process with **Cucumber** along for the ride. If you need to use **Cucumber** by itself there is a `Main` class that can be used as the entry point for the test, but it can take a substantial amount of setup that is easier to manage with another test framework. 

**Cucumber** and Junit work well together: Junit provides many useful integrations with other 3rd party software, and **Cucumber** can facilitate testing that uses your **feature files** and step implementations. Depending on the version of Junit you are using you either need the `cucumber-junit` dependency (Junit4) or `cucumber-junit-platform-engine` dependnecy (Junit5). This example will use Junit 5 moving forward
```groovy
dependencies {
    // https://mvnrepository.com/artifact/io.cucumber/cucumber-java
    testImplementation 'io.cucumber:cucumber-java:7.33.0'
    // https://mvnrepository.com/artifact/io.cucumber/cucumber-junit-platform-engine
    testImplementation 'io.cucumber:cucumber-junit-platform-engine:7.33.0'
    // https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter
    testImplementation 'org.junit.jupiter:junit-jupiter:5.14.0'
    // https://mvnrepository.com/artifact/org.junit.platform/junit-platform-suite
    testImplementation 'org.junit.platform:junit-platform-suite:1.14.1'
    // https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java
    implementation 'org.seleniumhq.selenium:selenium-java:4.39.0'
}
```

Once you have the dependencies, you create a test runner where any shared test resources can be configured

```java
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectPackages({"selenium.steps", "features"})
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "selenium.steps")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty, html:target/cucumber-report.html")
public class CucumberRunner {
}
```
Any resources for your steps can be created in your test runner, and when you are ready to execute your tests you target the runner

### Test Reports
**Cucumber** has multiple built-in plugins to handle generating test results, two useful ones to keep in mind are **pretty** and **html**. The **pretty** plugin will make **Cucumber** generate an easier to read to report in the CLI, which is useful for intermittent testing, or one off tests. The **html** plugin will generate an HTML test report at the location you specify
