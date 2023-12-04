package org.example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;


public class Main {



    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\jakub\\Downloads\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://ais2.ukf.sk/ais/start.do");
        try {
            Thread.sleep(3000);
            WebElement cookiesButton = driver.findElement(By.xpath("/html/body/div[6]/button[1]"));
            cookiesButton.click();
            WebElement pouz = driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div/div[1]/div[1]/form/div/div/div/table/tbody/tr[1]/td[2]/input"));
            pouz.sendKeys("175311");
            WebElement heslo = driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div/div[1]/div[1]/form/div/div/div/table/tbody/tr[2]/td[2]/input"));
            heslo.sendKeys("MOJE-HESLO");
            heslo.submit();
            Thread.sleep(3000);
            WebElement rozvrh = driver.findElement(By.xpath("//*[@id=\"col3\"]/app-body/div[1]/div/app-rozvrh/div/div/div"));
            rozvrh.click();
            Thread.sleep(3000);
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File("rozvrh.png"));
            WebElement odhlas1 = driver.findElement(By.xpath("/html/body/app-root/lib-app-header/nav/div[3]"));
            odhlas1.click();
            WebElement odhlas2 = driver.findElement(By.xpath("/html/body/app-root/lib-app-header/nav/div[3]/div/a"));
            odhlas2.click();
            Thread.sleep(3000);
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}