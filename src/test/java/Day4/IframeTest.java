package Day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IframeTest extends TestBase {

    @BeforeMethod
    public void openIframesPage() {
        driver.get("https://seleniumui.moderntester.pl/iframes.php");
    }

    @Test
    public void iframeTest() {
        driver.switchTo().frame("iframe1");
        driver.findElement(By.id("inputFirstName3")).sendKeys("Jan");
        driver.findElement(By.id("inputSurname3")).sendKeys("Nowak");
        //driver.findElement(By.cssSelector(".btn-primary")).click();

        //wyjście z iframe
        driver.switchTo().defaultContent();

        driver.switchTo().frame("iframe2");
        driver.findElement(By.id("inputLogin")).sendKeys("user");
        driver.findElement((By.id("inputPassword"))).sendKeys("pass");
        Select selectContinents = new Select(driver.findElement(By.id("inlineFormCustomSelectPref")));
        selectContinents.selectByVisibleText("Europe");
        WebElement yearsOfExperience = driver.findElement(By.id("gridRadios4"));
        yearsOfExperience.click();
        //driver.findElement(By.cssSelector(".btn-primary")).click();
    }


}
