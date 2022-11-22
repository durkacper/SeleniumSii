package Day5.MyStore;

import Day5.BasePO;
import org.jsoup.Connection;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class CartPO extends BasePO {

    @FindBy(css = "span.product-price")
    private WebElement productPrice;

    @FindBy(css = "#cart-subtotal-products .value")
    private WebElement summaryPrice;

    @FindBy(css = ".product-line-info a")
    private WebElement productNameInCart;

    @FindBy(css = ".js-subtotal")
    private WebElement numberOfItemsSum;

    @FindBy(css = ".remove-from-cart")
    private WebElement productRemoveButton;

    @FindBy(css = ".header > a")
    private WebElement cartButton;



    public void clickRemoveButton(){
        productRemoveButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(cartButton));
    }

    public int getNumberOfItemsSum(){
        return Integer.parseInt(numberOfItemsSum.getText().replace(" items","").replace(" item","").replace(",",""));
    }

    public String getProductNameInCart() {
        return productNameInCart.getText();
    }

    public Double getProductPrice() {
        String productPriceDouble = productPrice.getText().replace("$", "");
        return Double.valueOf(productPriceDouble);
    }

    public Double getSummaryPrice() {
        String summaryPriceDouble = summaryPrice.getText().replace("$", "");
        return Double.valueOf(summaryPriceDouble);
    }


    public CartPO(WebDriver driver) {
        super(driver);
    }
}
