package TestUnoWithBDD;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Starter class permettant de démarrer la génération Cucumber et les différents tests
 * @author cognetj
 */
@RunWith(Cucumber.class)
@CucumberOptions(plugin={"html:target/cucumber-html","pretty:target/cucumber.txt"})
public class UnoCucumberTest {
    
}
