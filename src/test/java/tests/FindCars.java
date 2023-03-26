package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FindCars extends TestBase{
    @BeforeMethod
//    public void preCondition() {
//        if (app.getUser().isLogged()) {
//            app.getUser().logout();
//        }


        @Test
        public void SearchPositiveTest(){
           // User data = new User().withEmail("asd@fgh.com").withPassword("$Asdf1234");
            app.getSearch().openSearchForm();
            app.getSearch().fillSearchForm("Tel");
            app.getSearch().submitForm();
         //   Assert.assertTrue(app.getSearch().isLoggedSuccess());


        }


        @AfterMethod
        public void postCondition(){
           // app.getSearch().clickOkButton();
        }

    }





