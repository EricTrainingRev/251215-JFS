# Selenium WebDriver Study Guide

## Selenium Ecosystem

### Selenium Introduction
**Selenium** is an open-source project designed for web browser automation. It consists of software that can control a web browser and perform actions like any human user could: navigating to a website, clicking buttons, filling out forms, etc. If it is an action that can be performed in a browser, it can probably be automated with **Selenium**. 

### Selenium WebDriver
**Selenium WebDriver** is a tool that automates a browser, simulating real user interactions. It is designed to be simple and concise, and it can be used with all major browsers through a simple setup process. This tool encompasses both the language bindings and the implementations of the individual browser controlling code, usually called **WebDrivers**. It is through these **drivers** that **Selenium** performs web automation

### Selenium IDE
**Selenium IDE** is a browser extension available for Chrome, Firefox, and Edge that simplifies the process of creating automation test scripts directly in the browser by recording your actions and saving them for later use. The benefit of the tool is that all of its features are contained within the extension: the only setup needed to work with **Selenium IDE** is installing the plugin in your browser

### Selenium Grid
**Selenium Grid** a tool for running parallel tests on multiple machines with Selenium. This can be useful for large test suites that need to be run on multiple operating systems and browsers, and the various combinations of those systems and browsers. With such expansive testing needs, **Selenium Grid** has the potential to reduce the overall test time of your system tests

## Driver Configuration

### Manual Driver Setup
Pre-version 4 of **Selenium** required manual **WebDriver** setup before automating the browser: this required downloading a copy of the driver software required for interacting with the desired browser and then telling the application where the driver is located (this example uses the chrome driver)
```java
// first you create a reference to your driver file
File path = new File("path/to/chromedriver.exe");

// next you set a system property Selenium will use to find your driver
System.setProperty("webdriver.chrome.driver", path.getAbsolutePath());

// now you are ready to make a WebDriver object
WebDriver driver = new ChromeDriver();
```

### Automated Driver Setup
The manual setup above is unnecessary in version 4 and later of **Selenium** if using Chrome, Firefox, or edge, but if working with older applications you may need to be familiar with that way of setting up **Selenium**. In newer versions you can simply create your **WebDriver** object and start coding your automation
```java
// only setup needed
WebDriver driver = new ChromeDriver();
```

### Option Classes
Most people browsing the web do use using some kind of profile and a collection of extensions: when Selenium starts a browsing session it does so without any knowledge of these resources. To make Selenium use your profile, extensions, or set up any other starting configurations, you can use an **Options** class for your chosen browser
```java
ChromeOptions options = new ChromeOptions()
```
Two common options for the browser are to start in maximized mode and setting the profile for Selenium to use
```java
// to start in maximized mode you add an argument to your Options object
options.addArguments("--start-maximized");

// to use your chosen browser profile add a user-data-dir argument to your Options object
// note this value may be different for other browsers
options.addArguments("user-data-dir=/path/to/profile");

// once your options are set you pass the Options object as an argument to your driver constructor

ChromeDriver driver = new ChromeDriver(options);
```
[Selenium documentation has a collection of browser specific functionality and Options configurations
](https://www.selenium.dev/documentation/webdriver/browsers/)
