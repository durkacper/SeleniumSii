package Day4;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SelectTableTest extends TestBase{

    @BeforeMethod
    public void openIframesPage() {
        driver.get("https://seleniumui.moderntester.pl/selectable.php");
    }


    @Test
    public void shouldSelectItem(){
        List<WebElement> items = driver.findElements(By.cssSelector(".ui-widget-content"));
        int index = getRandomNumber(items.size());
        items.get(index-1).click();

        Assert.assertEquals(driver.findElement(By.id("select-result")).getText(), "#"+index);

    }

    @Test
    public void shouldSelectMultiple(){
        List<WebElement> items = driver.findElements(By.cssSelector(".ui-widget-content"));
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.LEFT_CONTROL)
                .click(items.get(3))
                .click(items.get(4))
                .click(items.get(5))
                .keyUp(Keys.LEFT_CONTROL)
                .build()
                .perform();

        Assert.assertEquals(driver.findElement(By.id("select-result")).getText(), "#4 #5 #6");
    }

}
