package com.wrike;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

public class HomeWrikePage {
    private WebDriver driver;
    public Randomizer randomArray = new Randomizer();

    /*-----------------------Home page variables----------------------------------------------*/

    @FindBy(xpath = "//div[@class='r']//button")
    WebElement getStartedBtn;

    @FindBy(xpath = "//h1[contains(., 'Leading')]")
    WebElement homePageHeader;

    /*-----------------------Start Free Trial valiables---------------------------------------*/

    @FindBy(xpath = "//form[@action='/']/div[contains(., 'Start Free trial')]")
    WebElement headerSFT;

    @FindBy(xpath = "//form/label/input")
    WebElement emailTextField;

    @FindBy(xpath = "//form//button[contains(., 'Create')]")
    WebElement createAccount;

    @FindBy(xpath = "//label//span")
    WebElement errorMessage;

    /*--------------------QA Section variables---------------------------------------------*/

    @FindBy(xpath = "//form[@class='survey-form']/h3")
    WebElement QASectionHeader;

    @FindBy(xpath = "//div[@class='wg-grid']/div/p/button")
    WebElement resendButton;

    @FindBy(xpath = "//button[contains(., 'Submit results')]")
    WebElement submitResultsBtn;
    /*============================================================*/
    ArrayList<WebElement> firstSection = new ArrayList<WebElement>();
    ArrayList<WebElement> secondSection = new ArrayList<WebElement>();
    ArrayList<WebElement> thirdSection = new ArrayList<WebElement>();

    @FindBy(xpath = "//button[text()='Very interested']")
    WebElement VeryInterestingBtn;
    @FindBy(xpath = "//button[text()='Just looking']")
    WebElement JustLookingBtn;

    @FindBy(xpath = "//button[text()='1–5']")
    WebElement Age1Btn;
    @FindBy(xpath = "//button[text()='6–15']")
    WebElement Age6Btn;
    @FindBy(xpath = "//button[text()='16–25']")
    WebElement Age16Btn;
    @FindBy(xpath = "//button[text()='26–50']")
    WebElement Age26Btn;
    @FindBy(xpath = "//button[text()='50+']")
    WebElement Age50Btn;

    @FindBy(xpath = "//button[text()='Yes']")
    WebElement YesBtn;
    @FindBy(xpath = "//div[@class='radio'][3]/label[2]/button")
    WebElement NoBtn;

    @FindBy(xpath = "//label[@class='switch switch--text switch--fullwidth']/button")
    WebElement OtherBtn;
    /*============================================================*/

    @FindBy(xpath = "//li[@class='wg-footer__social-item']/a[@href='https://twitter.com/wrike']")
    WebElement twitterBtn;

    /*-------------------------Methods-------------------------------------------------------*/

    public HomeWrikePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickGetStartedBtn() {
        if (getStartedBtn.isDisplayed() || getStartedBtn.isEnabled())
            getStartedBtn.click();
    }

    public String getHomePageHeader() {
        String[] line = homePageHeader.getText().split("\n");
        return line[0].trim();
    }
    /* ----------------------Start Free Trial methods----------------------------------------*/

    public void enterRandomEmail(String testEmail) {
        if (emailTextField.isDisplayed()) {
            emailTextField.clear();
            emailTextField.sendKeys(testEmail);
        }
    }

    public void clickCreateAccount() {
        if (createAccount.isDisplayed() || createAccount.isEnabled())
            createAccount.click();
    }

    public String getHeaderSFT() {
        return headerSFT.getText();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    /* ----------------------QASection methods---------------------------------------------*/

    public String getQASectionHeader() {
        return QASectionHeader.getText();
    }

    public void clickResendBtn() {
        if (resendButton.isEnabled() || resendButton.isDisplayed())
            resendButton.click();
    }

    public void clickRandomSection1() {
        firstSection.add(VeryInterestingBtn);
        firstSection.add(JustLookingBtn);
        WebElement random1 = randomArray.getRandomArrayBtn(firstSection);
        if (random1.isDisplayed() || random1.isEnabled())
            random1.click();
    }

    public void clickRandomSection2() {
        secondSection.add(Age1Btn);
        secondSection.add(Age6Btn);
        secondSection.add(Age16Btn);
        secondSection.add(Age26Btn);
        secondSection.add(Age50Btn);

        WebElement random2 = randomArray.getRandomArrayBtn(secondSection);
        if (random2.isDisplayed() || random2.isEnabled())
            random2.click();
    }

    public void clickRandomSection3() {
        thirdSection.add(YesBtn);
        thirdSection.add(NoBtn);
        thirdSection.add(OtherBtn);

        WebElement random3 = randomArray.getRandomArrayBtn(thirdSection);
        if (random3.isDisplayed() || random3.isEnabled())
            random3.click();
    }

    public void clickSubmitBtn() {
        if (submitResultsBtn.isEnabled() || submitResultsBtn.isDisplayed())
            submitResultsBtn.click();
    }

    public WebElement getResendButton() {
        return resendButton;
    }

    public void clickTwitterButton() {
        if (twitterBtn.isDisplayed() || twitterBtn.isEnabled())
            twitterBtn.click();
    }

    /*------------------------Getters for QA section buttons----------------------------------------------*/

    public WebElement getVeryInterestingBtn() {
        return VeryInterestingBtn;
    }
    public WebElement getJustLookingBtn() {
        return JustLookingBtn;
    }
    public WebElement getAge1Btn() {
        return Age1Btn;
    }
    public WebElement getAge6Btn() {
        return Age6Btn;
    }
    public WebElement getAge16Btn() {
        return Age16Btn;
    }
    public WebElement getAge26Btn() {
        return Age26Btn;
    }
    public WebElement getAge50Btn() {
        return Age50Btn;
    }
    public WebElement getYesBtn() {
        return  YesBtn;
    }
    public WebElement getNoBtn() {
        return NoBtn;
    }
    public WebElement getOtherBtn() {
        return OtherBtn;
    }
    public WebElement getSubmitResultsBtn() {
        return submitResultsBtn;
    }
}