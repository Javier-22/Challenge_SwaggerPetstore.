package co.com.tu.certification.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidateName implements Question<String> {


    @Override
    public String answeredBy(Actor actor) {
        //Obtener propiedad nombre de la respuesta
        String name = SerenityRest.lastResponse().jsonPath().get("name").toString();
        System.out.println("Name: " + name);
        return name;
    }

    public static ValidateName name() {
        return new ValidateName();
    }
}
