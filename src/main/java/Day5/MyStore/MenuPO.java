package Day5.MyStore;

import Day5.BasePO;
import org.apache.commons.io.input.WindowsLineEndingInputStream;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;

public class MenuPO extends BasePO {

    @FindBy(css = ".user-info .hidden-sm-down")
    private WebElement signInOut;

    @FindBy(css = ".logout")
    private WebElement signOutOnly;

    @FindBy(css = ".account>span.hidden-sm-down")
    private WebElement nameOfLoggedInUser;

    @FindBy(css = ".header > a")
    private WebElement cartButton;

    public void goToCart(){
        cartButton.click();
    }

//    String price = price.getText().replace("$","");
//    return Double.ValueOf(price)

    public void clickSignInOutButton(){
        signInOut.click();
    }

    public boolean logoutVisible(){
        return signOutOnly.isDisplayed();
    }
    public String getUserName(){
        return nameOfLoggedInUser.getText();
    }



    public MenuPO(WebDriver driver){

        super(driver);
    }

}
