package org.atmecs.website.testscripts;

import java.io.IOException;
import java.util.Properties;

import org.atmecs.website.constants.FileConstants;
import org.atmecs.website.pages.InsightsPage;
import org.testng.annotations.Test;

public class Insights extends Home {
	InsightsPage insight=new InsightsPage();
	@Test(priority=1)
	public void validateBlogs() throws IOException, InterruptedException {
	Properties propObject=property.KeyValueLoader(FileConstants.INSIGHT_PATH);
	logger=extentObject.startTest("Validate Blogs and Comments");
	insight.validateBlogs(driver, propObject);
	}
}
