package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperUser extends HelperBase {
    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void fillLoginForm(String email, String password) {
        type(By.id("email"), email);
        type(By.id("password"), password);
    }

    public void fillLoginForm(User data) {//overloading
        type(By.id("email"), data.getEmail());
        type(By.id("password"), data.getPassword());
    }

    public void fillRegistrationForm(String name, String lastName, String email, String password) {
        type(By.id("name"), name);
        type(By.id("lastName"), lastName);
        type(By.id("email"), email);
        type(By.id("password"), password);
    }

    public void fillRegistrationForm(User user) {
        type(By.id("name"), user.getName());
        type(By.id("lastName"), user.getLastName());
        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());
    }

    public void submitForm() {
        //click(By.cssSelector("[type='submit']"));
        wd.findElement(By.cssSelector("[type='submit']")).submit();
    }

    public void clickCheckbox() {
        //variant 1
//click(By.xpath("//label[@for='terms-of-use']"));
        //variant 2
       // JavascriptExecutor script = (JavascriptExecutor) wd;
    //    script.executeScript("document.querySelector('#terms-of-use').click()");
        //variant 3
        Rectangle rect = wd.findElement(By.xpath("//*[@class='checkbox-container']")).getRect();
        int x = rect.getX() + 5;
        int y = rect.getY() + rect.getHeight() * 1/2;
        Actions actions = new Actions(wd);
        actions.moveByOffset(x, y).click().perform();


    }


    public void openLoginForm() {

        click(By.xpath("//a[.=' Log in ']"));
    }

    public void openRegistrationForm() {
        click(By.xpath("//a[.=' Sign up ']"));
    }

    public void logout() {

        click(By.xpath("//a[.=' Logout ']"));
    }

  //  public boolean isLogged() {return isElementPresent(By.xpath("//button[.='Sign Out']"));}
    public boolean isLogged() {

        return isElementPresent(By.xpath("//a[.=' Logout ']"));
    }


    public boolean isLoggedSuccess() {
        WebDriverWait wait = new WebDriverWait(wd, 10);
        wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.id("cdk-overlay-0"))));
        return wd.findElement(By.id("cdk-overlay-0")).getText().contains("success");

        // wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.xpath("//h2[.='Logged in success']"))));
        // return wd.findElement(By.linkText("//h2[.='Logged in success']")).getText().contains("success");
    }

//    public boolean isRegisteredSuccess() {
//        WebDriverWait wait = new WebDriverWait(wd, 10);
//         wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.xpath("//h2[.='You are logged in success']"))));
//         return wd.findElement(By.linkText("//h2[.='you are logged in success']")).getText().contains("success");
//    }

    public boolean isLoggedFailed() {
   WebDriverWait wait = new WebDriverWait(wd, 10);
      wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.xpath("//div[.=\"It'snot look like email\"]"))));
      return wd.findElement(By.xpath("//div[.=\"It'snot look like email\"]")).getText().contains("like email");
    }


    public void clickOkButton() {
        if (isElementPresent(By.xpath("//button[.='Ok']"))) {
            click(By.xpath("//button[.='Ok']"));
        }

    }

    public void pause(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }


    public boolean isRegistrationFailedReRegistration() {
        WebDriverWait wait = new WebDriverWait(wd, 10);
        wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.xpath("//h2[@class='message']"))));
        return wd.findElement(By.xpath("//h2[@class='message']")).getText().contains("User already exists");

    }
    public boolean isRegistrationFailed() {
        WebDriverWait wait = new WebDriverWait(wd, 10);
       wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.xpath("//div[.=\"Wrong email format\"]"))));
       return wd.findElement(By.xpath("//div[.=\"Wrong email format\"]")).getText().contains("Wrong email format");

       //wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.xpath("//h1[@class='title']"))));
      // return wd.findElement(By.xpath("//h1[@class='title']")).getText().contains("Registration failed");
    }
}


