package POM;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.Listeners;

@Listeners(POM.TestListener.class)
public class CodeTest {
    private BasePage basePage;
    private LoginPage loginPage;
    private AdminPage adminPage; 
    private ExtentReports extent;
    private ExtentTest test;

    @BeforeClass
    public void setUp() {
        extent = ExtentManager.getInstance();
        basePage = new BasePage();
        basePage.setUp();
        loginPage = new LoginPage(basePage.getDriver());
        adminPage = new AdminPage(basePage.getDriver());
    }

    @Test
    public void url() {
        test = extent.createTest("Open URL Test");
        try {
            loginPage.openUrl("https://opensource-demo.orangehrmlive.com/");
            test.pass("URL Opened Successfully");
            String currentTitle = basePage.getDriver().getTitle();
            String expectedTitle = "OrangeHRM";
            Assert.assertEquals(currentTitle, expectedTitle, "Title does not match expected value");
        } catch (Exception e) {
            test.fail("Failed to open URL");
            Assert.fail("Exception occurred: " + e.getMessage());
        }
    }

    @Test(dependsOnMethods = "url", dataProvider = "loginData", dataProviderClass = ExcelDataProvider.class)
    public void login(String Username, String Password) {
        test = extent.createTest("Login Test");
        try {
            loginPage.login(Username, Password);
            test.pass("Login successful with username: " + Username);
        } catch (Exception e) {
            test.fail("Login failed with username: " + Username);
            Assert.fail("Exception occurred: " + e.getMessage());
        }
    }

    @Test(dependsOnMethods = "login")
    public void admin() {
        test = extent.createTest("Navigate to Admin Test");
        try {
            adminPage.navigateToAdmin();
            test.pass("Navigated to Admin page successfully.");
        } catch (Exception e) {
            test.fail("Failed to navigate to Admin page.");
            Assert.fail("Exception occurred: " + e.getMessage());
        }
    }

    @AfterClass
    public void tearDown() {
        basePage.tearDown();
        extent.flush();
    }
}
