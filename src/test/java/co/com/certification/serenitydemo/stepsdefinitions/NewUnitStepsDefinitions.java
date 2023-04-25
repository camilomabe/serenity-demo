package co.com.certification.serenitydemo.stepsdefinitions;

import co.com.certification.serenitydemo.tasks.CreatesNewBusinessUnit;
import co.com.certification.serenitydemo.utils.SessionVariables;
import co.com.certification.serenitydemo.interactions.DeleteBusinessUnit;
import co.com.certification.serenitydemo.questions.ValidatesBusinessUnit;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.CoreMatchers;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class NewUnitStepsDefinitions {
    @Given("^he creates new business unit as (.*)$")
    public void createNewBusinessUnit(String businessUnit) {
        theActorInTheSpotlight().attemptsTo(CreatesNewBusinessUnit.letsGo(businessUnit));
    }

    @When("^he should see the business unit name was created$")
    public void shouldSeeTheBusinessUnitNameWasCreated() {
        theActorInTheSpotlight().should(seeThat(ValidatesBusinessUnit.wasCreate(),
                CoreMatchers.equalTo(theActorInTheSpotlight().recall(SessionVariables.BUSINESS_UNIT_NAME.toString()))));
    }

    @Then("^he should delete business unit$")
    public void shouldDeleteBusinessUni() {
        theActorInTheSpotlight().attemptsTo(DeleteBusinessUnit.letsGo());
    }

}
