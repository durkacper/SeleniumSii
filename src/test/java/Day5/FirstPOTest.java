package Day5;

import Day4.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstPOTest extends TestBase {
    @Test
    public void firstTest() {
        //given
        FormPO formPO = new FormPO(driver);
        formPO.openMe();
        //when
        formPO.fillName("Bogdan", "Wiadro");
        formPO.fillEmail("test@test.com");
        formPO.selectMale();
        formPO.fillAge(45);
        formPO.selectRandomExperience();
        formPO.selectManualTester();
        formPO.selectRandomContinent();
        formPO.selectRandomCommand();
        formPO.fillFileInput();
        formPO.fillAdditionalInformation("Tralalala");
        formPO.submit();
        //then
        Assert.assertEquals(formPO.getValidatorMessageText(), "Form send with success");
    }


    @Test
    public void alternativeFirstTest() {
        FormAlternativePO formAlternativePO = new FormAlternativePO(driver);
        formAlternativePO.openMe();
//        Assert.assertEquals(
//        formAlternativePO
//                .fillName("Jan", "Kowalski")
//                .fillEmail("test1@test.pl")
//                .selectMale()
//                .fillAge(33)
//                .selectRandomExperience()
//                .selectManualTester()
//                .selectRandomContinent()
//                .selectRandomCommand()
//                .fillFileInput()
//                .fillAdditionalInformation("lalal")
//                .submit(),
//                "Form send with success");

        formAlternativePO
                .fillName("Jan", "Kowalski")
                .fillEmail("test1@test.pl")
                .selectMale()
                .fillAge(33)
                .selectRandomExperience()
                .selectManualTester()
                .selectRandomContinent()
                .selectRandomCommand()
                .fillFileInput()
                .fillAdditionalInformation("lalal")
                .submit();

        Assert.assertEquals(formAlternativePO.getValidatorMessageText(), "Form send with success");
    }


    @Test
    public void progressBarTest() {
        ProgressBarPO progressBarPO = new ProgressBarPO(driver);
        progressBarPO.openMe();
        Assert.assertTrue(progressBarPO.progressBarIsComplete());
    }


    @Test
    public void testDelayedAlert() {
        AlertPO alertPO = new AlertPO(driver);
        alertPO.openMe();
        alertPO.clickDelayedAlertButton();
        alertPO.waitForAlertAndAccept();
        Assert.assertEquals(alertPO.getDelayedAlertLabelText(), "OK button pressed");
    }


    @Test
    public void alertAlternativeTest(){
        AlertAlternativePO alertAlternativePO = new AlertAlternativePO(driver);
        alertAlternativePO.openMe();

        alertAlternativePO
                .clickDelayedAlertButton()
                .waitForAlertAndAccept();

        Assert.assertEquals(alertAlternativePO.getDelayedAlertLabelText(), "OK button pressed");
    }
}
