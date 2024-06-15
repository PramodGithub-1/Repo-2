package ContactsObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactValidation {
@FindBy (className = "dvHeaderText")
private WebElement contactHeader;

public ContactValidation(WebDriver driver)
{
	PageFactory.initElements(driver,this);
}

public WebElement getContactHeader() {
	return contactHeader;
}
public String validateContact() throws Throwable{
	return contactHeader.getText();
	
}
}
