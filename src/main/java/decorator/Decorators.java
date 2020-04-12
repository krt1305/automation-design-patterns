package decorator;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.function.Consumer;

public class Decorators {

    private static void shouldDisplay(List<WebElement> elements) {
        elements.forEach(element -> Assert.assertTrue(element.isDisplayed()));
    }

    private static void shouldNotDisplay(List<WebElement> elements) {
        elements.forEach(element -> Assert.assertFalse(element.isDisplayed()));
    }

    private static final Consumer<DashboardPage> adminComponentPresent = (dp) -> shouldDisplay(dp.getAdminComponents());
    private static final Consumer<DashboardPage> adminComponentNotPresent = (dp) -> shouldNotDisplay(dp.getAdminComponents());
    private static final Consumer<DashboardPage> guestComponentPresent = (dp) -> shouldDisplay(dp.getGuestComponents());
    private static final Consumer<DashboardPage> guestComponentNotPresent = (dp) -> shouldNotDisplay(dp.getGuestComponents());
    private static final Consumer<DashboardPage> superUserComponentPresent = (dp) -> shouldDisplay(dp.getSuperUserComponents());
    private static final Consumer<DashboardPage> superUserComponentNotPresent = (dp) -> shouldNotDisplay(dp.getSuperUserComponents());


    //role selection
    private static final Consumer<DashboardPage> adminSelection=(dp)->dp.selectRole("admin");
    private static final Consumer<DashboardPage> guestSelection=(dp)->dp.selectRole("superuser");
    private static final Consumer<DashboardPage> superUserSelection=(dp)->dp.selectRole("guest");

    //user role pages
    public static final Consumer<DashboardPage> guestPage=guestSelection.andThen(superUserComponentNotPresent).andThen(adminComponentNotPresent);
    public static final Consumer<DashboardPage> superUserPage=superUserSelection.andThen(guestComponentPresent).andThen(superUserComponentPresent).andThen(adminComponentNotPresent);
    public static final Consumer<DashboardPage> adminPage=adminSelection.andThen(adminComponentPresent).andThen(guestComponentPresent).andThen(superUserComponentPresent);

}
