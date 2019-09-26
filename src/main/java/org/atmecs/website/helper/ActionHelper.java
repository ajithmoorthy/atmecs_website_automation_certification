package org.atmecs.website.helper;


import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.atmecs.website.extentreports.Extent;
import org.atmecs.website.logreports.LogReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;
/*
 * Class is created for the implement the reusablity
 * it is contains many method when ever we want we can access*/
public class ActionHelper extends Extent {
	LogReporter log=new LogReporter();
	By xpath,id,name,className,linkText,cssSelector,partialLink,tag;
	/**
	 * This method will perform the separate the locators and options and send to the action method.
	 * @param locators
	 * @param webdriver
	 */
	public void clickElement(String locators, WebDriver webdriver) {
		String[] input=locators.split(",");
		switch(input[0]){
		case "XPATH":
			xpath=By.xpath(input[1]);
			actionMethod(webdriver,xpath);
			break;
		case "ID":
			id=By.id(input[1]);
			actionMethod(webdriver,id);
			break;
		case "NAME":
			name=By.name(input[1]);
			actionMethod(webdriver,name);
			break;
		case "CSS_SELECTOR":
			cssSelector=By.cssSelector(input[1]);
			actionMethod(webdriver,cssSelector);
			break;
		case "CLASS":
			className=By.className(input[1]);
			actionMethod(webdriver,className);
			break;
		case "LINK_TEXT":
			linkText=By.linkText(input[1]);
			actionMethod(webdriver,linkText);
			break;
		case "PARTIAL_LINK_TEXT":
			partialLink=By.partialLinkText(input[1]);
			actionMethod(webdriver,partialLink);
			break;	
		case "TAG_NAME":
			tag=By.tagName(input[1]);
			actionMethod(webdriver,tag);
			break;
		default:
			System.out.println("Locator type doesn't exist ");
			break;
		}
	}
	/**
	 * This method  separate the locators and options and send to the SendKeysMethod.
	 * @param locators
	 * @param webdriver
	 */
	public void sendKeys(String locators, WebDriver webdriver,String value) {
		String[] input=locators.split(",");
		switch(input[0]){
		case "XPATH":
			xpath=By.xpath(input[1]);
			sendKeysMethod(xpath,webdriver,value);
			break;
		case "ID":
			id=By.id(input[1]);
			sendKeysMethod(id,webdriver,value);
			break;
		case "NAME":
			name=By.name(input[1]);
			sendKeysMethod(name,webdriver,value);
			break;
		case "CSS_SELECTOR":
			cssSelector=By.cssSelector(input[1]);
			sendKeysMethod(cssSelector,webdriver,value);
			break;
		case "CLASS":
			className=By.className(input[1]);
			sendKeysMethod(className,webdriver,value);
			break;
		case "LINK_TEXT":
			linkText=By.linkText(input[1]);
			sendKeysMethod(linkText,webdriver,value);
			break;
		case "PARTIAL_LINK_TEXT":
			partialLink=By.partialLinkText(input[1]);
			sendKeysMethod(partialLink,webdriver,value);
			break;	
		case "TAG_NAME":
			tag=By.tagName(input[1]);
			sendKeysMethod(tag,webdriver,value);
			break;
		default:
			System.out.println("Locator type doesn't exist ");
			break;
		}
	}
	/**
	 * action method perform the click operation.
	 * @param webdriver
	 * @param locator
	 */
	public void actionMethod(WebDriver webdriver,By locator) {
		try {
		WebDriverWait wait2 = new WebDriverWait(webdriver, 20);
		wait2.until(ExpectedConditions.elementToBeClickable(locator));
		WebElement click_operation = webdriver.findElement(locator);
		click_operation.click();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	/**
	 * this method used for the automate the drop down web Elements. 
	 * @param locators
	 * @param webdriver
	 * @param index
	 * @return
	 */
	public WebDriver dropDown(String locators, WebDriver webdriver, int index) {
		WebDriverWait wait2 = new WebDriverWait(webdriver, 20);
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath(locators)));
		WebElement dropdown = webdriver.findElement(By.xpath(locators));
		Select select = new Select(dropdown);
		select.selectByIndex(index);
		return webdriver;
	}
	/**
	 * This method send the String to the Web Elements.
	 * @param locator
	 * @param webdriver
	 * @param value
	 */
	public void sendKeysMethod(By locator, WebDriver webdriver,String value) {
		WebDriverWait wait2 = new WebDriverWait(webdriver, 20);
		wait2.until(ExpectedConditions.elementToBeClickable(locator));
		WebElement sendtext = webdriver.findElement(locator);
		sendtext.sendKeys(value);
	}
	//this the method for handle the windows in web driver
	public WebDriver winHandler(WebDriver driver) {
		String window_array[]=new String[5];
		Set<String> windows=driver.getWindowHandles();
		int initial=0;
		for (String win:windows)
		{
			window_array[initial]=win;
		}
		driver=driver.switchTo().window(window_array[0]);
		return driver;
	}
	/**
	 * this method will perform the login for each web page.
	 * @param webdriver
	 * @param loc_username
	 * @param loc_password
	 * @param submit
	 * @param input_Username
	 * @param input_Password
	 */
	public void loginMethod(WebDriver webdriver,String loc_username,String loc_password,String submit,String input_Username,String input_Password) {
		sendKeys(loc_username,webdriver, input_Username);
		sendKeys(loc_password,webdriver, input_Password);
		clickElement(submit, webdriver);	
	}
	//this method will check the url is correct or not
	public void correctUrlChecker(WebDriver Driver,String Expected_Url){
		try {
			Assert.assertEquals(Driver.getCurrentUrl(),Expected_Url);
			log.logReportMessage("Successfully Validated the correct Url is :"+ Driver.getCurrentUrl());
			logger.log(LogStatus.INFO,"Successfully Validated the correct Url is :" +Driver.getCurrentUrl());
		}catch(AssertionError e) {
			System.out.println("Navigate to wrong Webpage");
			log.logReportMessage("Navigate to wrong Webpage");
			logger.log(LogStatus.INFO, "Navigate to wrong Webpage");
		}	
	}
	//this method validate the page document title
		public void validateTitle(WebDriver driver, String documentTitle){
			try {
				Assert.assertEquals(driver.getTitle(), documentTitle);
				log.logReportMessage("Document title is validated :"+driver.getTitle());
				logger.log(LogStatus.INFO,"Document title is validated :" +driver.getTitle());
			}
			catch(AssertionError e)
			{
			System.out.println("Document title is not match with Expected :"+driver.getTitle());
			log.logReportMessage("Document title is not match with Expected :"+driver.getTitle());
			logger.log(LogStatus.INFO,"Document title is not match with Expected :"+driver.getTitle());	
			}
		}
		//this method is used to perform the mouse over with drop down selection
		public void menuMouseOver(WebDriver webdriver,String locator,String option) {
			Actions actions = new Actions(webdriver);
			WebDriverWait wait2 = new WebDriverWait(webdriver, 20);
			wait2.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
			WebElement element=webdriver.findElement(By.xpath(locator));
			actions.moveToElement(element).perform();
			wait2.until(ExpectedConditions.elementToBeClickable(By.xpath(option)));
			WebElement optionElement=webdriver.findElement(By.xpath(option));
			optionElement.click();
		}
		//this method is used to select the option from the send Keys what we send
		public void sendKeysDropDown(WebDriver webdriver,String locator,String optionRoot,String value) {
			sendKeys(locator,webdriver,value);
			Actions action=new Actions(webdriver);
			webdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			List<WebElement> list = webdriver.findElements(By.xpath(optionRoot));
			for(WebElement  element:list) {
				System.out.println(element.getText());
				if(element.getText().equalsIgnoreCase(value)) {
					action.moveToElement(element).perform();
					element.click();
				}
				
			}
		}
		public void validateFooter(WebDriver driver,String locators,String[] footerarray) {
			List<WebElement> list=driver.findElements(By.xpath(locators));
			int count=0;
			while(count<1) {
		for(WebElement element:list)
		{
			String[] elementarray=element.getText().split("\n");
			for(int variable=0; variable<elementarray.length; variable++) {
				assertValidate(elementarray[variable],footerarray[count]);
				count++;
			}
		}
			}
		}
		public void assertValidate(String actual,String expected) {
			try {
				Assert.assertEquals(actual,expected);
				log.logReportMessage("Actual Value :"+actual+" and Expected :"+expected+" is validated succesfully");
			}
			catch(AssertionError e)
			{
				System.out.println("Actual Value :"+actual+" not match wiht the Expected value :"+expected);
			}
			
		}
		 public void scrollPage(WebDriver driver) {
			 JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,10000)");
		 }
			public void menuMouseOverClick(WebDriver webdriver,String locator) {
				Actions actions = new Actions(webdriver);
				WebDriverWait wait2 = new WebDriverWait(webdriver, 20);
				wait2.until(ExpectedConditions.elementToBeClickable(By.cssSelector(locator)));
				WebElement element=webdriver.findElement(By.cssSelector(locator));
				actions.moveToElement(element).perform();
				element.click();
			}
			public void mouseOverClick(WebDriver webdriver,String locator,String option) {
				Actions actions = new Actions(webdriver);
				WebDriverWait wait2 = new WebDriverWait(webdriver, 20);
				wait2.until(ExpectedConditions.elementToBeClickable(By.cssSelector(locator)));
				WebElement element=webdriver.findElement(By.cssSelector(locator));
				actions.moveToElement(element).perform();
				wait2.until(ExpectedConditions.elementToBeClickable(By.cssSelector(option)));
				WebElement optionElement=webdriver.findElement(By.cssSelector(option));
				optionElement.click();
			}
			
			public void mouseOver(WebDriver webdriver,String locator,String option) {
				Actions actions = new Actions(webdriver);
				WebDriverWait wait2 = new WebDriverWait(webdriver, 20);
				wait2.until(ExpectedConditions.elementToBeClickable(By.cssSelector(locator)));
				WebElement element=webdriver.findElement(By.cssSelector(locator));
				actions.moveToElement(element).perform();
				wait2.until(ExpectedConditions.elementToBeClickable(By.cssSelector(option)));
				WebElement optionElement=webdriver.findElement(By.cssSelector(option));
				actions.moveToElement(optionElement).perform();
			}
}
