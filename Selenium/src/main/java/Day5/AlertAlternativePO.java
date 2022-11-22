package Day5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AlertAlternativePO extends BasePO {

    @FindBy(id = "delayed-alert")
    private WebElement delayedAlertButton;

    @FindBy(id = "delayed-alert-label")
    private WebElement delayedAlertLabel;


    public AlertAlternativePO clickDelayedAlertButton() {
        delayedAlertButton.click();
        return this;
    }

    public String getDelayedAlertLabelText() {
        return delayedAlertLabel.getText();
    }

    public AlertAlternativePO waitForAlertAndAccept() {
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        return this;
    }


    public AlertAlternativePO(WebDriver driver) {
        super(driver);
        ownURL = "https://seleniumui.moderntester.pl/alerts.php";
    }

}
