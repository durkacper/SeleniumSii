package Day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;
import java.util.Random;

public class FormTest extends TestBase {


    @Test
    public void formTest() {
        driver.get("https://seleniumui.moderntester.pl/form.php");

        WebElement firstName = driver.findElement(By.cssSelector("#inputFirstName3"));
        firstName.sendKeys("Jan");

        WebElement lastName = driver.findElement(By.cssSelector("#inputLastName3"));
        lastName.sendKeys("Nowak");

        WebElement email = driver.findElement(By.cssSelector("input#inputEmail3"));
        email.sendKeys("jannowak@mail.pl");

        WebElement sex = driver.findElement(By.cssSelector("#gridRadiosMale"));
        sex.click();

        WebElement age = driver.findElement(By.cssSelector("#inputAge3"));
        age.sendKeys("28");

        List<WebElement> yearOfExperience = driver.findElements(By.name("gridRadiosExperience"));
        getRandomElement(yearOfExperience).click();

        WebElement profession = driver.findElement(By.id("gridCheckManulTester"));
        profession.click();


        //Continents
        WebElement continentsElements = driver.findElement(By.id("selectContinents"));
        Select continentsSelect = new Select(continentsElements);
        List<WebElement> continentsOptions = continentsSelect.getOptions();
        continentsOptions.remove(0); //wyrzucam z listy opcji "Choose..."
        WebElement randomOption = getRandomElement(continentsOptions);
        continentsSelect.selectByVisibleText(randomOption.getText());


        //SeleniumCommands
        WebElement seleniumCommands = driver.findElement(By.id("selectSeleniumCommands"));
        Select seleniumCommandSelect = new Select(seleniumCommands);
        //seleniumCommandSelect.selectByValue("browser-commands");
        List<WebElement> commandOptions = seleniumCommandSelect.getOptions();
        int howManyOptions = getRandomNumber(commandOptions.size());
        for (int i = 0; i < howManyOptions; i++) {
            seleniumCommandSelect.selectByIndex(i);
        }

        //File
        WebElement fileInput = driver.findElement(By.id("chooseFile"));
        File file = new File("src/main/resources/emptyFile.txt");
        fileInput.sendKeys(file.getAbsolutePath());


        //AdditionalInformations
        WebElement additionalInformations = driver.findElement(By.id("additionalInformations"));
        additionalInformations.sendKeys("Test");

        //SignIn
        WebElement signIn = driver.findElement(By.cssSelector("button[type='submit']"));
        signIn.click();

        //Assert
        String validationMessage = driver.findElement(By.id("validator-message")).getText();
        Assert.assertEquals(validationMessage, "Form send with success");

    }





}
