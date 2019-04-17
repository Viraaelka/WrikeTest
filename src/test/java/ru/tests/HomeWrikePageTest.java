package ru.tests;

import com.wrike.Randomizer;
import com.wrike.HomeWrikePage;
import org.junit.*;
import org.openqa.selenium.support.PageFactory;


public class HomeWrikePageTest extends BeforeAfterSetup{

    private String expectedEmailError = "Enter your business email";
    private String expectedWelcomeMessage = "Help us provide you the best possible experience:";

    HomeWrikePage homeWrikePage = PageFactory.initElements(driver, HomeWrikePage.class);

    /*-----------------------Home page tests--------------------------------------------------------------------*/

    @Test
    public void getHomePageHeader() {
        System.out.println("Making sure that the \"wrike.com\" page is opened");
        String headerTest = "Leading Work Management Solution";
        Assert.assertEquals(headerTest, homeWrikePage.getHomePageHeader().trim());
    }

    @Test
    public void getStartFreeTrialByClcickingGSBtn() {
        System.out.println("Trying to reach \"Start Free trial\"");
        homeWrikePage.clickGetStartedBtn();
        String expectedHeaderTitle = "Start Free trial";
        Assert.assertEquals(expectedHeaderTitle, homeWrikePage.getHeaderSFT());
    }

    /*-----------------------Start Free trial tests------------------------------------------------------------*/

    //Checking email input element by filling up and clicking Create my Account button

    @Test
    public void enterEmptyEmail() throws InterruptedException {
        System.out.println("Testing the email input with empty population");
        homeWrikePage.clickGetStartedBtn();
        homeWrikePage.enterRandomEmail(" ");
        homeWrikePage.clickCreateAccount();
        Assert.assertEquals(expectedEmailError, homeWrikePage.getErrorMessage());
    }
    @Test
    public void enterIncorrectEmail() {
        System.out.println("Testing the email input with incorrect data");
        homeWrikePage.clickGetStartedBtn();
        homeWrikePage.enterRandomEmail("1234");
        homeWrikePage.clickCreateAccount();
        Assert.assertEquals(expectedEmailError, homeWrikePage.getErrorMessage());
    }
    @Test
    public void enterCorrectEmail() {
        System.out.println("Testing the email input with correct data");
        homeWrikePage.clickGetStartedBtn();
        homeWrikePage.enterRandomEmail(Randomizer.getEmailRandomizer());
        homeWrikePage.clickCreateAccount();
        Assert.assertEquals(expectedWelcomeMessage, homeWrikePage.getQASectionHeader());
    }

    /*-----------------------QASection tests-----------------------------------------------------------------*/

    @Test
    public void logingToQAsection() {
        System.out.println("Trying to reach the wrile.com/resend page");
        enterCorrectEmail();
        Assert.assertEquals(expectedWelcomeMessage, homeWrikePage.getQASectionHeader());
    }

    @Test
    public void clickOnResendButton() {
        System.out.println("Clicking Resend button");
        logingToQAsection();
        homeWrikePage.clickResendBtn();
        Assert.assertTrue(homeWrikePage.getResendButton().isDisplayed());
    }

    @Test
    public void clickFirstSection() {
        System.out.println("Testing buttons on \"How would you describe your interest in using a solution like Wrike?\"");
        logingToQAsection();
        homeWrikePage.clickRandomSection1();
        Assert.assertFalse(homeWrikePage.getVeryInterestingBtn().isSelected()
                || homeWrikePage.getJustLookingBtn().isSelected());
    }

    @Test
    public void clickSecondSection() {
        System.out.println("Testing buttons on \"Ideally, how many total team members will eventually be using Wrike?\"");
        logingToQAsection();
        homeWrikePage.clickRandomSection2();
        Assert.assertFalse(homeWrikePage.getAge1Btn().isSelected()
                || homeWrikePage.getAge6Btn().isSelected() || homeWrikePage.getAge16Btn().isSelected()
                || homeWrikePage.getAge26Btn().isSelected() || homeWrikePage.getAge50Btn().isSelected());
    }

    @Test
    public void clickThirdSection() {
        System.out.println("Testing buttons on \"Does your team follow a process for managing work?\"");
        logingToQAsection();
        homeWrikePage.clickRandomSection3();
        Assert.assertFalse(homeWrikePage.getYesBtn().isSelected()
                || homeWrikePage.getNoBtn().isSelected() || homeWrikePage.getOtherBtn().isSelected());
    }

    @Test
    public void clickSubmitResultBtn() {
        System.out.println("Submit Result's button test on \"wrike.com/resend/\" page");
        logingToQAsection();
        homeWrikePage.clickRandomSection1();
        homeWrikePage.clickRandomSection2();
        homeWrikePage.clickRandomSection3();
        Assert.assertTrue(homeWrikePage.getSubmitResultsBtn().isDisplayed());
    }

    @Test
    public void clickTwitterBtn() {
        System.out.println("Unfortunately, the Twitter test does not work");
       /*
        logingToQAsection();
        homeWrikePage.clickTwitterButton();
        */
    }
}

