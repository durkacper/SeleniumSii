package Day4;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DatePickerTest extends TestBase {

    @BeforeMethod
    public void openDatepicketPage() {
        driver.get("https://seleniumui.moderntester.pl/datepicker.php");
    }

    @Test
    public void calendarTest() {
        selectDate("10", "October", 2019);
        Assert.assertEquals(getSelectedDate(), "10/10/2020");
    }

    private void selectDate(String expectedDay, String expectedMonth, int expectedYear) {
// ta metoda do zbudowania
    }

    private String getSelectedDate() {
        return driver.findElement(By.id("datepicker")).getText();
    }

    public String getMonth() {
        return driver.findElement(By.cssSelector(".ui-datepicker-month")).getText();
    }

    public int getYear() {
        return Integer.parseInt(driver.findElement(By.cssSelector(".ui-datepicker-year")).getAttribute("value"));
        //getText() tutaj nie zadziała
    }

    public void goNext(String expectedMonth, int expectedYear) {
        while (!expectedMonth.equals(getMonth()) || expectedYear != getYear()) {
            driver.findElement(By.cssSelector(".ui-datepicker-next")).click();
            veryBadSleep();
        }
    }

    public void goPrev(String expectedMonth, int expectedYear) {
        while (!expectedMonth.equals(getMonth()) || expectedYear != getYear()) {
            driver.findElement(By.cssSelector(".ui-datepicker-prev")).click();
            veryBadSleep();
        }
    }
}

//Jak wyciągnąć listę dni aktualnego miesiąca? - .ui-state-default:not(.ui-priority-secondary)
// zbudować metodę selectDate - przesunąć kalendarz na odpowieni rok i miesiąc, pobrac wszystkie
//dni dla tego miesiąca i wybrac konkretny dzien

//1.date-month = brać pod uwagę ten aktualny index miesiące

//2.najlepiej ten xpath: //tr/td[not(contains(@class, 'ui-datepicker-other-month '))]
//czyli wyciąga wszystkie dni aktualnego miesiąca