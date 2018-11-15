package pages;

import org.testng.Assert;
import pagevar.DeleteConfirmationModalVar;
import setup.WebdriverBot;

public class DeleteConfirmationModal {

    public DeleteConfirmationModal() {
        WebdriverBot.waitForElementVisible(DeleteConfirmationModalVar.CANCEL_BUTTON);
        WebdriverBot.waitForElementVisible(DeleteConfirmationModalVar.OK_BUTTON);
    }

    /**
     * Click the Ok button on the Confirmation modal
     */
    public void clickOKButton(){
        WebdriverBot.clickElement(DeleteConfirmationModalVar.OK_BUTTON);
        Assert.assertTrue(WebdriverBot.waitForElementInvisible(DeleteConfirmationModalVar.OK_BUTTON),
                "There was a problem clicking the OK button.");
    }



}
