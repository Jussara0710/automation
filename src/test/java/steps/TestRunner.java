package steps;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.platform.engine.Cucumber;

@CucumberOptions(
        features = "src/test/resources/features",   // Caminho para os arquivos .feature
        glue = "steps"                               // Caminho para as step definitions
)
@Cucumber
public class TestRunner {
}
