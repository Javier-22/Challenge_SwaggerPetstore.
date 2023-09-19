package co.com.tu.certification.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
            features = "src/test/resources/features/post_pet.feature",
            glue = "co.com.tu.certification.stepdefinitions",
            snippets = SnippetType.CAMELCASE
)
public class PostPetRunner {
}
