/*
 * Author:		Hemansu Kapadia
 * Date:		December 14,2019
 * Filename:	Screenshot.java
 * Description:	Open ProQuest website, search QA in the top nav, take and store screenshot of webpage.
 */

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Screenshot {

	public static String screenshotName;
	public static String searchURL = "https://www.proquest.com/search/?searchKeyword=QA";
	public static String destinationFileLocation = System.getProperty("user.dir") + "\\test-results\\";
	
	public static void main(String[] args) throws IOException {
		
		//To use Google Chrome driver use below code
		System.out.println("************************");
		System.out.println("launching Chrome browser");
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
	    
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(searchURL);
		
		Date d = new Date();
		screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".png";
		
		//Convert driver object to TakeScreenshot
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		
		//Call getScreenshotAs method to create image file 
		File ScrFile = scrShot.getScreenshotAs(OutputType.FILE);
		
		//Move image file to new destination folder within our project
        File DestFile = new File(destinationFileLocation + screenshotName);

        //Move screenshot file to destination
        FileUtils.moveFile(ScrFile, DestFile);
		
        if(driver!=null) 
        {
        	System.out.println("Closing browser");
        	driver.quit();
        }
	}

}
