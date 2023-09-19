package co.com.tu.certification.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidateStatus implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        //Obtener propiedad status del primer objeto del arreglo
        String status = SerenityRest.lastResponse().jsonPath().get("status[0]").toString();
        System.out.println("Status: " + status);
        return status;

    }

    public static ValidateStatus status() {
        return new ValidateStatus();
    }
}
