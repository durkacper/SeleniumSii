package Day4;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertTests extends TestBase {

    @BeforeMethod
    public void openalertPage() {driver.get("https://seleniumui.moderntester.pl/alerts.php");    }


    @Test
    public void simpleAlert(){
        driver.findElement(By.id("simple-alert")).click();
        driver.switchTo().alert().accept();
        String validationMessage = driver.findElement(By.id("simple-alert-label")).getText();
        Assert.assertEquals(validationMessage, "OK button pressed");
    }

    @Test
    public void promptAlertAccept() {
        driver.findElement(By.id("prompt-alert")).click();
        driver.switchTo().alert().sendKeys("Gwidon Ryba");
        driver.switchTo().alert().accept();

        String message = driver.findElement(By.id("prompt-label")).getText();
        Assert.assertEquals(message, "Hello Gwidon Ryba! How are you today?");

    }

    @Test
    public void promptAlertCancel() {
        driver.findElement(By.id("prompt-alert")).click();
        driver.switchTo().alert().dismiss();

        String message = driver.findElement(By.id("prompt-label")).getText();
        Assert.assertEquals(message, "User cancelled the prompt.");
    }


    @Test
    public void confirmAlertBoxOk() {
        driver.findElement(By.id("confirm-alert")).click();
        driver.switchTo().alert().accept();

        String message = driver.findElement(By.id("confirm-label")).getText();
        Assert.assertEquals(message, "You pressed OK!");
    }

    @Test
    public void confirmAlertBoxCancel() {
        driver.findElement(By.id("confirm-alert")).click();
        driver.switchTo().alert().dismiss();

        String message = driver.findElement(By.id("confirm-label")).getText();
        Assert.assertEquals(message, "You pressed Cancel!");
    }
}

