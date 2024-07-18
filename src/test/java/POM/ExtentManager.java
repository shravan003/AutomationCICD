package POM;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
    private static ExtentReports extent;
    private static ExtentHtmlReporter htmlReporter;

    public static ExtentReports getInstance() {
        if (extent == null) {
            htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/extent-report.html");
            htmlReporter.config().setDocumentTitle("Automation Report");
            htmlReporter.config().setReportName("Functional Testing");
            htmlReporter.config().setTheme(Theme.STANDARD);

            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
            extent.setSystemInfo("Host Name", "LocalHost");
            extent.setSystemInfo("Environment", "QA");
            extent.setSystemInfo("User Name", "Test User");
        }
        return extent;
    }
}
