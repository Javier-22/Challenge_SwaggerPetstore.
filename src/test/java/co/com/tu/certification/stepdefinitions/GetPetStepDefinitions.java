package co.com.tu.certification.stepdefinitions;

import co.com.tu.certification.questions.ValidateStatus;
import co.com.tu.certification.tasks.GetPetByStatus;
import co.com.tu.certification.utils.Constants;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.questions.ResponseConsequence;
import org.hamcrest.Matchers;

import static co.com.tu.certification.utils.Constants.ACTOR_NAME;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class GetPetStepDefinitions {

    @Before
    public void setUp() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled(ACTOR_NAME);
    }

    @Given("^I consume the petstore API$")
    public void iConsumeThePetstoreAPI() {
        theActorInTheSpotlight().whoCan(CallAnApi.at(Constants.BASE_ENDPOINT_PET));
    }


    @When("^I get pet by status \"([^\"]*)\"$")
    public void iGetPetByStatus(String status) {
        theActorInTheSpotlight().attemptsTo(GetPetByStatus.getPetByStatus(status));
    }


    @Then("^I validate status \"([^\"]*)\" in response$")
    public void iValidateStatusInResponse(String status) {
        theActorInTheSpotlight().should(
                seeThat(ValidateStatus.status(), Matchers.equalTo(status))
        );
    }


}
