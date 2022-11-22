package Day5.MyStore;

import Day5.BasePO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductAddConfirmationPO extends BasePO {

    @FindBy(css = ".cart-content-btn a")
    private WebElement proceedToCheckOutButton;

    @FindBy(css = ".btn-secondary")
    private WebElement continueShoppingButton;

    @FindBy(css = "#blockcart-modal")
    private WebElement blockcartModal;

    public void clickProceedToCheckOutButton() {
        wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckOutButton));
        proceedToCheckOutButton.click();
    }

    public void clickContinueShoppingButton() {

        continueShoppingButton.click();
        wait.until(ExpectedConditions.invisibilityOf(blockcartModal));
    }


    public ProductAddConfirmationPO(WebDriver driver) {
        super(driver);
    }
}
