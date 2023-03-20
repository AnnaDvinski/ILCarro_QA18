package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
    public void fillRegistrationForm(String name, String lastName, String email, String password) {
        type(By.id("name"), name);
        type(By.id("lastName"), lastName);
        type(By.id("email"), email);
        type(By.id("password"), password);
    }
    public void submitForm() {
        //click(By.cssSelector("[type='submit']"));
        wd.findElement(By.cssSelector("[type='submit']")).submit();
    }

    public void clickCheckbox() {
click(By.xpath("//label[@class='checkbox-label terms-label']"));

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

    public boolean isRegistrationSuccess() {
        WebDriverWait wait = new WebDriverWait(wd, 10);
        wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.xpath("//h2[@class='message']"))));
        return wd.findElement(By.xpath("//h2[@class='message']")).getText().contains("success");

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


