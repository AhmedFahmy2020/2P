import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class PageBase {

    public WebDriver driver;

    // create constructor
    public PageBase(WebDriver driver) {

        PageFactory.initElements(driver, this);

    }

    protected static void click(WebElement button) {

        button.click();
    }

    protected static void TypeText(WebElement textElement, String value) {

        textElement.sendKeys(value);
    }

    protected static void SelectDropDown(WebElement textElement, String value) {

        Select select = new Select(textElement);
        select.selectByVisibleText(value);
    }


    public void workWithPopupAlret() {

        Alert alret = driver.switchTo().alert();
        alret.accept();

    }

    public  boolean isElementDisplayed(WebElement element , WebDriver driver) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.visibilityOf(element));
            return element.isDisplayed();
        } catch (NoSuchElementException
                | StaleElementReferenceException
                | TimeoutException e) {
            return false;
        }



    }


    public boolean isPresent (String xpath, WebDriver driver)
    {
        Boolean isPresent = driver.findElements(By.xpath(xpath)).size() > 0;
        if (isPresent) return true;
        else {
            WebDriverWait wait = new WebDriverWait(driver ,30   );
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));

            return false;
        }
    }

    public void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };
        try {
            Thread.sleep(10000);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }







}

