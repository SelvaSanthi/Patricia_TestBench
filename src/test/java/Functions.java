//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import com.vaadin.testbench.TestBench;
import com.vaadin.testbench.TestBenchTestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.io.IOException;


public class Functions extends TestBenchTestCase {
    public Functions() {
    }
    public void Log(String Obj) {
        System.out.println("===========" + Obj + "Process Completed Successfully=============");
    }

    //This method is to perform Initial_Setup
    public void Initial_Setup() throws Exception {
        String Browser_lanch= "firefox";
        if (Browser_lanch.equalsIgnoreCase("firefox")) {
            this.setDriver(TestBench.createDriver(new FirefoxDriver()));
            this.setDriver(this.driver);
            this.driver.manage().window().maximize();
            Elements Setup = (Elements)this.$(Elements.class).first();
            Setup.File("appURL");
            this.getDriver().get(Setup.excelCellValue);
            this.Log("Initial_Setup");
        } else{
            this.setDriver(TestBench.createDriver(new ChromeDriver()));
            this.setDriver(this.driver);
            this.driver.manage().window().maximize();
            Elements Setup = (Elements)this.$(Elements.class).first();
            Setup.File("appURL");
            this.getDriver().get(Setup.excelCellValue);
            this.Log("Initial_Setup");
        }


    }



    //This method is to perform Creating a case
    public void Case_Create() throws AWTException, InterruptedException, IOException {
        Elements casecreatemenu = (Elements)this.$(Elements.class).first();
        casecreatemenu.Createcase();
        this.Log("Case_Create");
    }
    //This method is to perform Adding a Document
    public void Document_Add() throws AWTException, InterruptedException, IOException {
        Elements searchtextbox = (Elements)this.$(Elements.class).first();
        searchtextbox.search();
        Elements document = (Elements)this.$(Elements.class).first();
        document.documetwedgit();
        Elements adddocument = (Elements)this.$(Elements.class).first();
        adddocument.documentcreation();
        this.Log("Document_Add");
    }
    //This method is to perform login
    public void Login() throws Exception {
        Elements document = (Elements)this.$(Elements.class).first();
        document.getlogin();
        this.Log("Login");
    }
    //This method is to perform previewing a document
    public void Document_Preview() throws InterruptedException, AWTException, IOException {
        Elements searchtextbox = (Elements)this.$(Elements.class).first();
        searchtextbox.search();
        Elements document = (Elements)this.$(Elements.class).first();
        document.documetwedgit();
        Actions Mouse = new Actions(this.driver);
        document.getwait();
        WebElement documentpreview = this.driver.findElement(By.xpath("//table//tbody//tr//td[3]"));
        Mouse.doubleClick(documentpreview).build().perform();
        this.Log("Document_Preview");
    }
    //This method is to perform Negative case search
    public void Search_Negative_Case() throws InterruptedException, AWTException, IOException {
        Elements SearchField=(Elements)this.$(Elements.class).first();
        SearchField.searchnegative();
        String title=driver.getTitle();
        if (title.equals("Patricia")) {System.out.println(" No Results found for Case No: ");
        } else {  System.out.println("Search Results found for the Searched CaseNo");

    }

    }
    //This method is to perform Final_Setup
    public void Final_Setup() throws InterruptedException {
        Elements log = (Elements)this.$(Elements.class).first();
        log.logout();
        this.driver.close();
        this.Log("Final_Setup");
    }
}
