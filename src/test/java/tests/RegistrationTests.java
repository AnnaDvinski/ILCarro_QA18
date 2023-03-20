package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase{
    @BeforeMethod
    public void preCondition(){
        if(app.getUser().isLogged()){
            app.getUser().logout();
        }
    }
@Test
    public void registrationPositiveTest(){
    app.getUser().openRegistrationForm();
    int i = (int) (System.currentTimeMillis() / 1000) % 3600;
    String name = "Anna";
    String lastName = "Nnnnnnn";
    String email = "name" + i + "@mail.com";
    String password = "$Asdf1234";
    app.getUser().fillRegistrationForm(name, lastName, email, password);
    app.getUser().clickCheckbox();
    app.getUser().submitForm();
    Assert.assertTrue(app.getUser().isRegistrationSuccess());

}
    @Test
    public void registrationNegativeTestReRegistration(){
        app.getUser().openRegistrationForm();
        app.getUser().fillRegistrationForm("Anna", "Nnnnnnn",  "asd@zgh.com", "$Asdf1234");
        app.getUser().clickCheckbox();
        app.getUser().submitForm();
        app.getUser().pause(5000);
        Assert.assertTrue(app.getUser().isRegistrationFailedReRegistration());
    }
    @Test
    public void registrationNegativeTestWrongEmail(){
        app.getUser().openRegistrationForm();
        app.getUser().fillRegistrationForm("Anna", "Nnnnnnn",  "asdzgh.com", "$Asdf1234");
        app.getUser().clickCheckbox();
       // app.getUser().submitForm();
        app.getUser().pause(5000);
        Assert.assertTrue(app.getUser().isRegistrationFailed());
    }



    @AfterMethod
    public void postCondition(){

        app.getUser().clickOkButton();
    }


}
