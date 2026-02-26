package com.tcs.qa.base;

import com.epam.healenium.SelfHealingDriver;
import com.itextpdf.text.DocumentException;
import com.sun.jdi.InternalException;
import com.tcs.qa.config.DriverManager;
import com.tcs.qa.config.ConfigReader;

import com.tcs.qa.pages.StorePage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;

public class BasePage {

    private static Logger log = Logger.getLogger(StorePage.class.getName());
    public static WebDriver driver;
    public static WebDriverWait wait;
    static String _rutaCarpeta = "./evidenciasTest";

    public BasePage() {
        this.driver = DriverManager.getDriver();
        int timeout = Integer.parseInt(ConfigReader.getProperty("timeout.explicit"));
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
    }

    public static void printConsole (String message) {
        System.out.println(message);
    }

    public void clic(By locator, String steps){
        try {
            captureScreen(steps);
            wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
            log.info("Se realiza acción de clic soblre el elemento: " + locator + " - " + steps);
        }catch (Exception e){
            log.warning("Error al hacer clic en el elemento: " + e.getMessage());
            printConsole(e.toString());
            throw new InternalError();
        }
    }

    public void alertAceptar(String steps){
        try{
            wait.until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert().accept();
            log.info("Se acepta la alerta correctamente");
        } catch (NoAlertPresentException var1){
            log.warning("No hay alerta presentee continuando... ");
        } catch (UnhandledAlertException var2){
            log.warning("Alerta inesperada encontrada, se intenta aceptar ");
            try{
                driver.switchTo().alert().accept();
                log.info("Se acepta la alerta correctamente");
            }catch (Exception var3){
                log.warning("ERROR: "+ var3.toString());
            }
        }
    }

    public void inputText(String text, By locator, String steps){
        try{
            WebElement nameInputElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            nameInputElement.clear();
            nameInputElement.sendKeys(text);
            captureScreen(steps);
            log.info("Se realiza ingreso del texto: {} " + locator);
        }catch (Exception e){
            log.warning("No fue posible encontar el elemento" + locator + " - " + e.getMessage());
            printConsole("Error al enviar la información: " + e.toString());
            throw new InternalException();
        }
    }

    public void waitingtime (long time){
        try {
            Thread.sleep(time * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static String tiempoSistema(String formatter) {
        LocalDateTime fechaSistema = LocalDateTime.now();
        DateTimeFormatter fecha = DateTimeFormatter.ofPattern(formatter);
        String formatFecha = fecha.format(fechaSistema);
        return formatFecha;
    }

    public static void captureScreen(String steps) throws IOException, DocumentException {
        String hora = tiempoSistema("HH-mm-ss");
        WebDriver delegatedDriver;
        if (driver instanceof SelfHealingDriver) {
            delegatedDriver = ((SelfHealingDriver)driver).getDelegate();
        } else {
            delegatedDriver = driver;
        }
        File srcFile = (File)((TakesScreenshot)delegatedDriver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(_rutaCarpeta + "\\" + hora + ".png"));
        String rutaImagen = (new File(_rutaCarpeta + "\\" + hora + ".png")).toString();
        log.info("Se realiza captura de imagen en la ruta: {}" + rutaImagen);
    }
}