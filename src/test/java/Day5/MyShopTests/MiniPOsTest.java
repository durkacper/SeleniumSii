package Day5.MyShopTests;

import Day4.TestBase;
import Day5.MyStore.CartPO;
import Day5.MyStore.HomepagePO;
import Day5.MyStore.ProductAddConfirmationPO;
import Day5.MyStore.QuickViewPO;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MiniPOsTest extends TestBase {

    @Test
    public void allPricesCanBeGetFromPOsTest() {
        HomepagePO homepagePO = new HomepagePO(driver);
        homepagePO.openMe();
        homepagePO.printAllPrices();
    }


    //kliknij w randomową Miniature w Quickview i porównaj czy nazwy są takie same na stronie głownej i quickview
    @Test
    public void nameInQuickViewShouldBeTheSameAsOnTheMiniatureTest() {
        HomepagePO homepagePO = new HomepagePO(driver);
        homepagePO.openMe();
        int n = getRandomNumber(homepagePO.miniaturesNumber() - 1);
        String name1 = homepagePO.getNameOfNthMiniature(n);
        homepagePO.openQuickViewOfNthMiniature(n);
        QuickViewPO quickViewPO = new QuickViewPO(driver);
        Assert.assertEquals(name1, quickViewPO.getTitle());
    }


    //wybierz randomowy element z homepage
    //kliknij quickview
    //wpisz losową liczbe w Quantity (1-10)
    //dodaj do koszyka
    //przejdz do koszyka
    //sprawdz nazwe i sumaryczna cene w koszyku
    @Test
    public void itemsInTheCartShouldHaveCorrectSummaryPrice() {
        HomepagePO homepagePO = new HomepagePO(driver);
        homepagePO.openMe();
        int n = getRandomNumber(homepagePO.miniaturesNumber() - 1);
        String name1 = homepagePO.getNameOfNthMiniature(n);
        homepagePO.openQuickViewOfNthMiniature(n);

        int quantityRandomNumber = getRandomNumber(10);
        System.out.println(quantityRandomNumber); // dla mnie do wgladu

        QuickViewPO quickViewPO = new QuickViewPO(driver);
        quickViewPO.setQuantityNumber(quantityRandomNumber);
        //quickViewPO.setQuantityNumber(); - gdybym ustawil na sztywno ilosc produkctow
        quickViewPO.clickAddToCartButton();

        ProductAddConfirmationPO productAddConfirmationPO = new ProductAddConfirmationPO(driver);
        productAddConfirmationPO.clickProceedToCheckOutButton();

        CartPO cartPO = new CartPO(driver);
        String prodNameInCart = cartPO.getProductNameInCart();
        double sumPrice = cartPO.getSummaryPrice();
        double prodPrice = cartPO.getProductPrice();

        Assert.assertEquals(name1, prodNameInCart);
        Assert.assertEquals(sumPrice, prodPrice);
    }

}
