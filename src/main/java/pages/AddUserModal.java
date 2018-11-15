package pages;

import model.UserModel;
import org.testng.Assert;
import pagevar.AddUserModalVar;
import setup.WebdriverBot;


public class AddUserModal {

    public AddUserModal() {
        WebdriverBot.waitForElementVisible(AddUserModalVar.FIRST_NAME);
        WebdriverBot.waitForElementVisible(AddUserModalVar.LAST_NAME);
        WebdriverBot.waitForElementVisible(AddUserModalVar.USERNAME);
        WebdriverBot.waitForElementVisible(AddUserModalVar.PASSWORD);
        WebdriverBot.waitForElementVisible(AddUserModalVar.EMAIL);
        WebdriverBot.waitForElementVisible(AddUserModalVar.CELL_PHONE);
    }

    /**
     * Fill out the fields on the User Form
     * @param userModel
     */
    private void fillUserFields(UserModel userModel) {
        WebdriverBot.sendKeysWithClear(AddUserModalVar.FIRST_NAME, userModel.firstName);
        WebdriverBot.sendKeysWithClear(AddUserModalVar.LAST_NAME, userModel.lastName);
        WebdriverBot.sendKeysWithClear(AddUserModalVar.USERNAME, userModel.userName);
        WebdriverBot.sendKeysWithClear(AddUserModalVar.PASSWORD, userModel.password);
        //will select the value from the radio button
        switch (userModel.customer) {
            case CompanyA:
                WebdriverBot.clickElement(WebdriverBot.findElements(AddUserModalVar.CUSTOMER).get(0));
                break;

            case CompanyB:
                WebdriverBot.clickElement(WebdriverBot.findElements(AddUserModalVar.CUSTOMER).get(1));
                break;

            default:
                break;
        }

        //will select the value from the dropdown
        WebdriverBot.selectDropDownValueByVisibleText(AddUserModalVar.ROLE, userModel.role.toString());

        WebdriverBot.sendKeysWithClear(AddUserModalVar.EMAIL, userModel.email);
        WebdriverBot.sendKeysWithClear(AddUserModalVar.CELL_PHONE, userModel.cellphone);
    }

    /**
     * Create new users
     * @param userModel
     */
    public void createUser(UserModel userModel) {
        fillUserFields(userModel);
        clickSaveButton();
    }

    /**
     * Click Save Button on the Add User Modal
     */
    private void clickSaveButton(){
        WebdriverBot.clickElement(AddUserModalVar.SAVE_BUTTON);
        Assert.assertTrue(WebdriverBot.waitForElementInvisible(AddUserModalVar.SAVE_BUTTON),
                "There is an error saving the new user.");
    }



}
