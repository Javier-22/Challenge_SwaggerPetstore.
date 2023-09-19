package co.com.tu.certification.stepdefinitions;

import co.com.tu.certification.models.PetData;
import co.com.tu.certification.tasks.AddPet;
import co.com.tu.certification.questions.ValidateName;
import co.com.tu.certification.tasks.SearchPet;
import co.com.tu.certification.tasks.UpdatePetData;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.hamcrest.Matchers;

import java.util.List;

import static co.com.tu.certification.utils.Constants.ACTOR_NAME;
import static co.com.tu.certification.utils.Constants.URL_PET_STORE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class PostPetStepDefinitions {

    @Given("^I want consume the services of pet store$")
    public void iWantConsumeTheServicesOfPetStore() {
        OnStage.theActorCalled(ACTOR_NAME).whoCan(CallAnApi.at(URL_PET_STORE));
    }

    @When("^add a new pet at store$")
    public void addANewPetAtStore(List<PetData> petData) {
        OnStage.theActorInTheSpotlight().attemptsTo(AddPet.atStore(petData.get(0)));
    }

    @When("^I consult the previously added pet by (.*)$")
    public void iConsultThePreviouslyAddedPet(String petId) {
        OnStage.theActorInTheSpotlight().attemptsTo(SearchPet.withId(petId));

    }

    @When("^I update the data of pet$")
    public void iUpdateTheDataOfPet(List<PetData> dataPut) {
        OnStage.theActorInTheSpotlight().attemptsTo(UpdatePetData.by(dataPut.get(0)));

    }

    @Then("^I consult the pet modified by name (.*)$")
    public void iConsultThePetModifiedByStatus(String name) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(ValidateName.name(), Matchers.equalTo(name)
                ));
    }


}
