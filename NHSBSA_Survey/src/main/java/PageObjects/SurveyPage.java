package PageObjects;

import Utils.Utils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SurveyPage {
    WebDriver driver;

     @FindBy(how = How.CSS,using = "input[id='next-button']")
    WebElement start_Next;

     @FindBy(how=How.CSS,using="label[id='label-wales']")
    WebElement country_wales;

    @FindBy(how=How.CSS,using="input[id='dob-day']")
    WebElement day;

    @FindBy(how=How.CSS,using="input[id='dob-month']")
    WebElement month;

    @FindBy(how=How.CSS,using="input[id='dob-year']")
    WebElement year;

    @FindBy(how = How.CSS,using="label[id='label-yes']")
    WebElement yes_Button;

    @FindBy(how = How.CSS,using="input[id='yes-universal']")
    WebElement universal_Credit;

    @FindBy(how = How.CSS,using="label[id='label-no']")
    WebElement no_Button;

    @FindBy(how = How.CSS,using="div[class='done-panel'] h2")
    WebElement help_text;

    public void start_The_Survey(){ click_Start();}


    public void click_Start(){
        start_Next.click();
    }

    public void next_Button(){ click_Start();}

    public void setCountry_wales() {
        country_wales.click();
    }

    public void enterDateOfBirth(){
        day.sendKeys("22");
        month.sendKeys("12");
        year.sendKeys("1985");
    }

    public void setNo_Button() {
        no_Button.click();
    }

    public void setYes_Button() {
        yes_Button.click();
    }
    public void select_yes_live_With_Partner(){ setYes_Button();}

    public void select_yes_claim_Tax_Credits(){ setYes_Button();}

    public void select_yes_joint_Universal_Credit(){ setYes_Button();}

    public void select_yes_take_Home_Pay(){ setYes_Button();}

    public void select_yes_universal_Credit(){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", universal_Credit);
    }

    public String verify_help_text(){
        return help_text.getText();
    }

    public SurveyPage(WebDriver driver){
        this.driver=Utils.driver;
        PageFactory.initElements(driver,this);
    }
}
