package test.stepsdefs;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.io.PrintStream;
import test.Actions;
import test.DriverManager;

public class StepsDefs
{
  Actions elements;
  
  public StepsDefs()
  {
    elements = new Actions();
  }
  
  @Before
  public void setup() {
    new DriverManager().openBrowser();
  }
  
  @Given("^Open google page$")
  public void open_google_page() throws Throwable {
    elements.isGooglePageOpened();
    System.out.println("1. Google page was opened");
  }
  
  @When("^Search for this \"([^\"]*)\"$")
  public void search_text(String searchString) throws Throwable {
    elements.searchText(searchString);
    System.out.println("2. Text: " + searchString + " was searced");
  }
  
  @Then("^See results page$")
  public void i_found_results() throws Throwable {
    elements.isResultsFound();
    System.out.println("3. Results page was opened");
  }
  
  @When("^Open first link$")
  public void open_first_link() throws Throwable {
    elements.isLinkOpened();
    System.out.println("4. First link was opened");
  }
  
  @Then("^Open repositories$")
  public void open_repositories() throws Throwable {
    elements.isRepositorioesOpened();
    System.out.println("5. Repositories link was opened");
  }
  
  @When("^Open final page \"([^\"]*)\"$")
  public void open_finalPage(String title) throws Throwable {
    elements.isFinalPageOpened(title);
    System.out.println("6. Final page was opened");
  }
  
  @Then("^Download the picture$")
  public void download_picture() throws Throwable {
    elements.isPictureDownloaded();
    System.out.println("7. The picture was downloaded");
  }
  
  @Then("^Delete the picture$")
  public void delete_picture() throws Throwable {
    elements.isPictureDeleted();
    System.out.println("8. The picture was deleted");
  }
  
  @After
  public void after() {
    new DriverManager().closeBrowser();
  }
}