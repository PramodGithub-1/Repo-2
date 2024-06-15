package ContactsObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage{
@FindBy (name = "lastname")
private WebElement lastnameEdt;

@FindBy (xpath = "(//input[@title='Save [Alt+S]'])[2]")
private WebElement saveBtn;

public ContactsPage(WebDriver driver)
{
	PageFactory.initElements(driver,this);
}

public WebElement getLastnameEdt() {
	return lastnameEdt;
}

public WebElement getSaveBtn() {
	return saveBtn;
}

public void saveContact(String LASTNAME)
{
	lastnameEdt.sendKeys(LASTNAME);
	saveBtn.click();
}
}
