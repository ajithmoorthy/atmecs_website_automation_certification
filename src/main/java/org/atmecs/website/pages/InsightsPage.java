package org.atmecs.website.pages;

import java.util.Properties;

import org.atmecs.website.helper.ActionHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class InsightsPage{
	 boolean bool=false;
	ActionHelper helper=new ActionHelper();
	public void validateBlogs(WebDriver driver,Properties prop) throws InterruptedException {
		helper.mouseOverClick(driver, prop.getProperty("loc.menu.insights"),prop.getProperty("loc.submenu.blogs.cssSelector"));
		//boolean bool=validateDate(driver,prop.getProperty("loc.date.blogs.xpath"));
		helper.clickElement(prop.getProperty("loc.readmore.linktext"), driver);
		helper.scrollPage(driver);
		helper.sendKeys(prop.getProperty("loc.comment.txtarea.xpath"), driver, "Some Comment");
		helper.sendKeys(prop.getProperty("loc.name.txtfield.xpath"), driver, "ajith");
		helper.sendKeys(prop.getProperty(" loc.email.txtfield.xpath"),driver, "ajith@gmail.com");
		helper.clickElement(prop.getProperty("loc.postcomment.btn.xpath"), driver);
	}
	 public boolean validateDate(WebDriver driver,String locators){
		 String date=driver.findElement(By.cssSelector(locators)).getText();
		 String[] data=date.split(",");
		 String[] originaldata=data[0].split(" ");
		 if(data[1].contentEquals("2018")) {
			 bool=true;
		 }
		 else if(originaldata[1].contentEquals("March") ||originaldata[1].contentEquals("January") && data[1].contentEquals("2019")) {
			 bool=true;
		 }
		return bool; 
	}

}
