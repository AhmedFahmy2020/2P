import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class TestBase {

    public static WebDriver driver;

    @BeforeSuite
    @Parameters({ "Browser" })
    public void startDriver(@Optional("chrome") String browserName) {

        if (browserName.equalsIgnoreCase("chrome")) {

            String chromePath = System.getProperty("user.dir") + "/src/main/resources/Drivers/chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", chromePath);
            driver = new ChromeDriver();

        } else if (browserName.equalsIgnoreCase("firefox")) {

            String firefoxPath = System.getProperty("user.dir") + "/Drivers/geckodriver.exe";
            System.setProperty("webdriver.gecko.driver", firefoxPath);
            driver = new FirefoxDriver();

        }

        driver.manage().window().maximize();
        driver.get(
                "https://www.phptravels.net/register");

    }




    @AfterTest
    public void screenshotOnFailure(ITestResult result)
    {
        if (result.getStatus() == ITestResult.FAILURE)
        {
            System.out.println("Failed!");
            System.out.println("Taking Screenshot....");
            Helper.captureScreenshot(driver, result.getName());
        }
    }




    //	@AfterSuite
    //
//		public void stopDriver() {
//
//			driver.manage().timeouts().implicitlyWait( 20, TimeUnit.SECONDS);
//			driver.quit();
//		}




}







