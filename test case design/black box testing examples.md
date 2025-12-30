# Black Box Testing Examples
Black Box testing is done without access to the underlying source code, so the requirements of the application, whether written, verbal, or implicitly understood, must be the driving force behind how you design your tests

## Use Case Testing
This is a useful way of organizing your tests when you do not have well-defined requirements, or when the requirements you do have are vague. Use Case testing is all about taking the features and requirements of an application and organizing them into "use-cases" that can be tested

Example Use Case:
- Name: Login Feature
- Description: Users should be able to login
- Actors: User, login service
- Preconditions: User has an account, service is running
- Expected Outcome: user logs in with his credentials
- Test data: valid email, valid password

Note: the example above would be the use case setup for a positive test, another could be made for a negative test

## Boundary Value Analysis
Boundary Value Analysis is a useful technique to employ when you have requirements that create natural "boundaries" within your application. Consider the following account registration requirements:
- Usernames
    - must be 5-15 characters long
    - must include uppercase, lowercase, and numeric characters

The first requirement for the username provides nice, clean boundaries we can work with: valid usernames should be 5-15 characters long, so we instantly know we have at least 4 potential usernames we can use for our tests:
- positive data
    - username 5 characters long
    - username 15 characters long
- negative data
    - username 4 characters long
    - username 16 characters long

With these four pieces of test data we know we need at least 4 tests: two positive tests to validate the username lowerbound and upperbound values are allowed, and two negative tests to validate the values just outside the lowerbound and upperbound values are rejected. If our tests pass using these four pieces of test data, we can be confident that we could substitute any value within the requirements bound for our positive tests, and any value outside of the boundary for our negative tests, and they would still pass.

## Equivalence Partitioning
The second requirement of the registration example feature above does not lend itself to natural boundaries; the username either meets the requirement or it does not. In this kind of scenario you can do a variation of boundary value analysis called Equivalence Partitioning. To do this, you first create generic categories to represent your data, starting with simple "is valid" and "not valid" categories.
- is valid
    - include uppercase, lowercase, and numeric characters
- not valid
    - missing uppercase character
    - missing lowercase character
    - missing numeric character

And with that you have your starting test data, and know you want to make at least four tests: one test with all the required characters present, three tests with one of those character types missing. The valid data should be accepted, the invalid data rejected. In this way we have set our positive and negative data to be representatives of their "class" of data. Our valid username is a representative of all possible valid usernames. Our negative data is a representative of all possible invalid usernames for its given category

## Error Guessing
This strategy for formulating tests is typically used when there are few requirements to work off, or if the tester has extensive knowledge of the application or similar applications and knows of the potential pain points where things can go wrong. In these instances, the tester's knowledge of the application, expected uses, stakeholder requirements, etc., are used in order for the tester to create tests that provide meaningful information.