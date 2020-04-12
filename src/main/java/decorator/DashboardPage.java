package decorator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DashboardPage {

    WebDriver driver;

    @FindBy(id = "role")
    private WebElement role;

    @FindBy(id = "div.guest")
    private List<WebElement> guestComponents;

    @FindBy(id = "div.superuser")
    private List<WebElement> superUserComponents;

    @FindBy(id = "div.admin")
    private List<WebElement> adminComponents;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goTo() {
        driver.get("https://vins-udemy.s3.amazonaws.com/ds/decorator.html");
    }

    public void selectRole(String role) {
        Select select = new Select(this.role);
        select.selectByValue(role);

    }

    public List<WebElement> getAdminComponents()
    {
        return adminComponents;
    }

    public List<WebElement> getGuestComponents()
    {
        return guestComponents;
    }
    public List<WebElement> getSuperUserComponents()
    {
        return superUserComponents;
    }


}
