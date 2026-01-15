## DevOps

### DevOps Introduction
Software Development and Operations (DevOps) is a methodology that combines the development, deployment, and maintenance of code into a single, streamlined process. Ideally, this process is automated as much as possible. There are 5 general steps to Devops:
1. Source code Control: Producing (writing) code and pushing to a repository
    - you should already be familiar with this step, it is just the creation of your code (following TDD and utilizing BDD) and publishing it to a central repository
2. Building and Testing Automation: Test basic functionality of code (Generally unit testing) and create a new, working build
    - you should be testing your code as you develop, but this is the final, overarching test. This round of testing is the one you want to generate documentation and reports from for either your client or other developers to see
3. Deploying to Staging: Deployment of working build to a temporary environment
    - This is a pre-configured environment where you can test the entirety of your application without affecting your production environment
4. Acceptance Testing: Undergo other more complex tests (systems, integration) within temporary environment
    - think of this as the final, official BDD test. This is where the entirety of the (supposedly) working application is put to the test. Again, it is from this test you will want to save your generated report and have it available to either the client or other developers
5. Deployment of Build: Migrate working build to Production environment accessible by end users
    - this is the actual deployment of your product

If you are developing with an Agile Mindset there are three practices to know that assist in the process of creating a smooth DevOps pipeline
- Continuous Integration
    - This is the practice of regularly and consistently merging code into a central repository. It also involves reviewing the code to make sure the integration is as smooth as possible
- Continuous Delivery
    - This is the practice of automating the DevOps pipeline as much as you can. This means once your code is merged into the central repository it is downloaded and built/tested in a staging environment. This means steps 1-3 of the DevOps process should be automated, and step 4 should be too if you can manage it, though this is not always possible. Deploying to the production environment (step 5) should be done manually, since step 4 may reveal bugs you need to fix before deployment to production
- Continuous Deployment
    - Continuous Deployment is the process by which the entirety of the DevOps pipeline is automated, including deployment to production. You can think of it as the all encompassing Agile practice of DevOps, with each other practice being a subset of it

### Continuous Integration
Continuous Integration (CI) is the most fundamental step in creating an autonomous development pipeline. CI is achieved by the practice of consistently merging code into a central repository. More importantly, CI benefits greatly from the inclusion of rigorous testing as part of your CI process. Particularly important are unit and integration testing

DevOps is about automating and streamlining the parts of software development that get the developers feedback. CI married with testing is the first step to fully realizing an autonomous development pipeline. Each time a developer completes some amount of work and merges that work with the repository, each unit of that new code is tested, and then that new code is integrated and tested with the rest of the code. If testing is done well, this should provide rapid feedback about defects as each module develops. Continuous Integration establishes the foundation for an automated DevOps pipeline because it provides the following benefits:
 - Ensures the entire team works on the most up to date code
    - Frequently pushing code allows developers to account for changes performed by other team members quickly.
 - Detects broken builds quickly
   - If problems arise, version control software can help detect the root cause or rollback changes when necessary
 - Code can be tested easily by creating separate test or development branches based on the main code
 - Reduces risk in development when a large codebase has already been established
 - Reduces the overall amount of defects in a project

### Continuous Delivery
Continuous Delivery is a paradigm in which the building, management and testing of produced software is automated such that deployments can be performed at the push of a button. Continuous Delivery seeks to automate every possible step up to but not including deployment. It depends on CI and is a stepping stone on the way to Continuous Deployment (a fully automated development pipeline). Since we don't include deploying the product we can still preform final user testing, and/or leave the production deployment to a regular schedule.

![cd1](cd1.png)

### Continuous Deployment
Continuous Deployment (CD) advances continuous delivery by also automating the deployment of software to production environments. CD refers to the entire automated development pipeline including merging of code, testing, staging, and finally, deployment. As changes are merged into the central repository, they are already on their way to the end users

![cd2](cd2.png)

Benefits of CD:
 - Rapid development process
 - Rapid feedback
 - Smaller and less risky releases
 - Regular updates offering users improvements

Costs of CD:
 - Requires substantial initial investment
   - Money
   - Time
   - Major paradigm shift
 - Requires continuous investment for maintaining pipeline
 - Documentation, communication, coordination become even more important

## Static Code Analysis Tools
Static testing is common in the DevOps process, and there are code quality tools that help you find code "smells" in your application. These are things like:
- Data security issues
- Bugs
- confusing code
- redundant code
- unused imports
- empty code blocks
- etc.

Most IDEs have code quality tools built in, but these can provide more in-depth analysis of your code:
- SonarQube IDE: an IDE Extension that provides powerful linting capabilities for free
- SonarQube Cloud: a SaaS solution to provide more in-depth linting solutions for projects. You connect your remote repo to the service in order to benefit from it. Is a paid service with some free tier options


## Jenkins

### Introduction to Jenkins
Jenkins is a popular open source DevOps tool: it allows you to create a DevOps pipeline where your pushes to the main github repo of your project will trigger Jenkins to clone your code to your EC2, test it, build it, and run it (There are other use cases, of course, but this is closest to how we can use it in training). There are many steps involved, and not all are necessary depending on the type of program you are running or the level of automation you want in your Continuous Delivery DevOps practice.

A typical Jenkins instance will have a main controller that facilitates your DevOps operations and then worker nodes that actually execute your jobs (this is configured in the Jenkins main controller itself), but for small DevOps jobs the main controller can handle executing your **Jobs** itself

### Jenkins Jobs and Builds
A Jenkins **Job** and **Build** represent different aspects of a DevOps process. 

A **Job** is what we call one or more associated tasks we configure Jenkins to execute to facilitate our DevOps pipeline. This can be actions such as cloning a repository, running tests, pushing test reports to a remote location, emailing notifications and/or results to designated individuals, starting or restarting applications depending on if a build succeeds or not, or any other action you want to happen as part of the DevOps process. Jenkins supports different configuration options for your jobs, two of the main options being a **Freestyle** and **Pipeline** job:
- **Freestyle** jobs are set up through the Jenkins UI Directly, tend to involve fewer steps, and are easier to set up than other job options. That being said, they don't scale as well for more complex DevOps jobs, so they tend to be used for smaller DevOps jobs
- **Pipeline** jobs have their initial configuration set up in the Jenkins UI, but the actual steps and actions involved in the job are typically saved in a **Jenkinsfile** that is saved in the SCM repository. The **Jenkinsfile** is written in Groovy Syntax, and it makes it much easier to determine the actions and agents involved in the actions that need to be taken. This allows for scaling the work done in a DevOps process to a greater degree than a **Freestyle** job because the Groovy syntax allows for configuring your DevOps job programmatically, as opposed to configuring it via an options UI

A **Build** is what we call the output of a Jenkins **Job**. Any compiled code, test results, build artifacts, and **Job** outputs (job results, logs generated, etc) are considered part of the **Build**. The resources created in a **Build** can be used further down the line in the DevOps process, or they can be archived for logging purposes

### Creating a DevOps Pipeline (CICD pipeline) With Jenkins
**Note**: this example will focus on creating a freestyle project and uses the recommended default plugins

Configuration Options:
- **General**
    - This is where you can set information such as the description, github project url, and determine how many previous builds to keep
- **Source Code Management**
    - this is where you set what repository you want to clone for the job, and where you provide the git credentials necessary to interact with the repository using Jenkins managed credentials
- **Build Triggers**
    - if you want your job to trigger automatically you determine how that is done in this section. This can be a Github web hook, completion of another job, timer based, and more
- **Build Environment**
    - this is where you can provide extra information to Jenkins to configure the environment Jenkins will execute the job in: these are things like environment variables that only exist during the job, instructions for whether to delete old workspaces or not, and what to do if the job times out
- **Build Steps/Post Build Steps**
    - these are the actual commands Jenkins will execute during your Job execution. Build steps execution happens before the Build is completed, Post-Build steps happen after the build is completed

### Jenkins Credentials Management
Many Jenkins plugins abstract away using third party tools like Git and SSH. In order for these plugins to work properly they have to be provided proper credentials: Jenkins Credentials Management allows you to provide this data to the plugins will keeping them hidden from plain-text use in your Jobs, though many credential details will be available to users that can interact with the Jenkins instance. Depending on what kind of credentials a plugin needs, you will have to change the type of credential being saved in the management tool.

### Jenkins Plugins and Integrations
Plugins and Integrations are ways of modifying the default implementation of a Jenkins instance. Plugins are direct add-ons that extend the functionality of your Jenkins software. These can change the way you interact with the UI in Jenkins itself and modify the behavior of your Jobs. 

Integrations are third party software the connect with Jenkins to help facilitate your Jobs, but are not a part of Jenkins directly. Git is a good example of an Integration: Jenkins has a lot of compatibility with Git, and even has many plugins that make it easier to automate using Git, but Git is not actually part of the Jenkins application. They simply "integrate" well together

### WebHooks
A common way of triggering automated Jenkins Jobs is to use WebHooks: a WebHook is typically an HTTP request made to your Jenkins instance that can trigger a Job to start. In order to make use of a WebHook you have to configure your instance to listen for a web hook (typically done in the configurations of the Job you want automated by the WebHook) and then in your third party tool (like Github) you have to configure the service to to make an HTTP request (this is the hook) to your Jenkins application. This requires that Github or whatever service is making the request have permission to interact with your Jenkins instance: in AWS this is handled by configuring your security groups to allow Github access to Jenkins (https://api.github.com/meta has a list of IPs github uses).