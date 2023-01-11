package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.remote.UnreachableBrowserException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public abstract class Reporter {
	
	public static ExtentHtmlReporter htmlReporter;

	private static ExtentReports extent;
	private static ExtentTest parentTest = null;
	private static ExtentTest test = null;
	private static String testName = null;
	
	private String fileName = "result.html";
	private String pattern = "ddMMMyyyyHHmmss";

	public static String testcaseName, testDescription, authors, category, dataFileName, dataFileType;
	public static String folderName = "";

	@BeforeSuite(alwaysRun = true)
	public synchronized void startReport() {
		String date = new SimpleDateFormat(pattern).format(new Date());
		//folderName = "reports/" + date;

		//File folder = new File("./" + folderName);
		
		File f = new File("./report_output");
		if(!f.mkdir())
		{
			htmlReporter = new ExtentHtmlReporter("./report_output/extent.html");
		}
	
		htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
		htmlReporter.config().setChartVisibilityOnOpen(!true);
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setDocumentTitle("EVV");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName("EVV");
		htmlReporter.setAppendExisting(false);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}

	@BeforeClass(alwaysRun = true)
	public synchronized void startTestCase() {
		parentTest = extent.createTest(testcaseName, testDescription);
		parentTest.assignCategory(category);
		parentTest.assignAuthor(authors);
		
		
	}

	public synchronized void setNode() {
		test = parentTest.createNode(testcaseName);
	}

	public abstract long takeSnap();

	public void reportStep(String desc, String status, boolean bSnap) {
		synchronized (test) {

			// Start reporting the step and snapshot
			MediaEntityModelProvider img = null;
			if (bSnap && !(status.equalsIgnoreCase("INFO") || status.equalsIgnoreCase("skipped"))) {
				long snapNumber = 100000L;
				snapNumber = takeSnap();
				try {
					img = MediaEntityBuilder
							.createScreenCaptureFromPath("./../report_output/screenshots/"+snapNumber+".jpg").build();
							//.createScreenCaptureFromPath("./../../" + folderName + "/images/" + snapNumber + ".jpg")
							//.build();
					
					
				} catch (IOException e) {
				}
			}
			if (status.equalsIgnoreCase("pass")) {
				test.pass(desc, img);
			} else if (status.equalsIgnoreCase("fail")) { // additional steps to manage alert pop-up
				test.fail(desc, img);
				throw new RuntimeException("See the reporter for details.");

			} else if (status.equalsIgnoreCase("warning")) {
				test.warning(desc, img);
			} else if (status.equalsIgnoreCase("skipped")) {
				test.skip("The test is skipped due to dependency failure");
			} else if (status.equalsIgnoreCase("INFO")) {
				test.info(desc);
			}

			
		}
	}

	public void reportStep(String desc, String status) {
		reportStep(desc, status, true);
	}

	@AfterSuite(alwaysRun = true)
	public synchronized void endResult() {
		
		extent.flush();
	}

	
	
}