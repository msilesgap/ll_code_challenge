package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pagevar.UsersPageVar;
import setup.WebdriverBot;

import java.util.List;

public class UsersPage extends PageBase {

    public UsersPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Click the Add User button
     * @return
     */
    public AddUserModal clickAddUser(){
        WebdriverBot.waitForElementVisible(UsersPageVar.ADD_BUTTON);
        WebdriverBot.clickElement(UsersPageVar.ADD_BUTTON);
        return new AddUserModal();
    }

    /**
     * Delete users by username
     * @param name
     */
    public void deleteUserByName(String name){
        List<WebElement> usernames = WebdriverBot.findElements(UsersPageVar.USER_NAME_COLUMN);
        for(WebElement element : usernames){
            if(element.getText().equals(name)) {
                WebElement fullRow = WebdriverBot.getParentElement(element);
                WebElement delete = fullRow.findElement(UsersPageVar.DELETE_ICON);
                DeleteConfirmationModal deleteConfirmationModal = clickDeleteButton(delete);
                deleteConfirmationModal.clickOKButton();
                break;
            }
        }
    }

    /**
     * Will click the delete icon of the desired user
     * @param delete
     * @return the confirmation modal
     */
    public DeleteConfirmationModal clickDeleteButton(WebElement delete){
        WebdriverBot.clickElement(delete);
        return new DeleteConfirmationModal();
    }

    /**
     * Will check if the user exist
     * @param userName
     * @return
     */
    public boolean doesUserExist(String userName) {
        List<WebElement> usernames = WebdriverBot.findElements(UsersPageVar.USER_NAME_COLUMN);
        for(WebElement element : usernames){
            if(element.getText().equals(userName))
                return true;
        }
        return false;
    }

    /**
     * Execute a search using the search criteria
     * @param searchCriteria
     * @return
     */
    public boolean executeSearch(String searchCriteria){
        WebdriverBot.sendKeysWithClear(UsersPageVar.SEARCH_INPUT, searchCriteria);
        List<WebElement> usernames = WebdriverBot.findElements(UsersPageVar.USER_NAME_COLUMN);
        if(usernames.isEmpty())
            return false;
        else
            return true;
    }
}
