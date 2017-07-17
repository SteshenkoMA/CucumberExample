package test;

/**
 *
 * @author maxim
 */


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features={"."})
public class RunTest
{
  public RunTest() {}
}