package Day5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProgressBarPO extends BasePO {
//szuka po klasie ktora pojawia sie dopiero po zaladowaniu paska
    @FindBy(css = ".ui-progressbar-complete")
    private WebElement completeProgressBar;




    public boolean progressBarIsComplete(){
        return completeProgressBar.isDisplayed();
    }







    public ProgressBarPO(WebDriver driver) {
        super(driver);
        ownURL = "https://seleniumui.moderntester.pl/progressbar.php";
    }
}
