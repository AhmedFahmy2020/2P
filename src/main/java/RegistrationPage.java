import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.Random;

public class RegistrationPage extends PageBase {


    public RegistrationPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//input[@name=\"firstname\"]")
    private WebElement firstNameTxt ;

    @FindBy (xpath = "//input[@name=\"lastname\"]")
    private WebElement lastNameTxt ;

    @FindBy(xpath = "//input[@name=\"phone\"]")
    private WebElement mobNumberTxt ;

    @FindBy(xpath = "//input[@name=\"email\"]")
    private WebElement emailTxt ;

    @FindBy(xpath = "//input[@name=\"password\"]")
    private WebElement passwordTxt ;

    @FindBy(xpath ="//input[@name=\"confirmpassword\"]")
    private WebElement confirmPasswordTxt ;

    @FindBy(xpath = "//button[@type='submit'][contains(text(),' Sign Up')]")
    private WebElement signUpBtn ;

    @Step("User Enter the First Name ")
    public void userEnterFN (String FirstName , WebDriver driver){
        isElementDisplayed(firstNameTxt , driver);
        TypeText(firstNameTxt , FirstName);

    }

    @Step("User Enter the Last Name ")
    public void userEnterLN (String LastName , WebDriver driver){
        isElementDisplayed(lastNameTxt , driver);
        TypeText(lastNameTxt , LastName);

    }

    @Step("User Enter the Mobile Number ")
    public void userEnterMobNu (String MobNo , WebDriver driver){
        isElementDisplayed(mobNumberTxt , driver);
        TypeText(mobNumberTxt , MobNo);

    }

    @Step("User Enter the Email ")
    public void userEnterEmail (String Email, WebDriver driver){
        isElementDisplayed(emailTxt , driver);
        TypeText(emailTxt , Email);

    }

    @Step("User Enter the Password ")
    public void userEnterPassword (String Password , WebDriver driver){
        isElementDisplayed(passwordTxt , driver);
        TypeText(passwordTxt , Password);

    }
    @Step("User Enter the Confirm Password ")
    public void userEnterConfirmPassword (String ConfPassword , WebDriver driver){
        isElementDisplayed(confirmPasswordTxt , driver);
        TypeText(confirmPasswordTxt , ConfPassword);

    }

    @Step("User Click SignUP ")
    public void userClickSignUp ( WebDriver driver){
        isElementDisplayed(signUpBtn , driver);
        click(signUpBtn);

    }


}
