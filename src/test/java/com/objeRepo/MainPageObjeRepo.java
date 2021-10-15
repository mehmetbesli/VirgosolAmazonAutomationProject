package com.objeRepo;

import org.openqa.selenium.By;

public class MainPageObjeRepo {
    public static final By PageContent = By.id("pageContent");
    public static final By CategoryPC = By.xpath("//div[@id='nav-xshop']/a[7]");
    public static final By PcText = By.cssSelector("div[class='fst-h1-st pageBanner'] h1");
    public static final By WordSearchBox = By.id("twotabsearchtextbox");
    public static final By Searchbox = By.id("nav-search-submit-button");
    public static final By resultAfterSearch = By.cssSelector("div[class='a-section a-spacing-small a-spacing-top-small']");
    public static final By PageSecond = By.xpath("//ul[@class='a-pagination']//li[3]");
    public static final By SecondProduct = By.xpath("(//div[@data-component-type='s-search-result'])[2]//img");
    public static final By AddBasket = By.id("add-to-cart-button");
    public static final By AddBasketText = By.id("huc-v2-order-row-messages");
    public static final By ShoppingList = By.id("nav-cart");
    public static final By ShoppingBasketText = By.xpath("//div[@class='a-row sc-cart-header sc-compact-bottom']//div[1]");
    public static final By Delete = By.cssSelector("span[class='a-size-small sc-action-delete'] input");
    public static final By Delete2 = By.xpath("(//span[@class='a-size-small sc-action-delete'])[1]//input");
    public static final By RemovedMessage = By.cssSelector("div[class='sc-list-item-removed-msg']");
    public static final By Account = By.cssSelector("div[id='nav-tools'] a");
    public static final By LogoutAccount = By.cssSelector("a[id='nav-item-signout'] span");
    public static final By Login = By.cssSelector("div[class='a-box-inner a-padding-extra-large'] h1");



}
