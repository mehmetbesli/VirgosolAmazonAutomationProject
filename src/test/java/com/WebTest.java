package com;

import com.page.LoginPage;
import com.page.MainPage;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class WebTest extends AbstractPage {


    @BeforeTest
    public void BeforeTest() {
        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", path + "\\lib\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, 15);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

    }

    @Test
    public void Test() throws InterruptedException {
        String className = this.getClass().getSimpleName();
        String testCaseName = new Object() {}.getClass().getEnclosingMethod().getName();
        String testCase =className + "." + testCaseName;

        LoginPage loginPage=new LoginPage(driver,wait,testCase);
        MainPage mainPage=new MainPage(driver,wait,testCase);

        loginPage
                .navigateUrl(Data.Url)
                .controlMainPage()
                .acceptCookies()
                .clickLogin()
                .loginToAmazon(Data.Eposta,Data.Password);
        mainPage
                .controlLoggedOrNot()
                .clickCategoryPC()
                .controlPcTex(Data.PcText)
                .typeWordInSearchbox(Data.Msi)
                .clickSearch()
                .controlSearchWord(Data.Msi)
                .goToSecondPage()
                .controlSecondPageOpened("2")
                .addSecondProductToBasket()
                .controlProductToBasket(Data.AddedProduct)
                .clickShoppingList()
                .controlShoppingBasket(Data.ShoppingBasket)
                .deleteAddedProduct()
                .controlProductDeleted(Data.DeletedMessage)
                .logoutFromAmazon()
                .controlLogin(Data.Login);

    }

    @AfterTest
    public void AfterTest(){
        driver.quit();
    }

}
