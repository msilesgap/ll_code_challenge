package pagevar;

import org.openqa.selenium.By;

public class AddUserModalVar {

    public static final By FIRST_NAME = By.cssSelector("input[name='FirstName']");
    public static final By LAST_NAME = By.cssSelector("input[name='LastName']");
    public static final By USERNAME = By.cssSelector("input[name='UserName']");
    public static final By PASSWORD = By.cssSelector("input[name='Password']");
    public static final By CUSTOMER = By.cssSelector("input[name='optionsRadios']");
    public static final By ROLE = By.cssSelector("select[name='RoleId']");
    public static final By EMAIL = By.cssSelector("input[name='Email']");
    public static final By CELL_PHONE = By.cssSelector("input[name='Mobilephone']");
    public static final By SAVE_BUTTON = By.cssSelector(".btn.btn-success");
    public static final By CLOSE_BUTTON = By.cssSelector(".btn.btn-danger");

}
