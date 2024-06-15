package com.mycompany.mavenproject1;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;

public class TestMavinIT_Organized {

    @BeforeSuite
    public static void setUpClass() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize(); //to maximize browser window
    }

    @AfterSuite
    public static void tearDownClass() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }

    static WebDriver driver;

    @Test(testName = "AccountTest")
    public void testLogin() throws Exception {

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(5000);
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.className("orangehrm-login-button")).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.className("oxd-userdropdown-name")).getText(), "Paul Collings");

    }
   

    @AfterMethod()
    public void screenShot(ITestResult result) {
        //using ITestResult.FAILURE is equals to result.getStatus then it enter into if condition
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                // To create reference of TakesScreenshot
                TakesScreenshot screenshot = (TakesScreenshot) driver;
                // Call method to capture screenshot
                File src = screenshot.getScreenshotAs(OutputType.FILE);
                // Copy files to specific location 
                // result.getName() will return name of test case so that screenshot name will be same as test case name
                FileUtils.copyFile(src, new File("E:\\" + result.getName() + ".png"));
                System.out.println("Successfully captured a screenshot");
            } catch (IOException | WebDriverException e) {
                System.out.println("Exception while taking screenshot " + e.getMessage());
            }
        }
   }
    //testing the side par pop up menu
    @Test(testName = "SideBarLinks")
    public void testPopUpMenu() throws Exception {
        driver.findElement(By.className("bi-chevron-left")).click();
        Thread.sleep(2000);
        driver.findElement(By.className("bi-chevron-right")).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.className("bi-chevron-left")).isEnabled(), true);
    }

    @Test(testName = "SideBarLinks")
    public void testTabAdmin() throws Exception {
        driver.findElement(By.cssSelector(".oxd-main-menu-item[href='/web/index.php/admin/viewAdminModule']")).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.className("oxd-topbar-header-breadcrumb-level")).getText(), "User Management");

    }

    @Test(testName = "SideBarLinks")
    public void testTabPIM() throws Exception {
        driver.findElement(By.cssSelector(".oxd-main-menu-item[href='/web/index.php/pim/viewPimModule']")).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.className("oxd-topbar-header-breadcrumb-level")).getText(), "PIM");

    }

    @Test(testName = "SideBarLinks")
    public void testTabLeave() throws Exception {
        driver.findElement(By.cssSelector(".oxd-main-menu-item[href='/web/index.php/leave/viewLeaveModule']")).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.className("oxd-topbar-header-breadcrumb-level")).getText(), "Leave");

    }

    @Test(testName = "SideBarLinks")
    public void testTabTime() throws Exception {
        driver.findElement(By.cssSelector(".oxd-main-menu-item[href='/web/index.php/time/viewTimeModule']")).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.className("oxd-topbar-header-breadcrumb-level")).getText(), "Timesheets");
    }

    @Test(testName = "SideBarLinks")
    public void testTabRecuriment() throws Exception {
        driver.findElement(By.cssSelector(".oxd-main-menu-item[href='/web/index.php/recruitment/viewRecruitmentModule']")).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.className("oxd-topbar-header-breadcrumb-level")).getText(), "Recruitment");

    }

    @Test(testName = "SideBarLinks")
    public void testTabMyInfo() throws Exception {
        driver.findElement(By.cssSelector(".oxd-main-menu-item[href='/web/index.php/pim/viewMyDetails']")).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.className("orangehrm-main-title")).getText(), "Personal Details");

    }

    @Test(testName = "SideBarLinks")
    public void testTabPerformance() throws Exception {
        driver.findElement(By.cssSelector(".oxd-main-menu-item[href='/web/index.php/performance/viewPerformanceModule']")).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.className("oxd-topbar-header-breadcrumb-level")).getText(), "Manage Reviews");

    }

    @Test(testName = "SideBarLinks")
    public void testTabDashbord() throws Exception {
        driver.findElement(By.cssSelector(".oxd-main-menu-item[href='/web/index.php/dashboard/index']")).click();
        Thread.sleep(2000);
        //Assert.assertTrue(driver.findElement(By.className("oxd-userdropdown-name")).isDisplayed());
        Assert.assertEquals(driver.findElement(By.className("oxd-topbar-header-breadcrumb-level")).getText(), "Dashboard");

    }

    @Test(testName = "SideBarLinks")
    public void testTabDirectory() throws Exception {
        driver.findElement(By.cssSelector(".oxd-main-menu-item[href='/web/index.php/directory/viewDirectory']")).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.className("oxd-topbar-header-breadcrumb-level")).getText(), "Directory");

    }

    @Test(testName = "SideBarLinks")
    public void testTabMintance() throws Exception {
        driver.findElement(By.cssSelector(".oxd-main-menu-item[href='/web/index.php/maintenance/viewMaintenanceModule']")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.className("orangehrm-admin-access-button")).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.className("oxd-topbar-header-breadcrumb-level")).getText(), "Purge Records");
    }

    @Test(testName = "SideBarLinks")
    public void testTabBuzz() throws Exception {
        driver.findElement(By.cssSelector(".oxd-main-menu-item[href='/web/index.php/buzz/viewBuzz']")).click();
        Thread.sleep(2000);
        //Assert.assertTrue(driver.findElement(By.className("oxd-userdropdown-name")).isDisplayed());
        Assert.assertEquals(driver.findElement(By.className("oxd-topbar-header-breadcrumb-level")).getText(), "Buzz");
    }

    @Test(testName = "AdminFunctonality")
    public void testAdminSearch() throws Exception {
        driver.findElement(By.cssSelector(".oxd-main-menu-item[href='/web/index.php/admin/viewAdminModule']")).click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.findElement(By.className("oxd-topbar-header-breadcrumb-level")).getText(), "User Management");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input")).sendKeys("Admin");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]")).click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/span")).getText(), "(1) Record Found");
    }

    @Test(testName = "AdminFunctonality")
    public void testAdminReset() throws Exception {
        Thread.sleep(2000);
        //testing the reset button
        driver.findElement(By.className("oxd-button--ghost")).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input")).getText(), "");
    }

    @Test(testName = "AdminFunctonality")
    public void testTabAdminAdd() throws Exception {
        //testing the Delete button
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//div[@role='listbox']//child::div)[3]")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div/input")).sendKeys("Cecil  Bonaparte");
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//div[@role='listbox']//child::div)[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div")).click();
        driver.findElement(By.xpath("(//div[@role='listbox']//child::div)[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input")).sendKeys("aaaaa");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input")).sendKeys("Admin123");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input")).sendKeys("Admin123");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]")).click();
        Thread.sleep(10000);

    }

    @Test(testName = "AdminFunctonality")
    public void testTabESSsearch() throws Exception {
        driver.findElement(By.cssSelector(".oxd-main-menu-item[href='/web/index.php/admin/viewAdminModule']")).click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.findElement(By.className("oxd-topbar-header-breadcrumb-level")).getText(), "User Management");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input")).sendKeys("aaaaa");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]")).click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/span")).getText(), "(1) Record Found");
        
    }
    @Test(testName = "AdminFunctonality")
    public void testTabESSEdit() throws Exception {
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[1]/div/div[6]/div/button[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/button[1]")).click();
        Thread.sleep(2000);
    }

    @Test(testName = "AdminFunctonality")
    public void testTabAdminOrganizaton() throws Exception {
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[3]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[3]/ul/li[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div/label/span")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/input")).sendKeys("aaaaa");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[7]/button")).click();
        Thread.sleep(5000);
    }

     @Test(testName = "AdminFunctonality")
    public void testTabAdminBranding() throws Exception {
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[6]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div[2]/input[2]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div[2]/input[2]")).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div[2]/input[2]")).sendKeys("#1f16c6");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/div/div")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/div/div[2]/input[2]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/div/div[2]/input[2]")).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/div/div[2]/input[2]")).sendKeys("#200101");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[4]/div/button[2]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[4]/div/button[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[4]/div/button[3]")).click();
        Thread.sleep(3000);
    }

}
