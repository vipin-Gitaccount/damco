package tests;

import invoker.DriverInvoker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class AOL {
    WebDriver driver= DriverInvoker.getDriver();
    @Test(priority = 0)
    public void aolLogin(){
        driver= DriverInvoker.getDriver();
        driver.manage().window().maximize();
        driver.get("https://mail.aol.com");
        driver.findElement(By.xpath("//span[contains(text(),'Login')]")).click();
        driver.findElement(By.xpath("//input[@id='login-username']")).sendKeys("sehrawatvipin@aol.com");
        driver.findElement(By.xpath("//input[@id='login-signin']")).click();
        driver.findElement(By.xpath("//input[@id='login-passwd']")).sendKeys("AutomationTester");
        driver.findElement(By.xpath("//button[@id='login-signin']")).click();
        driver.findElement(By.xpath("//div//a[@aria-label='Compose']")).click();

    }

}
