package Day5.MyShopTests;

import Day4.TestBase;
import Day5.BasePO;
import Day5.MyStore.CreateAccountPO;
import Day5.MyStore.HomepagePO;
import Day5.MyStore.LoginPO;
import Day5.MyStore.MenuPO;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserCreation extends TestBase {


    @Test
    public void testUserRegistration(){
        //given
        String firstname = "Karol";
        String lastname = "Nowak";
        String email = "test"+System.currentTimeMillis()+"@test.com";
        HomepagePO homepagePO = new HomepagePO(driver);
        homepagePO.openMe();
        //when
        MenuPO menuPO = new MenuPO(driver);
        menuPO.clickSignInOutButton();
        LoginPO loginPO = new LoginPO(driver);
        loginPO.clickCreateAccountLink();
        CreateAccountPO createAccountPO = new CreateAccountPO(driver);
        createAccountPO.fillFormAndSubmit(true,
                firstname,
                lastname,
                email,
                "AAABBVV",
                "02/02/1999");

        //then
        Assert.assertTrue(menuPO.logoutVisible());
        Assert.assertEquals(menuPO.getUserName(), firstname +" "+lastname);

    }
}

