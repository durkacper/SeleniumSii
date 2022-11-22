package Day5.MyStore;

import Day5.BasePO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductMiniaturePO {


    @FindBy(css = ".price")
    private WebElement price;

    @FindBy(css = ".product-title")
    private WebElement productTitle;

    @FindBy(css = ".thumbnail")
    private WebElement thumbnail;

    @FindBy(css = ".quick-view")
    private WebElement quickView;


    public double getProductPrice() {
        String priceNumber = price.getText().replace("$", "");
        return Double.valueOf(priceNumber);
    }

    public String getProductTitle() {
        return productTitle.getText();
    }

    public void clickMe() {
        thumbnail.click();
    }

    public void clickQuickView() {
        Actions actions = new Actions(driver);
        actions.moveToElement(thumbnail).build().perform();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(quickView));
        quickView.click();
    }


    private WebDriver driver;

    public ProductMiniaturePO(WebElement productMiniature, WebDriver driver) {
        PageFactory.initElements(new DefaultElementLocatorFactory(productMiniature), this);
        this.driver = driver;
    }

}
