package com.page;

import com.AbstractPage;
import com.objeRepo.MainPageObjeRepo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class MainPage extends AbstractPage {

    String testcase;

    public MainPage(WebDriver driver, WebDriverWait wait, String testCase) {
        AbstractPage.driver = driver;
        AbstractPage.wait = wait;
        testcase = testCase;
    }

    public MainPage controlLoggedOrNot() {
        control(isElementExist(MainPageObjeRepo.PageContent),testcase+": Page content exist",testcase+": Page content isn't exist");
        log.info(testcase+": Logged to Amazon");
        return this;
    }

    public MainPage clickCategoryPC() throws InterruptedException {
        click(MainPageObjeRepo.CategoryPC);
        log.info(testcase+": Clicked Category pc");
        return this;
    }

    public MainPage controlPcTex(String pcText) throws InterruptedException {
        String computerText = getTextOfElement(MainPageObjeRepo.PcText);
        compareText(computerText,pcText);
        log.info(testcase+": PC category selected");
        return this;
    }

    public MainPage typeWordInSearchbox(String msi) throws InterruptedException {
        sendKeys(MainPageObjeRepo.WordSearchBox,msi);
        log.info(testcase+": Typed" +msi+" in searchbox");
        return this;
    }

    public MainPage clickSearch() throws InterruptedException {
        click(MainPageObjeRepo.Searchbox);
        log.info(testcase+": Clicked Category pc");
        return this;
    }

    public MainPage controlSearchWord(String msi) throws InterruptedException {
        String msiText = getTextOfElement(MainPageObjeRepo.resultAfterSearch);
        compareText(msi,msiText);
        log.info(testcase+": "+msi+" is searched");
        return this;
    }

    public MainPage goToSecondPage() throws InterruptedException {
        scrollMainWindow(0,3500);
        log.info(testcase+": Scrolled main page down");
        click(MainPageObjeRepo.PageSecond);
        log.info(testcase+": Opened second page");
        return this;
    }

    public MainPage controlSecondPageOpened(String second) {
        String currentUrl = driver.getCurrentUrl();
        if(currentUrl.contains(second)){
            log.info(testcase+": Second page is opened");
        }else {
            log.info(testcase+": Second page is not opened");
            Assert.assertTrue(false);
        }
        return this;
    }

    public MainPage addSecondProductToBasket() throws InterruptedException {
        click(MainPageObjeRepo.SecondProduct);
        log.info(testcase + ": Clicked second product");
        click(MainPageObjeRepo.AddBasket);
        log.info(testcase+": Clicked add basket");
        return this;
    }

    public MainPage controlProductToBasket(String addedProduct) throws InterruptedException {
        String addBasketText = getTextOfElement(MainPageObjeRepo.AddBasketText);
        compareText(addedProduct,addBasketText);
        log.info(testcase+": "+addedProduct+" product is added to basket");
        return this;
    }

    public MainPage clickShoppingList() throws InterruptedException {
        click(MainPageObjeRepo.ShoppingList);
        log.info(testcase+": Clicked shopping list");
        return this;
    }

    public MainPage controlShoppingBasket(String shoppingBasket) throws InterruptedException {
        String ShoppingBasketText = getTextOfElement(MainPageObjeRepo.ShoppingBasketText);
        compareText(shoppingBasket,ShoppingBasketText);
        log.info(testcase+": "+shoppingBasket+" Shopping basket exist");
        return this;
    }

    public MainPage deleteAddedProduct() throws InterruptedException {
        if(isElementExist(MainPageObjeRepo.Delete,3)) {
            click(MainPageObjeRepo.Delete);
            log.info(testcase + ": Clicked delete and product deleted");
        }else if(isElementExist(MainPageObjeRepo.Delete2,3)){
            click(MainPageObjeRepo.Delete2);
            log.info(testcase + ": Clicked delete and product deleted");
        }
        return this;
    }

    public MainPage controlProductDeleted(String deletedMessage) throws InterruptedException {
        String RemovedMessageText = getTextOfElement(MainPageObjeRepo.RemovedMessage);
        compareText(deletedMessage,RemovedMessageText);
        log.info(testcase+": "+deletedMessage+" Product is not exist");
        return this;
    }

    public MainPage logoutFromAmazon() throws InterruptedException {
        hoverToElement(MainPageObjeRepo.Account);
        log.info(testcase+": Hovered to account");
        click(MainPageObjeRepo.LogoutAccount);
        log.info(testcase+": Clicked logout");
        return this;
    }

    public MainPage controlLogin(String login) throws InterruptedException {
        String LoginText = getTextOfElement(MainPageObjeRepo.Login);
        compareText(login,LoginText);
        log.info(testcase+": "+login+" page is exist");
        return this;
    }
}
