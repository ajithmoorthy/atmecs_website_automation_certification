package org.atmecs.website.pages;

import java.util.Properties;

import org.atmecs.website.helper.ActionHelper;
import org.openqa.selenium.WebDriver;

public class ServicesPage {
	ActionHelper helper=new ActionHelper();
	public void servicesOption(WebDriver driver,Properties prop) {
		helper.mouseOver(driver,prop.getProperty("loc.menu.services"),prop.getProperty("loc.submenudigital.linktxt.xpath"));
	}
}
