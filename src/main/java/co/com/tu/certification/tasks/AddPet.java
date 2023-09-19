package co.com.tu.certification.tasks;


import co.com.tu.certification.models.PetData;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;


import static co.com.tu.certification.utils.Constants.ADD_PET;


public class AddPet implements Task {

    private PetData petData;

    public AddPet(PetData petData) {
        this.petData = petData;
    }

    public static AddPet atStore(PetData petData) {
        return Tasks.instrumented(AddPet.class, petData);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Post.to(ADD_PET)
                .with(request -> request
                        .contentType(ContentType.JSON)
                        .body(petData.toString())));

    }
}