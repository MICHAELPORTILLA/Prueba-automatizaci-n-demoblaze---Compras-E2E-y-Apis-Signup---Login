package com.tcs.qa.pages;

//Infraestructura del framework
import com.itextpdf.text.DocumentException;
import com.tcs.qa.config.DriverManager;
import com.tcs.qa.base.BasePage;

//Selenium:localizadores y elementos
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//Selenium: esperas explícitas
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

//Java
import java.io.IOException;
import java.time.Duration;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import com.tcs.qa.base.BasePage;

public class StorePage extends BasePage{
    //Localizadores de Store Page
    private final By homeButton = By.cssSelector("li[class='nav-item active'] a[class='nav-link']"); // Botón Home del menú superior
    private final By cartButton = By.xpath("(//a[normalize-space()='Cart'])[1]"); // Botón Cart del menú superior
    private final By phonesButton = By.xpath("(//a[normalize-space()='Phones'])[1]"); // Botón Phones del menú categories
    private final By laptopsButton = By.xpath("(//a[normalize-space()='Laptops'])[1]"); // Botón laptops del menú categories
    private final By productOneButton = By.xpath("(//a[normalize-space()='HTC One M9'])[1]");
    private final By productTwoButton = By.xpath("(//a[normalize-space()='Sony vaio i7'])[1]");

    // Localizadores de cradpage
    private final By addCartButton = By.cssSelector(".btn.btn-success.btn-lg");
    private final By placeOrderButton = By.xpath("(//button[normalize-space()='Place Order'])[1]"); //Botón place order para realizar orden
    private final By nameInput = By.xpath("(//input[@id='name'])[1]");
    private final By countryInput = By.xpath("//input[@id='country']");
    private final By cityInput = By.xpath("(//input[@id='city'])[1]");
    private final By creditCardInput = By.xpath("(//input[@id='card'])[1]");
    private final By montInput = By.xpath("(//input[@id='month'])[1]");
    private final By yearInput = By.xpath("(//input[@id='year'])[1]");
    private final By purchaseButton = By.xpath("(//button[normalize-space()='Purchase'])[1]");
    private final By okButton = By.xpath("(//button[normalize-space()='OK'])[1]");

    public void E2E(String name, String country, String city, String creditCard, String mont, String year){
        clic(productOneButton,"Selecciona el primer producto a comprar");
        clic(addCartButton,"Hacer clic en el botón Add to card");
        alertAceptar("Cierra alert cuando se agrega producto al carrito");
        clic(homeButton, "Hacer clic en el botón Home del menú superior");
        clic(laptopsButton, "Selecciona laptop en el menú del catalogo");
        clic(productTwoButton, "Selecciona el segundo producto a comprar");
        clic(addCartButton,"Hacer clic en el botón Add to card");
        alertAceptar("Cierra alert cuando se agrega producto al carrito");
        clic(cartButton, "Hacer clic en el botón Cart del menú superior");
        clic(placeOrderButton, "Hacer clic en el botón Place order");
        inputText(name, nameInput, "Ingresa el nombre del comprador");
        inputText(country, countryInput, "Ingresa el país");
        inputText(city, cityInput, "Ingresa la ciudad");
        inputText(creditCard, creditCardInput, "Ingresa número de tarjeta de crédito");
        inputText(mont, montInput, "Ingresa el mes de caducidad de la tarjeta de crédito");
        inputText(year, yearInput , "Ingresa el año de caducidad de la tarjeta de crédito");
        clic(purchaseButton,"Hacer clic en el botón Purchase para confirmar la compra ");
        waitingtime(2);
        clic(okButton,"Hacer clic para confirmar datos de la compra, retorna a Home de la pagina ");
        waitingtime(2);
    }
}
