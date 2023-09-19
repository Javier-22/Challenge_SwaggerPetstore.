package co.com.tu.certification.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static co.com.tu.certification.utils.Constants.SEARCH_PET;

public class SearchPet implements Task {

    private String petId;

    public SearchPet(String petId) {
        this.petId = petId;
    }

    public static SearchPet withId(String petId) {
        return Tasks.instrumented(SearchPet.class, petId);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Get.resource(SEARCH_PET)
                .with(request -> request.contentType(ContentType.JSON).pathParam("id", petId)));
    }
}
