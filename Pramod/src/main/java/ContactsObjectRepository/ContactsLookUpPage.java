package ContactsObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsLookUpPage {
@FindBy (xpath = "//img[@title='Create Contact...']")
private WebElement contactLookupIcon;

public ContactsLookUpPage(WebDriver driver)
{
	PageFactory.initElements(driver,this);
}

public WebElement getLookupIcon() {
	return contactLookupIcon;
}
public void clickOnConatctLookUp()
{
	contactLookupIcon.click();
}
}
