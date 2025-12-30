# Some test examples

## Testing Pyramid
Lower levels of testing ideally have a larger collection of tests than higher levels
![testing pyramd](testing%20pyramid.png)

## Unit Test
Testing a bit of code in isolation: it requires no other dependencies for its functionality, or if
there are any dependencies they are mocked/stubbed. The reason Unit Test is at the bottom (and therefore should have the largest collection of tests) is because of the specificity of data returned by your tests: if a test reveals a defect you know exactly where that defect exists in your code: the specific piece of code that was executed.

```javascript
// Unit test
function addNumbers(numOne, numTwo){
    return numOne + numTwo;
}

function testAddNumbers(){
    const result = addNumbers(1,2);
    if (result == 3){
        console.log("test passed!);
    } else {
        console.log("test failed!);
    }
}
```

## Integration Test
Testing code that is "integrated" with other bits of code. This can be a small connection like the example below, or it can be a more complex scenario (think API testing). In this kind of testing you lose out on the specificity provided by Unit Testing, but what you lose in specificity you gain in speed: it is much quicker to create integration tests (and still quite useful) than it is to make Unit Tests when there are dependencies that must be mocked.

Keep in mind that Integration tests are not lesser or in competition with Unit Tests: both can provide valuable information about your code and potential defects.

```javascript
function makeTitleCase(name){
    const capitalLetter = name[0].toUpperCase();
    return capitalLetter + name.slice(1);
}

function greetPerson(name){
    const nameTitleCased = makeTitleCase(name);
    return `Hello ${nameTitleCased}!`;
}

function testGreetPerson(){
    const name = "billy";
    const greeting = greetPerson(name);
    if (greeting == "Hello Billy!"){
        console.log("test passed!);
    } else {
        console.log("test failed!);
    }
}

```

## System Testing
System Testing is done when one or more features of an application are "complete": this means the testers can go in and interact with the feature as if they were an end user of the feature (think walking through the login process via the web page). System testing provides validation that the application correctly implements a feature across the board: all parts of the system are doing what they should. This makes it more encompassing than Integration testing, since with integration testing you are testing partial connections; System testing is for the entire system and all connecting components. This is true for Functional Testing

Non-Functional testing is also done at the system level; this is typically where you would do your various kinds of performance testing:
- Load Testing: testing the application at various levels of user activity
- Spike Testing: quickly ramping up users interacting with a specific part of the application to see how well it handles the influx of activity
- performance testing: testing aspects such as the time to complete the request and the reliability of requests made 
- Stress Testing: ramping up the system to find the break point of the application/deployment
- Endurance Testing: running the system over a long period of time to find defects that are not present or obvious in the short term

## Acceptance Testing
Acceptance Testing is where your subjective tests exists: these are things like "does the UI for the application actually look good?" "is this application intuitive to use?" "Does this application actually do what the stakeholders want?" Accessibility used to be a subjectively tested thing for webpages, but with modern testing tools and data aggregated over the years, accessibility has some solid benchmarks developers can aim to mee that makes it less of a subjective endeavor. 