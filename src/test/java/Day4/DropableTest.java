package Day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropableTest extends TestBase {

    private WebElement drag;
    private WebElement drop;
    private Actions actions;

    @BeforeMethod
    public void openDropablePage() {
        driver.get("https://seleniumui.moderntester.pl/droppable.php");
        drag = driver.findElement(By.id("draggable"));
        drop = driver.findElement(By.id("droppable"));
        actions = new Actions(driver);
    }


    @Test
    public void dragAndDrop() {
        actions.dragAndDrop(drag, drop)
                .perform();
    }


    @Test
    public void dragAndDropByOffset(){
        int x1 = drag.getLocation().getX();
        int y1 = drag.getLocation().getY();
        int x2 = drop.getLocation().getX();
        int y2 = drop.getLocation().getY();

        actions.dragAndDropBy(drag, x2 -x1, y2 -y1)
                .perform();
    }

    @AfterMethod
    public void verify() {
        Assert.assertEquals(drop.getText(), "Dropped!");
    }

}
