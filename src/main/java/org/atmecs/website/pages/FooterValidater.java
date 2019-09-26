package org.atmecs.website.pages;

import java.util.Properties;

import org.atmecs.website.helper.ActionHelper;
import org.openqa.selenium.WebDriver;


public class FooterValidater {
	ActionHelper helper=new ActionHelper();
	public void validateFooter(WebDriver driver,String[] footerarray,Properties prop) {
		driver.manage().window().maximize();
		helper.validateTitle(driver, "Home | Atmecs, Inc. | Digital Solutions & Product Engineering Services");
		helper.scrollPage(driver);
		helper.validateFooter(driver, prop.getProperty("loc.footer.container.xpath"), footerarray);
		helper.clickElement(prop.getProperty("loc.menu.about"), driver);
		helper.validateTitle(driver, "About Us | Atmecs, Inc. | Digital Solutions & Product Engineering Services");
		helper.scrollPage(driver);
		helper.validateFooter(driver, prop.getProperty("loc.footer.container.xpath"), footerarray);
		helper.menuMouseOverClick(driver, prop.getProperty("loc.menu.services"));
		helper.validateTitle(driver, "Services | Atmecs, Inc. | Digital Solutions & Product Engineering Services");
		helper.scrollPage(driver);
		helper.validateFooter(driver, prop.getProperty("loc.footer.container.xpath"), footerarray);
		helper.clickElement(prop.getProperty("loc.menu.partners"), driver);
		helper.validateTitle(driver, "Partners | Atmecs, Inc. | Digital Solutions & Product Engineering Services");
		helper.scrollPage(driver);
		helper.validateFooter(driver, prop.getProperty("loc.footer.container.xpath"), footerarray);
		helper.clickElement(prop.getProperty("loc.menu.careers"), driver);
		helper.validateTitle(driver, "Careers | Atmecs, Inc. | Digital Solutions & Product Engineering Services");
		helper.scrollPage(driver);
		helper.validateFooter(driver, prop.getProperty("loc.footer.container.xpath"), footerarray);
		helper.clickElement(prop.getProperty("loc.menu.contactus"), driver);
		helper.validateTitle(driver, "Contact Us | Atmecs, Inc. | Digital Solutions & Product Engineering Services");
		helper.scrollPage(driver);
		helper.validateFooter(driver, prop.getProperty("loc.footer.container.xpath"), footerarray);
	}
}
