
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Regression Test")
@Feature("Registration Tests")



public class RegistrationTest extends TestBase{

    RegistrationPage registrationPageObj ;
    ProfilePage profilePageObj ;
    Helper helper = new Helper();


    String FirstName = helper.GetRandomString() ;
    String LastName = helper.GetRandomString() ;
    String MobNo = "011"+helper.GetRandomIntger() ;
    String Email = helper.GetRandomString()+"@gmail.com";
    String Password = helper.GetRandomPassword() ;


    @Test(priority = 1, description= "valid_Registration_Scenario")
    @Story("User Can Register with all valid data")
    @Severity(SeverityLevel.BLOCKER)
    public void user_can_Register_Successfully(){
        registrationPageObj = new RegistrationPage(driver) ;
        registrationPageObj.userEnterFN(FirstName.toUpperCase() , driver);
        registrationPageObj.userEnterLN(LastName.toUpperCase(),driver);
        registrationPageObj.userEnterMobNu(MobNo , driver);
        registrationPageObj.userEnterEmail(Email , driver);
        registrationPageObj.userEnterPassword(Password ,driver);
        registrationPageObj.userEnterConfirmPassword(Password , driver);
        registrationPageObj.userClickSignUp(driver);
        profilePageObj = new ProfilePage(driver);
        Assert.assertTrue(profilePageObj.getTheUserInfo(driver).contains(FirstName));
    }


    @Test(priority = 1, description= "valid_Registration_Scenario")
    @Severity(SeverityLevel.CRITICAL)
    @Story("User Cannot Register without Confirm the Password")
    public void user_cannot_Register_Successfully(){
        registrationPageObj = new RegistrationPage(driver) ;
        registrationPageObj.userEnterFN(FirstName.toUpperCase() , driver);
        registrationPageObj.userEnterLN(LastName.toUpperCase(),driver);
        registrationPageObj.userEnterMobNu(MobNo , driver);
        registrationPageObj.userEnterEmail(Email , driver);
        registrationPageObj.userEnterPassword(Password ,driver);
        registrationPageObj.userClickSignUp(driver);
        profilePageObj = new ProfilePage(driver);
        Assert.assertTrue(profilePageObj.getTheUserInfo(driver).contains(FirstName));
    }












}
