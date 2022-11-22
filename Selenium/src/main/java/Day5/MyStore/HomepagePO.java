package Day5.MyStore;

import Day5.BasePO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class HomepagePO extends BasePO {

    @FindBy(css = ".product-miniature")
    private List<WebElement> allProductMiniatures; //tworzymy listę webelementow miniatur - z tej listy tworzymy PageObjecty

    @FindBy(css = ".add-to-cart")
    private WebElement quickViewAddToCart;


    //pobierz rozmiar listy miniatur
    public int miniaturesNumber() {
        return allProductMiniatures.size();
    }

    //kliknij w n-tą miniaturę z listy
    public void openQuickViewOfNthMiniature(int n) {
        getProductMiniatures().get(n).clickQuickView();
        wait.until(ExpectedConditions.elementToBeClickable(quickViewAddToCart));
    }

    //pobierz tytuł n-tej miniatury
    public String getNameOfNthMiniature(int n) {
        return getProductMiniatures().get(n).getProductTitle();
    }

    public Double getPriceOfNthMiniature(int n) {
        return getProductMiniatures().get(n).getProductPrice();
    }


    //metoda do wypisywania cen z wszystkich produktow (korzysta z metody poniżej)
    public void printAllPrices() {
        List<ProductMiniaturePO> allMiniatures = getProductMiniatures();
        for (ProductMiniaturePO pm : allMiniatures) {
            System.out.println(pm.getProductPrice());
        }
    }


    //tworzymy listę PageObjectów z wszystkich miniaturek na stronie
    private List<ProductMiniaturePO> getProductMiniatures() {
        List<ProductMiniaturePO> miniatures = new ArrayList<>(); //robimy pusta liste
        for (WebElement e : allProductMiniatures) {              //dla kazdego z elementow tworzymy PageObject
            miniatures.add(new ProductMiniaturePO(e, driver));   //dodajemy objekty do utworzonej listy
        }
        return miniatures;                                       //lista objektow
    }


    public HomepagePO(WebDriver driver) {
        super(driver);
        ownURL = "http://5.196.7.235/";
    }
}
