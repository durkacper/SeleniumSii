package Day5.MyStore;

import Day5.BasePO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class QuickViewPO extends BasePO {

    @FindBy(css = "h1.h1")
    private WebElement title;

    @FindBy(css = "#quantity_wanted")
    private WebElement quantityValue;

    @FindBy(css = "button.add-to-cart")
    private WebElement addToCartButton;

    @FindBy(css = ".cart-content-btn a")
    private WebElement proceedToCheckOutButton;


    public void clickAddToCartButton() {
        addToCartButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckOutButton));
    }

    //musze dac jakis parametr n zeby wykorzystac randomizacje - inaczej musialbym podac sendKeys na sztywno
    public void setQuantityNumber(int n) {
        quantityValue.clear();
        quantityValue.sendKeys(Integer.toString(n));
    }


    public String getTitle() {
        return title.getText();
    }


    public QuickViewPO(WebDriver driver) {
        super(driver);
    }
}
