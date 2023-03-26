package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperSearch extends HelperBase {
    public HelperSearch(WebDriver wd) {
        super(wd);
    }


    public void openSearchForm() {
        wd.findElement( By.xpath("//a[.=' Search ']")).click();
    }

    public void fillSearchForm(String city) {
        type(By.id("city"), city);
        click(By.xpath("//div[@class='pac-item'][2]"));
        click(By.id("dates"));
        click(By.cssSelector("td[aria-label='March 30, 2023']"));
        click(By.cssSelector("td[aria-label='March 31, 2023']"));

    }

//    public void fillLoginForm(User data) {//overloading
//        type(By.id("email"), data.getEmail());
//        type(By.id("password"), data.getPassword());
//    }




    public void submitForm() {
        //click(By.cssSelector("[type='submit']"));
        wd.findElement(By.cssSelector("[type='submit']")).submit();
    }
//    public void clickOkButton() {
//        if (isElementPresent(By.xpath("//button[.='Ok']"))) {
//            click(By.xpath("//button[.='Ok']"));
//        }
//
//    }

//    public boolean isLoggedSuccess() {
//    }
}
