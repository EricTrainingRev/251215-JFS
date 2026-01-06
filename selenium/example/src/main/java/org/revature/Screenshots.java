package org.revature;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

/*
    Selenium provides the capability of taking screenshots through the TakesScreenshot
    class. You can cast your driver as this class to get your screenshot data, and then
    use the FileUtils class to save that data as your image. FileUtils comes from
    apache commons, which you may need to add as a dependency to your project
 */
public class Screenshots {
    public static void main(String[] args) {
        WebDriver driver = null;
        try {
            driver = new ChromeDriver();
            driver.get("https://www.wikipedia.org/");
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            // screenshot will be saved in a location relative to the root directory
            FileUtils.copyFile(scrFile, new File("./image.png"));
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if (driver != null){
                driver.quit();
            }
        }
    }
}
