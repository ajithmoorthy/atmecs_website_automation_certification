package org.atmecs.website.testscripts;

import java.io.IOException;
import java.util.Properties;

import org.atmecs.website.constants.FileConstants;
import org.atmecs.website.pages.ServicesPage;
import org.testng.annotations.Test;

public class Services extends Insights {
	ServicesPage  services=new ServicesPage();
	@Test(priority=2)
	public void servicesOptionCheck() throws IOException {
		logger=extentObject.startTest("validate the Services");
		Properties propObject=property.KeyValueLoader(FileConstants.SERVICES_PATH);
		services.servicesOption(driver, propObject);
	}
}
