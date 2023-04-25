package co.com.certification.serenitydemo.stepsdefinitions;

import co.com.certification.serenitydemo.tasks.Browser;
import co.com.certification.serenitydemo.tasks.LogIn;
import co.com.certification.serenitydemo.tasks.LogInMap;
import co.com.certification.serenitydemo.utils.NavigateTo;
import co.com.certification.serenitydemo.models.CredentialsModel;
import co.com.certification.serenitydemo.models.datalists.GetCredentials;
import co.com.certification.serenitydemo.questions.ValidatesLoggedUser;
import co.com.certification.serenitydemo.questions.ValidatesWrongCredentials;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.hamcrest.CoreMatchers;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;

public class LoginStepsDefinitions {
    private final GetCredentials credentialModel = new GetCredentials();

    @Before
    public void startsPage() {
        setTheStage(new OnlineCast());
    }

    @Given("^(.*) opens the browser in the home page$")
    public void opensBrowserOnHomePage(String actor) {
        theActorCalled(actor).attemptsTo(new NavigateTo());
    }

    @When("^he enters his credentials, (.*) and (.*)$")
    public void entersTheCredentialsForLogin(String user, String pass) {
        theActorInTheSpotlight().attemptsTo(LogIn.forLoginIn(user, pass));
    }

    @Given("^he should see the (.*) in the login home page$")
    public void shouldSeeTheUserInTheLoginHomePage(String user) {
        theActorInTheSpotlight().should(seeThat(ValidatesLoggedUser.isDisplayed(), CoreMatchers.equalTo(user)));
    }

    @Then("^he should see the wrong credentials text message (.*)$")
    public void shouldSeeTheWrongCredentialsTextMessage(String text) {
        theActorInTheSpotlight().should(seeThat(ValidatesWrongCredentials.showedText(), CoreMatchers.equalTo(text)));
    }

    @Then("^he enters his credentials from a list map$")
    public void entersCredentialsFromListMap(DataTable dataTable) {
        CredentialsModel credentials = credentialModel.setCredentials(dataTable).get(0);
        theActorInTheSpotlight().attemptsTo(LogInMap.forLoginIn(credentials));
    }

    @And("he closes the browser")
    public void closesTheBrowser() {
        theActorInTheSpotlight().attemptsTo(Browser.close());
    }
}
