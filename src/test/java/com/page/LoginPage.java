package com.page;

import com.AbstractPage;
import com.objeRepo.LoginObjeRepo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage extends AbstractPage {

    String testcase;

    public LoginPage(WebDriver driver, WebDriverWait wait, String testCase) {
        AbstractPage.driver = driver;
        AbstractPage.wait = wait;
        testcase = testCase;
    }


    public LoginPage navigateUrl(String url) {
        goToUrl(url);
        log.info(testcase+": "+url+" opened");
        return this;
    }

    public LoginPage controlMainPage() {
        control(isElementExist(LoginObjeRepo.AmazonLogo),testcase+": Amazon logo exist",testcase+": Amazon logo isn't exist");
        log.info(testcase+": Main page exist");
        return this;
    }

    public LoginPage acceptCookies() throws InterruptedException {
        if(isElementExist(LoginObjeRepo.AcceptCookies,3)) {
            click(LoginObjeRepo.AcceptCookies);
            log.info(testcase + ": Clicked accept cookies");
        }
        return this;
    }

    public LoginPage clickLogin() throws InterruptedException {
        hoverToElement(LoginObjeRepo.Account);
        log.info(testcase+": Hovered account");
        click(LoginObjeRepo.Login);
        log.info(testcase+": Clicked Login");
        return this;
    }

    public LoginPage loginToAmazon(String eposta, String password) throws InterruptedException {
        sendKeys(LoginObjeRepo.Eposta,eposta);
        log.info(testcase+": Typed eposta");
        click(LoginObjeRepo.Continue);
        log.info(testcase+": Clicked continue");
        sendKeys(LoginObjeRepo.Password,password);
        log.info(testcase+": Typed password");
        click(LoginObjeRepo.LoginBtn);
        log.info(testcase+": Clicked login");
        return this;
    }


}
