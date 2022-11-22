package Day5.MyShopTests;

import Day4.TestBase;
import Day5.MyStore.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShopProcessTests extends TestBase {

    //3 razy wylosuj produkt i ilosc -> dodaj do koszyka (przez QuickView)
    //przejdz do koszyka
    //sprawdz czy dodaly sie wszystkie produkty (suma produktow)
    //sprawdz czy suma cen jest prawidłowa

    @Test
    public void shouldCorrectlyAddMultipleItemsToCartTest() {
        HomepagePO homepagePO = new HomepagePO(driver);
        MenuPO menuPO = new MenuPO(driver);
        CartPO cartPO = new CartPO(driver);
        ProductAddConfirmationPO productAddConfirmationPO = new ProductAddConfirmationPO(driver);
        QuickViewPO quickViewPO = new QuickViewPO(driver);
        homepagePO.openMe();

        int totalQuantity = 0;
        double value = 0;

        for (int i = 0; i < 3; i++) {

            int numberOfRandomMiniature = getRandomNumber(homepagePO.miniaturesNumber() - 1);
            double price = homepagePO.getPriceOfNthMiniature(numberOfRandomMiniature);
            int quantity = getRandomNumber(10);
            value += price * quantity;
            totalQuantity += quantity;
            homepagePO.openQuickViewOfNthMiniature(numberOfRandomMiniature);
            quickViewPO.setQuantityNumber(quantity);
            quickViewPO.clickAddToCartButton();
            productAddConfirmationPO.clickContinueShoppingButton();
        }
        menuPO.goToCart();

        Assert.assertEquals(value, cartPO.getSummaryPrice(), 0.001);
        Assert.assertEquals(totalQuantity, cartPO.getNumberOfItemsSum());
    }


    //usuwanie produktu
    //sprawdzenie czy ilosc produktow i cena suma zmienią się
    @Test
    public void removeProductTest() {
        HomepagePO homepagePO = new HomepagePO(driver);
        MenuPO menuPO = new MenuPO(driver);
        CartPO cartPO = new CartPO(driver);
        ProductAddConfirmationPO productAddConfirmationPO = new ProductAddConfirmationPO(driver);
        QuickViewPO quickViewPO = new QuickViewPO(driver);
        homepagePO.openMe();

        int totalQuantity = 0;
        double value = 0;

        for (int i = 0; i < 3; i++) {
            int numberOfRandomMiniature = getRandomNumber(homepagePO.miniaturesNumber() - 1);
            double price = homepagePO.getPriceOfNthMiniature(numberOfRandomMiniature);
            int quantity = getRandomNumber(10);
            value += price * quantity;
            totalQuantity += quantity;
            homepagePO.openQuickViewOfNthMiniature(numberOfRandomMiniature);
            quickViewPO.setQuantityNumber(quantity);
            quickViewPO.clickAddToCartButton();
            productAddConfirmationPO.clickContinueShoppingButton();
        }
        menuPO.goToCart();
        double itemsCount = cartPO.getProductPrice();
        double totalPrice = cartPO.getSummaryPrice();
        cartPO.clickRemoveButton();
        double itemsCountAfterRemove = cartPO.getNumberOfItemsSum();
        double totalPriceAfterRemove = cartPO.getSummaryPrice();

        Assert.assertTrue(itemsCount>itemsCountAfterRemove, "OK");
        Assert.assertTrue(totalPrice>totalPriceAfterRemove, "OK");
    }
}
