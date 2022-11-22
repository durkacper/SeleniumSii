package Day5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.List;

public class FormAlternativePO extends BasePO {

    //String ownURL = "https://seleniumui.moderntester.pl/form.php";

    @FindBy(id = "inputFirstName3")
    private WebElement inputFirstName;

    @FindBy(id = "inputLastName3")
    private WebElement inputLastName;

    @FindBy(css = "#inputEmail3")
    private WebElement inputEmail;

    @FindBy(name = "gridRadiosExperience")
    private List<WebElement> yearsOfExperience;

    @FindBy(css = "input[value='male']")
    private WebElement maleRadioButton;

    @FindBy(id = "gridCheckManulTester")
    private WebElement manualTesterGrid;

    @FindBy(id = "selectContinents")
    private WebElement selectContinents;

    @FindBy(id = "selectSeleniumCommands")
    private WebElement commands;

    @FindBy(id = "chooseFile")
    private WebElement fileInput;

    @FindBy(id = "additionalInformations")
    private WebElement additionalInformationTextBox;

    @FindBy(css = "button[type='submit']")
    private WebElement submitButton;

    @FindBy(id = "validator-message")
    private WebElement validatorMessage;

    @FindBy(id = "inputAge3")
    private WebElement ageTextBox;

    public FormAlternativePO selectRandomExperience() {
        getRandomElement(yearsOfExperience).click();
        return this;
    }

    public FormAlternativePO fillAge(int age) {
        ageTextBox.sendKeys(Integer.toString(age));
        return this;
    }

    public String getValidatorMessageText() {
        return validatorMessage.getText();
    }


    public FormAlternativePO submit() {
        submitButton.click();
        return this;
    }


    public FormAlternativePO fillAdditionalInformation(String text) {
        additionalInformationTextBox.sendKeys(text);
        return this;
    }


    public FormAlternativePO fillFileInput() {
        File file = new File("src/main/resources/emptyFile.txt");
        fileInput.sendKeys(file.getAbsolutePath());
        return this;
    }

    public FormAlternativePO selectRandomCommand() {
        Select commandSelect = new Select(commands);
        List<WebElement> commandsOptions = commandSelect.getOptions();
        int howManyOption = getRandomNumber(commandsOptions.size());
        for (int i = 0; i < howManyOption; i++) {
            commandSelect.selectByIndex(i);
        }
        return this;
    }


    public FormAlternativePO selectRandomContinent() {
        Select continents = new Select(selectContinents);
        List<WebElement> continentsOptions = continents.getOptions();
        continentsOptions.remove(0);
        WebElement randomOption = getRandomElement(continentsOptions);
        continents.selectByVisibleText(randomOption.getText());
        return this;
    }

    public FormAlternativePO selectManualTester() {
        manualTesterGrid.click();
        return this;
    }

    public FormAlternativePO selectMale() {
        maleRadioButton.click();
        return this;
    }

    public FormAlternativePO fillName(String firstname, String lastName) {
        inputFirstName.sendKeys(firstname);
        inputLastName.sendKeys(lastName);
        return this;
    }

    public FormAlternativePO fillEmail(String email) {
        inputEmail.sendKeys(email);
        return this;
    }

    public FormAlternativePO(WebDriver driver) {
        super(driver);
        ownURL = "https://seleniumui.moderntester.pl/form.php";
    }
}