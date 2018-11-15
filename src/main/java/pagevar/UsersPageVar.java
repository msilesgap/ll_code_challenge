package pagevar;

import org.openqa.selenium.By;

public class UsersPageVar {

    public static final By ADD_BUTTON = By.cssSelector(".icon.icon-plus");
    public static final By DELETE_ICON = By.cssSelector("td .icon.icon-remove");
    public static final By SEARCH_INPUT = By.cssSelector(".smart-table-global-search input");

    public static final By FIRST_NAME_COLUMN = By.cssSelector(".smart-table tbody td:nth-child(1)");
    public static final By LAST_NAME_COLUMN = By.cssSelector(".smart-table tbody td:nth-child(2)");
    public static final By USER_NAME_COLUMN = By.cssSelector(".smart-table tbody td:nth-child(3)");
    public static final By CUSTOMER_COLUMN = By.cssSelector(".smart-table tbody td:nth-child(5)");
    public static final By ROLE_COLUMN = By.cssSelector(".smart-table tbody td:nth-child(6)");
    public static final By EMAIL_COLUMN = By.cssSelector(".smart-table tbody td:nth-child(7)");
    public static final By CELLPHONE_COLUMN = By.cssSelector(".smart-table tbody td:nth-child(8)");
}
