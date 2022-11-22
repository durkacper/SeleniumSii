package Day5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public abstract class BasePO {
    protected WebDriver driver;
    protected String ownURL;
    public WebDriverWait wait;

    public void openMe() {
        driver.get(ownURL);
    }

    //konstruktor
    public BasePO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); //kazdego elementu bedzie szukal min 20s
        wait = new WebDriverWait(driver, 20);
    }
//


    protected WebElement getRandomElement(List<WebElement> elemnts) {
        Random rnd = new Random();
        int randomNumber = rnd.nextInt(elemnts.size() - 1);
        return elemnts.get(randomNumber);
    }

    protected int getRandomNumber(int max) {
        Random rnd = new Random();
        int randomNumber = rnd.nextInt(max) + 1;
        return randomNumber;
    }

    protected void veryBadSleep() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
