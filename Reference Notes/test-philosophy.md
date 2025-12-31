# Test Philosophy Quick Reference Guide


## Testing Mindset

The testing mindset centers on finding problems rather than proving software works. Testers think like users, exploring real-world scenarios and usability to uncover weaknesses, edge cases, and vulnerabilities. They challenge assumptions and actively try to break the system, ensuring quality by verifying the application under various conditions. Clear documentation of defects and advocacy for the user’s experience are essential. While collaboration with developers is important, testers maintain an independent, critical perspective. Ultimately, the goal is to deliver a reliable, intuitive, high-quality product that meets stakeholder needs.

## Requirements
Requirements can vary widely, encompassing business, technical, regulatory, accessibility, and other arbitrary needs. They provide details about what should be included or excluded from a product. These requirements can take many forms, although there are some standardized methods for presenting them. Common formats include software requirement specifications, use cases, user stories, and non-functional specifications. Each of these formats helps ensure that all necessary aspects of the product are clearly defined and understood by developers, testers, and any other stakeholders.

## Test Objective
Test objectives, also known as "test goals", are the end-reasons for conducting testing activities. These objectives typically include evaluating work products to ensure they meet the required standards and identifying defects to improve the overall quality of the software. Ensuring coverage and compliance with specified requirements is another critical objective, as it helps maintain consistency and adherence to standards. Reducing risk by identifying potential issues early in the development process is also a key goal. Providing general information about the software's performance and behavior helps stakeholders make informed decisions. Ultimately, building confidence in the product or service is a fundamental objective, as it assures stakeholders that the software is reliable and meets their expectations.

## Quality Management
Despite the terms testing and quality assurance (QA) often being used synonymously, they are actually distinct concepts. Testing is a form of quality control (QC) that is product-oriented and corrective, focused on identifying and fixing defects in the product to achieve high levels of product quality. QA, on the other hand, is process-oriented and preventive, aiming to improve processes to ensure high quality results. This means that testing itself is a QC practice, whereas Q* involves implementing and improving processes, ensuring that good processes lead to good products. Test results are used in QC to fix defects, and in QA to provide feedback on process performance.

## Verification & Validation
Most testing can be categorized as either verification or validation These two categories of tests have different objectives:
- verification answers the question "are we building the product correctly?"
- validation answers the question "are we building the right product?"

For example, imagine you are on a team that has been tasked with building and testing a bike. Verification would involve checking that each component of the bike meets the specified design requirements and standards. This could involve checking the frame is made from the correct material, the brakes are designed properly, the correct number of gears are accommodated in the plan, etc. Essentially, verification is about confirming that the bike is being assembled according to any provided requirements through the use of static testing. On the other hand, validation would involve testing the bike in real-world conditions to ensure it meets the needs and expectations of the end user. This might include taking the bike for a test ride to confirm it provides a comfortable and safe riding experience, and that it performs well under various conditions such as different terrains and weather. Validation ensures that the final product is fit for its intended purpose and satisfies customer requirements through the use of dynamic testing.

## Defect vs Error vs Failure
A core goal of testing is to discover defects: a defect is any failed requirement or deviation of an expected outcome. This could be a business requirement not being met, a software feature not working correctly, gaining access to resources you are not supposed to, etc. Note that the terms defect and "bug" can be used interchangeably, but defect is the more formal way of describing deviations from expected results.

In software work, any mistake a developer adds to code, whether calling the wrong variable, forgetting to implement a business rule, or any other mistake, is called an error. It is errors that lead to defects being present in code.

Anytime a defect is executed/triggered in your application it will trigger one or more failures. Note that defects and failures represent the same thing, a deviation from the expected or required. The main difference is in how the defect is revealed: failures happen when a defec* is triggered in a active application (this can be user discovered in production or tester discovered in the testing environment) that causes the intended use of the application to deviate from the expected. This means that all failures are defects, but not all defects are failures. Some examples of defects that are not failures:
- aesthetic issues
- sub-par application performance (poor latency, throughput, etc.)
- incorrect documentation
- accessibility optimizations

## Automated Testing
Automated testing offers several advantages over manual testing. It is not subject to human error, ensuring more consistent and accurate results. Automated tests are quicker than manual testing, providing faster feedback and allowing for more frequent testing cycles. Although there is an initial upfront investment in setting up automated tests, it saves time in the long run by reducing the need for repetitive manual testing. Automated tests are reliable and can run 24/7, making them ideal for continuous integration and delivery pipelines. They can handle complex and large applications, ensuring thorough testing coverage.*Automated testing is particularly well-suited for unit, integration, and system testing. Automated Testing is also useful for dynamic testing: testing done on running software.

## Manual Testing
Manual testing has its own set of advantages and considerations. While it is subject to human error, this can be mitigated with thorough training and attention to detail. Manual testing may be slower than automated testing, but it allows for a more nuanced and flexible approach, especially when dealing with smaller or simpler applications or features. It requires less upfront investment and technical knowledge, making it more accessible for teams with limited resources. Manual testing is particularly well-suited for acceptance testing, where the focus is on ensuring the software meets the end-user's requirements and expectations and assessing subjective criteria that can not easily be automated (or automated at all). Manual Testing is also useful for static testing: testing done when software is not running. This kind of testing involves reviewing documentation, code syntax, and other auxiliary resources to the code itself.

## Testing Principles
- **Testing reveals defects, not their absence**
    - The discovery of zero defects does not imply that there are no defects in the tested software. It simply means that the testing performed did not uncover any issues. There could still be undetected defects that were not exposed by the specific tests conducted.
- **Exhaustive testing is impossible**
    -  It is impractical to test every possible scenario and input combination. Therefore, testing should be focused on critical features and requirements first. Prioritizing these areas ensures that the most important aspects of the software are thoroughly evaluated, reducing the risk of significant defects in key functionalities.
- **Test early**
    - The sooner testing is started, the earlier defects will be caught. Static testing, such as code reviews and inspections, should begin as soon as possible to identify issues early in the development process. Dynamic testing, which involves executing the code, should be started when feasible to uncover defects that may not be evident through static testing alone. Early testing helps in detecting and addressing defects promptly, reducing the cost and effort required for later fixes.
- **Defects cluster**
    - Any feature or requirement with one or more defects warrants extra testing. Defects tend to cascade, especially if the defect is at the start of any data transformation or if other features rely on the data involved in the defect. This means that a single defect can lead to multiple issues downstream, making it crucial to thoroughly test areas where defects have been identified to prevent further complications.
- **Tests wear out**
    - Also called the "pesticide paradox": over time, your tests will eventually exhaust all the defects they can find. When this happens, it is worth considering additional tests to accommodate the addition of new features or requirements. However, don't remove old tests when they stop discovering defects; you can still use them for regression testing. This ensures that previously fixed defects do not reappear and that the software remains stable as new changes are introduced.
- **Testing is contextual**
    - There is no overarching universal testing practice. Your test objects and objectives should determine how you approach the testing process. This means that the methods and strategies you use for testing should be tailored to the specific context of the software, including its features, requirements, and intended use. Adapting your testing approach to fit the unique aspects of each project ensures more effective and relevant testing outcomes
- **Absence of error fallacy**
    - Just because there are no defects does not mean your application was built correctly. All tests may pass, but the application may still fail to meet all client requirements. This highlights the importance of not only focusing on defect detection but also ensuring that the software aligns with the client's needs and expectations. Comprehensive testing should include validation against requirements to confirm that the application fulfills its intended purpose

## Positive Testing
Positive testing, also known as "happy path testing," involves designing test cases using test data that fully complies with the software's requirements. This valid data is then used as input for relevant actions, with the expectation that these actions will be successfully executed. In essence, the goal of a positive test is to confirm that when the software is provided with valid input, it performs as expected and completes the intended actions without any issues. This type of testing ensures that the software functions correctly under normal, expected conditions.

## Negative Testing
Negative testing, also known as "sad path testing," involves designing test cases using test data that does not conform to the software's requirements. This invalid or unexpected data is used as input to test how the software handles errors and edge cases. The goal of negative testing is to ensure that the software can gracefully handle invalid input and unexpected conditions without crashing or producing incorrect results. By intentionally providing invalid data, testers can check that the software has appropriate error handling mechanisms in place and that it remains stable and secure even when faced with adverse conditions. This type of testing is crucial for identifying potential vulnerabilities and ensuring the robustness of the software