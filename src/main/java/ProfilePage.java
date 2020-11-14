import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends PageBase {
    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[2]/div[1]/div[1]/div/div/div[1]/div/div[2]/h3")
    private WebElement registeredUser;


    @Step("Get the Profile ID")
    public String getTheUserInfo ( WebDriver driver){
        isElementDisplayed(registeredUser , driver);
        String Info = registeredUser.getText() ;
        return Info ;


    }


}
