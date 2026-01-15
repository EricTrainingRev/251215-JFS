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

## Driver Interactions

### Navigate Methods
**WebDrivers** have a large collection of methods for navigating web pages and gathering information about them. The **get(url)** method in **Selenium** opens the specified web page in the browser without preserving any previous browsing history or cookies. In contrast, the **navigate().to(url)** method opens the given web page but retains the previous browsing history and cookies. The **navigate().back()** method simulates the action of clicking the back button in the browser, and **navigate().forward()** mimics clicking the forward button. Both methods require the **navigate().to(url)** to be used in order to maintain browser history. The **navigate().refresh()** method simulates clicking the refresh button. **getCurrentURL()** method returns the current web page's URL as a String, and the **getTitle()** method retrieves the title of the web page as a String

### Locator Strategies
Once **Selenium** has opened a page it needs to be told how to locate the web elements it needs to interact with: this is done by choosing a **locator strategy** and providing it to **Selenium**. The strategy chosen tells **Selenium** how to look for one or more web elements that match the chosen strategy. There are eight strategies **Selenium** can work with (taken from **Selenium** documentation)
|Locator|Description|
|-----------|-----------|
|class name|	Locates elements whose class name contains the search value (compound class names are not permitted)|
|css selector|	Locates elements matching a CSS selector|
|id|	Locates elements whose ID attribute matches the search value|
|name|	Locates elements whose NAME attribute matches the search value|
|link text|	Locates anchor elements whose visible text matches the search value|
|partial link text|	Locates anchor elements whose visible text contains the search value. If multiple elements are matching, only the first one will be selected.|
|tag name|	Locates elements whose tag name matches the search value|
|xpath|	Locates elements matching an XPath expression|

Once you have chosen a strategy you use the **By** class and its static method associated with your chosen **locator strategy**. The code below shows how you would use the **By** class to target a web element with the ID of "myTarget" using the id **locator strategy**
```java
By.id("myTarget");
```
Keep in mind the **By** class is almost never going to be used by itself: it is used in conjunction with one of the **WebDriver** find methods

### Find Methods
The driver uses whatever **locator strategy** you provide in order to find elements on the web page, represented as **WebElement** objects in code. You can look for an individual element or all elements that match the chosen **locator strategy** using **findElement** and **findElements**
```java
// will return the first element found with the given id
driver.findElement(By.id("someId")); 

// will return all elements with the given CSS class in a List
driver.findElements(By.class("someClass")); 
```
Selenium will throw a `NoSuchElementException` if no element can be found via **findElement**, but instead of throwing an exception an empty list will be returned if **findElements** locates no elements. Also, sometimes an element will become "stale": this means you have a **WebElement** object that was once a valid reference, but changes in the browser have caused it to no longer be valid. If you try to use it you get a `StaleElementException` as shown below
```java
WebElement myElement = driver.findElement(By.id("someId")); // element found successfully
driver.get("http://someothersite.com"); // web page changes, previously valid web element no longer exists
myElement.click(); // StaleElementException thrown here
```
Besides changing web pages, another common cause of `StaleElementException` being thrown is changes to the DOM of the same web page: when **Selenium** locates an element it creates a reference for it that it expects to find at a specific location within the DOM. Changes to the DOM can cause this reference to be inaccurate, which causes the `StaleElementException`. If you need to interact with an element after changes are made to the DOM the safe option is to relocate the element, creating a new **WebElement** object, and then performing your action on the element

### Screenshots
**Selenium** has the ability to take a screenshot of the browser render pane (visible web content in the browser) and save the data to a File object in your Java code. This can be particularly useful when using **Selenium** for testing purposes to have a visual of what the webpage you are interacting with looks like when things go wrong, or for logging visual data
```java
// TakesScreenshot is an interface that implements getScreenshotAs, so we cast the WebDriver to it in order to gain access to the method
File fileData = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
// remember that you make a Path (singular) object via Paths (plural) get() method
Path screenshotDestination = Paths.get("src/main/resources/filename.jpeg"); // can choose an extension of your choice
// Use the Files (plural) class to copy the file data to your destination
Files.copy(fileData.toPath(), screenshotDestination);
```

## XPath

### Absolute XPath
Because HTML can be considered as a type of XML, **XPath**, or **XML Path Language**, can be used to query data from web pages. **XPath** is a query language that can be used to select web elements on a web page. **XPath** as a **locator strategy** has multiple ways it can be utilized; the most straightforward way of using it is with **absolute XPath**. Used this way, a path similar to a file path is created that starts at the root of the web document (/) and goes node by node to the specific element you want targeted. The **XPath** below targets the second paragraph element in the example html (**XPath** indexing starts at 1)
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Example</title>
</head>
<body>
    <p>first line of text</p>
    <p>second line of text</p>
    <p>third line of text</p>
</body>
</html>
```
```java
driver.findElement(By.xpath("/html/body/p[2]"));
```
Similar to file paths, **XPath** supports syntax for referencing the current node and parent nodes in the DOM:
- `./` is a reference to the current node
- `../` is a reference to the parent node of the current node

### Relative XPath
Depending on the size of the web document being rendered in the browser, **absolute XPath** can become cumbersome to write. In these cases **relative XPath** can be used to simplify your queries. Unlike **absolute XPath**, which starts from the root of the document, **relative XPath** starts from the **current node** and searches through all child nodes (the current node will be the root of the document if you start your query with **relative XPath**). The example **XPath** above can be simplified using **relative XPath**
```java
// note the query uses // instead of / to indicate relative XPath
driver.findElement(By.xpath("//p[2]"));
```
This syntax works because all three elements are direct children of the body element: if the elements were in separate children elements this would not work
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Example</title>
</head>
<body>
    <div id="divOne">
        <p>This is element one text</p>
    </div>
    <div id="divTwo">
        <p>This is element two text</p>
    </div>
</body>
</html>
```
`//p` looks for all `p` elements that are children of the root document, so in this case, every `p` element in the document. If you just want a list of all `p` elements this is a great option, but if you want a specific `p` element you need to adjust your query. `//p[2]` is a query requesting the second `p` element that is a child (not descendant) of the current node,  but since the `p` elements are not located in the same parent node there is not enough information to know which parent node is being referenced. In other words, you can imagine your **XPath** query asking you in response to the `//p[2]` query "Do you want the second `p` element in the first div or the second div, because those are the nodes that have `p` elements?", but what we actually want is the second `p` element in the document. To fix the query we have to specify we want the `p` element in the second div: `//div[2]/p`. Similar to the first HTML example, where all `p` elements are children of the same parent node, the div elements in the second HTML example are children of the same parent node. This means we can target the second `div` with our relative query and then the `p` element within it, thus giving us the second `p` element like we wanted

### XPath Functions
**XPath** supports multiple functions within queries: these can be used to refine the results of your queries and target specific elements in a larger collection. Going back the **relative XPath** query of `//p[2]` if we did not have knowledge of the parent `div` elements, but did know the text content of the `p` elements, we could refine our query to target the `p` element that has the word "two" in its text content: `//p[contains(text(),'two')]` makes use of two **XPath** functions, `contains` and `text`. `contains` checks if the first argument has the second inside it, and `text` returns the text content of a node, in this case the `p` elements selected by the relative path `//p`. Since only the second `p` element has the word "two" in its text content, the single `p` element is returned by the query

[This website](https://devhints.io/xpath) has an excellent XPath cheatsheet that can be used as a reference when writing your own **XPath**, and includes a large collection of **XPath** selectors, expressions, and functions

## Web Element Interactions

### Interact Methods
Once a **WebElement** is created there are several actions that can be performed on elements found on a web page. The **clear()** method is used to remove any text content from an input field. The **click()** method simulates a user clicking on the center of the element, which is useful for interacting with buttons, links, and other clickable elements. The **getAttribute(attribute)** method returns the value of the specified attribute of the element, allowing you to retrieve properties such as `id`, `class`, or `href`

The **getText()** method returns any text content within the element, which is helpful for extracting information displayed on the web page. **sendKeys(keys)** simulates the user entering text into an input field. This method can also be used to upload files by providing the absolute file path of the resource you wish to upload. Although the **submit()** method is deprecated, it is still supported for compatibility reasons. It was previously the preferred way to submit web forms, but now it is recommended to use the **click()** method on the form's submit button instead

### Select Elements
HTML Select elements are unique in that **Selenium** provides a **Select** class that has unique methods for interacting with option elements it contains. To create a **Select** object you first create a **WebElement** object, then pass it into a **Select** constructor
```java
WebElement selectElement = driver.findElement(By.tagName("select"));
Select selectObject = new Select(selectElement);
```
**Select** objects have two methods for viewing the associated option elements: **geOptions()** will return a list of all option elements of the **Select** web element, and **getAllSelectedOptions()** will return a list of all currently selected option elements in the **Select** web element. Note that depending on whether the **Select** element supports multi-selecting, zero, one, or multiple **WebElements** can be returned in a List object. Once you know what your options for selecting are there are three ways you can choose your options to select: by visible text, by value, and by index position:
- **selectByVisibleText(text)**
    - this method will select an option based on the visible text of the option element
- **selectByValue(value)**
    - this method will select an option based on the value attribute of the option element
- **selectByIndex(index)**
    - this method will select an option based on the index position of the option element

### Driver Integration
**WebElement** objects have access to the same find methods the **WebDriver** class uses, which means you can search for new elements using your already found web elements as the starting point for the search
```java
WebElement someElement = driver.findElement(By.id("someId"));

// this will return the first p element that is a descendant of someElement
WebElement anotherElement = someElement.findElement(By.tagName("p"));
```
This feature provides flexibility in how you can search for web elements: if you know some element is going to be constant, but the descendant elements are variable, you can get the constant element and then search its descendants for the content you are looking for, narrowing the scope of possible elements you will need to search through

### Actions API
Selenium can interact with the keyboard, mouse input, and scroll wheel through the use of the **Actions API**. This API is suitable for performing more complex actions, such as click and drag, scrolling through a large list using the mouse wheel, or simulating a user on a touch screen making a multi-finger gesture. This is accomplished by chaining together a sequence of actions you want performed (example taken from Selenium documentation)
```java
WebElement clickable = driver.findElement(By.id("clickable"));
new Actions(driver)
        .moveToElement(clickable)
        .pause(Duration.ofSeconds(1))
        .clickAndHold()
        .pause(Duration.ofSeconds(1))
        .sendKeys("abc")
        .perform();
```
The API is designed for interacting with hardware that interacts with the browser, but it can also be used for fine-tuned control over how element interaction works. For instance, instead of using a wait to pause Selenium till a slow process completes, you can use the **Actions API** to control the pause in execution

## Waits

### Implicit Wait
Selenium is a fast acting program, and sometimes its speed is too quick for the web pages it should be automating. It is not uncommon for Selenium to automate itself ahead of what the web page it is working on can handle. This can lead to situations where Selenium will throw exceptions saying things like an element can't be found, but when you manually perform the same actions everything works as expected. In these instances you need a way to tell Selenium to wait a bit in order to allow the web page to perform all the actions/load all the information it needs before Selenium continues operations. **Selenium** provides three different options to control the way Selenium pauses automation:
- **Implicit Wait**
- **Explicit Waits**
- **Fluent Waits**

**Implicit Wait** is configured directly in the **WebDriver**: it tells Selenium how long to wait before throwing an `ElementNotFound` exception if the **Selenium** is unable to locate an element. The default wait time is 0, meaning if Selenium does not immediately find the element it throws an exception
```java
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
```
**Selenium** is expected to quickly automate web pages, so it is not recommended to make the **Implicit Wait** time very long: it should be used to accommodate situations like high latency. One-off situations where you need to wait for a significant amount of time should be handled by a different type of wait

### Explicit Waits
**Explicit Waits** apply individually and adjust **Selenium's** waiting time for a wide range of conditions to be met. For example, if it usually takes 3 seconds for an element to load, you can use an **Explicit Wait**, managed by a **WebDriverWait** object, to tell **Selenium** to pause execution while waiting for that element to load. This allows you to avoid adjusting your **Implicit Wait** to accommodate outlier elements that takes a long time to load. **Explicit Waits** also allow you to wait for many other situations (alert present/gone, title text to be new, element hidden, etc.). Your wait condition can be determined by using the **ExpectedConditions** class
```java
// WebDriverWait objects require a driver to manage and a time duration to wait
WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(2));

// this tells the Selenium to wait up to 2 seconds for an alert to be present in the browser
explicitWait.until(ExpectedConditions.alertIsPresent());
```
These **Explicit Waits** should always be used instead of solutions like `Thread.sleep()`: they have well documented and defined behavior that help guide your **Selenium** development

### Fluent Waits
**Fluent Waits** are similar to to **Explicit Waits** in that they are for one-off situations, but they are more configurable than regular **Explicit Waits**. The wait time, polling time (how often Selenium checks the web page), and exceptions to be ignored can all be customized
```java
Wait<WebDriver> wait =
    new FluentWait<>(driver)
        .withTimeout(Duration.ofSeconds(5))
        .pollingEvery(Duration.ofMillis(500))
        .ignoring(ElementNotInteractableException.class);
```
the fluent wait above tells **Selenium** to pause execution up to 5 seconds, checking every 500 miliseconds if some expected condition is met, and ignoring the `ElementNotInteractableException` specifically

Sometimes you will have an action that does not fit neatly into the pre-provided **ExpectedConditions** provided by **Selenium**. In these cases, or if you would like to stick with your pre-made code, you can instead pass a **Fluent Wait** (or an **Explicit Wait**) a lambda to indicate what condition you are waiting for
```java
Wait<WebDriver> wait =
    new FluentWait<>(driver)
        .withTimeout(Duration.ofSeconds(5))
        .pollingEvery(Duration.ofMillis(500))
        .ignoring(ElementNotFound.class);
wait.until(d -> {
    d.findElement(By.id("resourceBeingCreatedThatTakesTime"));
    return true;
});
```
The example above tells Selenium to wait until the driver (variable d) successfully finds the resource with the given **locator strategy**. This can also be used when waiting for some resource to be found and saved to a variable to be used later
```java
WebElement someCreatedResource;
Wait<WebDriver> wait =
    new FluentWait<>(driver)
        .withTimeout(Duration.ofSeconds(5))
        .pollingEvery(Duration.ofMillis(500))
        .ignoring(ElementNotFound.class);
someCreatedResource = wait.until(d -> d.findElement(By.id("resourceBeingCreatedThatTakesTime")));
System.out.println(someCreatedResource.getText());
```

## Window Management

### Alerts
Browsers have three standard popup options: alerts, confirmations, and prompts. All three options are handled the same way in **Selenium**, which is by creating **Alert** objects and interacting with the popup
```java
Alert alert = driver.switchTo().alert();
```
When working with Alert objects in your code there are several methods available to interact with them. The **getText()** method retrieves the text content displayed within the alert, allowing you to read and process the message. If the alert accepts user input, you can use the **sendKeys(text)** method to send text to the alert. To proceed with the alert, you can use the **accept()** method, which simulates clicking the "OK" button. Conversely, if you need to cancel the alert, the **dismiss()** method will simulate clicking the "Cancel" button

### Window Handling
As far as **Selenium** is concerned, browser windows and tabs are the same thing, so the API for interacting with them treats them as "windows" to keep things simple. you can get the "handle" of your current window using the driver **getWindowHandle()** method
```java
String currentWindowHandle = driver.getWindowHandle();
```
When an action in the browser opens a new tab or window the browser usually opens it in such a way that it is in focus; this is useful for a human using the browser, but for **Selenium** it is irrelevant. The software must be told to shift from one window to another manually using the **window()** method, similar to how the **alert()** method is used to gain access to a popup alert
```java
driver.switchTo().window(newWindowHandleString)
```
Selenium does not manually keep track of the currently active windows, but the **getWindowHandles()** method can be used to get a Set of all open windows. This Set can be iterated through to find the window you want and set it to the active one before operations continue

## Page Object Model

### Page Object Model Design Pattern
Similar to how OOP languages encapsulate data in classes, browser data and actions can be encapsulated in **Page Object Models** to simplify how the browser is automated with **Selenium**. By encapsulating the relevant data of a web page into a class and writing out logic to interact with those elements in methods you create a streamlined solution for creating repeatable automation. **Page Object Models** have three core features:
- references to the core web elements on the page
- methods for interacting with the core web elements
- a **WebDriver** acting as the API
```java
public class POMExample{
    
    private WebDriver driver;
    private WebElement importantElement;

    public POMExample(WebDriver driver){
        this.driver = driver;
    }

    public void interactWithElement(){
        importantElement = driver.findElement(By.id("important"));
        importantElement.click();
    }

}
```

### PageFactory
One potential issue in building **Page Object Models** is handling `StaleElementExceptions`: creating a **WebElement** once in any sort of complex automation application is going to quickly become stale. You can write your code in such a way that every time you reference an element saved in your **POM** you redefine it, but this can become cumbersome. Fortunately, Selenium provides a class called **PageFactory** that can handle the reinitializing of **WebElement** objects to prevent their going stale. The **PageFactory** utilizes annotations to determine how the **WebDriver** should locate an element, then abstracts away the locating of the element so focus can be on interacting with the element.
```java
public class POMExample{
    
    private WebDriver driver;

    @FindBy(id = "important")
    private WebElement importantElement;

    public POMExample(WebDriver driver){
        this.driver = driver;
        // the page factory requires a driver and a reference to the POM to work correctly
        PageFactory.initElements(driver,this);
    }

    public void interactWithElement(){
        importantElement.click();
    }

}
```
The **Page Factory** is able to find individual and collections of elements, the object initialized is determined by whether a singular **WebElement** or list of **WebElements** is set as the type of the field