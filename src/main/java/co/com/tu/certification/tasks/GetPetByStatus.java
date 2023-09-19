package co.com.tu.certification.tasks;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class GetPetByStatus implements Task {
    private String status;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource("/pet/findByStatus?status=available")
                        .with(request -> request
                                .header("Content-Type", "application/json")
                                .relaxedHTTPSValidation()
                                .log().all()
                        )
        );
        System.out.println("\nResponse result");
        SerenityRest.lastResponse().prettyPrint();
    }

    public static GetPetByStatus getPetByStatus(String status) {
        return Tasks.instrumented(GetPetByStatus.class, status);
    }
}