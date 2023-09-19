package co.com.tu.certification.tasks;

import co.com.tu.certification.models.PetData;
import co.com.tu.certification.utils.Constants;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Put;

public class UpdatePetData implements Task {

    private PetData putData;

    public UpdatePetData(PetData putData) {
        this.putData = putData;
    }

    public static UpdatePetData by(PetData putData) {
        return Tasks.instrumented(UpdatePetData.class, putData);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Put.to(Constants.ADD_PET)
                .with(requets -> requets
                        .contentType(ContentType.JSON)
                        .body(putData.toString())));
        SerenityRest.lastResponse().prettyPrint();
    }
}