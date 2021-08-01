package StepDefs;

import PageObjects.SurveyPage;
import Utils.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class StepDefinitions {

    SurveyPage surveyPage;
    @Given("I am a person from Wales")
    public void i_am_a_person_from_wales() {
        surveyPage = new SurveyPage(Utils.driver);
      surveyPage.start_The_Survey();
      surveyPage.setCountry_wales();
    }
    @When("I put my circumstances into the Checker tool")
    public void i_put_my_circumstances_into_the_checker_tool() {
        surveyPage.next_Button();
        surveyPage.enterDateOfBirth();
        surveyPage.next_Button();
        surveyPage.select_yes_live_With_Partner();
        surveyPage.next_Button();
        surveyPage.select_yes_claim_Tax_Credits();
        surveyPage.next_Button();
        surveyPage.select_yes_universal_Credit();
        surveyPage.next_Button();
        surveyPage.select_yes_joint_Universal_Credit();
        surveyPage.next_Button();
        surveyPage.select_yes_take_Home_Pay();
        surveyPage.next_Button();

    }
    @Then("I should get a result of whether I will get help or not")
    public void i_should_get_a_result_of_whether_i_will_get_help_or_not() {
        String actual_help_text = surveyPage.verify_help_text();
        System.out.println(actual_help_text);
        Assert.assertEquals("Based on what you've told us\nYou get help with NHS costs", actual_help_text );

    }

}
