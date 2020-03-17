import com.vaadin.testbench.TestBenchElement;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;

class Elements extends TestBenchElement {
    String excelCellValue;
    String cell_Value;

    //This method for read the data from excel file
    public String File(String varName) throws IOException{
        String filePath = "C:\\Users\\selvamuthukumar.g.ZUCISYSTEMS\\OneDrive - zucisystems.com\\SG\\Patricia\\Automation Files\\Patricia_TestBench\\data.xlsx";
        String fileName = "data.xlsx";
        String sheetName =  "Sheet1";
        String column_Value= "2";
        int c_Value = Integer.parseInt(column_Value);
        FileInputStream inputStream = new FileInputStream(filePath);
        Workbook Workbook = null;
        String fileExtensionName = fileName.substring(fileName.indexOf("."));
        if(fileExtensionName.equals(".xlsx")){
            Workbook = new XSSFWorkbook(inputStream);
        }
        else if(fileExtensionName.equals(".xls")){
            Workbook = new HSSFWorkbook(inputStream);
        }
        Sheet WorkSheet = Workbook.getSheet(sheetName);
        int rowCount = WorkSheet.getLastRowNum()-WorkSheet.getFirstRowNum();

        for (int i = 0; i < rowCount+1; i++) {
            Row row = WorkSheet.getRow(i);
            Cell cell= row.getCell(0);
            cell_Value = cell.toString();
            if (cell_Value.equalsIgnoreCase(varName))
            {
                Cell cell_Out_Value= row.getCell(c_Value);
                excelCellValue=cell_Out_Value.getStringCellValue();
                inputStream.close();
                break;
            }
        }
        return excelCellValue;

    }
    //This method is to find the usernamefield
    protected WebElement getUsernameField() {
        WebElement username = findElement(By.xpath("//*[@id='trishForm']/div/div[1]/input"));
        return username;
    }
    //This method is to find the passwordfield
    protected WebElement getpasswordfield() {
        WebElement password = findElement(By.xpath("//*[@id='trishForm']/div/div[3]/input"));
        return password;
    }
    //This method is to find the loginbutton field
    protected WebElement  getloginbutton()  {
        WebElement login= findElement(By.xpath("//div[@class='v-button v-widget trish-login-button v-button-trish-login-button']"));
        return login;
    }
    //This method is to find the searchfield
    protected WebElement getsearchfield() throws InterruptedException {
        WebElement search=findElement(By.xpath("//input[contains(class,search-full-text-advanced)]"));
        return search;
    }
    //This method is to perform the Keyboard actions
    protected Robot Enter() throws AWTException {
        Robot keyboard=new Robot();
        return keyboard;
    }
    //This method is to find the documenttabfield
    protected WebElement getdocumenttabfield(){
        waitUntil(ExpectedConditions.elementToBeClickable(By.id("documents_tab")),10);
        WebElement documenttab=findElement(By.id("documents_tab"));
        return documenttab;
    }
    //This method is to perform driver to wait
    protected void getwait() throws InterruptedException {
        Thread.sleep(2500);
    }
    //This method is to find the menufield
    protected WebElement getmenufield(){
        waitUntil(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='v-csslayout v-layout v-widget nav-menu-open-button v-csslayout-nav-menu-open-button']")),10);
        WebElement menu=findElement(By.xpath("//div[@class='v-csslayout v-layout v-widget nav-menu-open-button v-csslayout-nav-menu-open-button']"));
        return menu;
    }
    //This method is to find the selectcreatecase
    protected WebElement getselectcreatecase(){
        waitUntil(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Create Case']")),10);
        WebElement createcaseselection=findElement(By.xpath("//span[text()='Create Case']"));
        return createcaseselection;
    }
    //This method is to find the selecttype field
    protected WebElement getselecttype(){
        waitUntil(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Case type']/following::input")),10);
        WebElement createcaseselection=findElement(By.xpath("//div[text()='Case type']/following::input"));
        return createcaseselection;
    }
    //This method is to find the country field
    protected WebElement getselectcountry(){
        waitUntil(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Country']/following::input")),10);
        WebElement createcountryselection=findElement(By.xpath("//div[text()='Country']/following::input"));
        return createcountryselection;
    }
    //This method is to find the applicationtype field
    protected WebElement getselectapplicationtype(){
        waitUntil(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Application type']/following::input")),10);
        WebElement createcountryselection=findElement(By.xpath("//div[text()='Application type']/following::input"));
        return createcountryselection;
    }
    //This method is to find the cathword field
    protected WebElement getcathword(){
        waitUntil(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Catchword']/following::input")),10);
        WebElement createcathword=findElement(By.xpath("//div[text()='Catchword']/following::input"));
        return createcathword;
    }
    //This method is to find the servicelevel field
    protected WebElement getservicelevel(){
        waitUntil(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Service level']/following::input")),10);
        WebElement createservicelevel=findElement(By.xpath("//div[text()='Service level']/following::input"));
        return createservicelevel;
    }
    //This method is to find the team field
    protected WebElement getteam(){
        waitUntil(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Team']/following::input")),10);
        WebElement createteam=findElement(By.xpath("//div[text()='Team']/following::input"));
        return createteam;
    }
    //This method is to click okbutton
    protected WebElement getokbutton(){
        waitUntil(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='OK']")),10);
        WebElement createcaseokbutton=findElement(By.xpath("//span[text()='OK']"));
        return createcaseokbutton;
    }
    //This method is to click popupokbutton
    protected WebElement getpopupokbutton(){
        waitUntil(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='v-button v-widget blue-button v-button-blue-button primary-button v-button-primary-button']")),10);
        WebElement createcasepopupokbutton=findElement(By.xpath("//div[@class='v-button v-widget blue-button v-button-blue-button primary-button v-button-primary-button']"));
        return createcasepopupokbutton;
    }
    //This method is to perform adding document in the documents widget
    public void add_document() throws AWTException, InterruptedException, IOException {
        File("Document path_AddDocument");
        getwait();
        WebElement add = findElement(By.xpath("//input[@class='gwt-FileUpload']//following::div[1]"));
        waitUntil(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='gwt-FileUpload']//following::div[1]")));
        add.sendKeys(excelCellValue);
        Clipboard copy = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection copy_value = new StringSelection(excelCellValue);
        System.out.println(excelCellValue);
        copy.setContents(copy_value, null);
        getwait();

    }
    //This method is to click adddocumentokbutton
    protected WebElement getadddocumentokbutton(){
        waitUntil(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='OK']")), 10);
        WebElement okbutton =findElement(By.xpath("//span[text()='OK']"));
        okbutton.click();
        return okbutton;
    }
    //This method is to click logoutbutton
    protected WebElement getlogout(){
        WebElement logoutbutton =findElement(By.xpath("//div[@class='v-slot v-slot-logout v-align-middle']/child::div/child::span"));
        return logoutbutton;
    }







    //This method is to perform login
    public void getlogin() throws AWTException, IOException, InterruptedException {
        File("userName");
        getUsernameField().sendKeys(excelCellValue);
        File("password");
        getpasswordfield().sendKeys(excelCellValue);
        getwait();
        Enter().keyPress(KeyEvent.VK_ENTER);
    }
    //This method is to perform search
    public void search( ) throws InterruptedException, AWTException, IOException {
        getwait();
        File("caseNumber");
        getsearchfield().sendKeys(excelCellValue);
        Enter().keyPress(KeyEvent.VK_ENTER);
        getwait();getwait();
        getwait();getwait();
    }
    //This method is to perform negativesearch
    public void searchnegative( ) throws InterruptedException, AWTException, IOException {
        getwait();
        File("case Negative");
        getsearchfield().sendKeys("P00000");
        Enter().keyPress(KeyEvent.VK_ENTER);
        getwait();getwait();
        getwait();getwait();
    }



    //This method is to check the type of search
    public void SearchCheck() throws IOException, InterruptedException, AWTException {
        boolean val= false;

            getwait();
            File("CaseNo");
            getsearchfield().sendKeys(excelCellValue);
            getwait();
            Enter().keyPress(KeyEvent.VK_ENTER);
            getwait();
            getwait();
            String SearchValue=excelCellValue;

    }
    //This method is to click documetwedgit
    public void documetwedgit() throws InterruptedException {
        getwait();
        getdocumenttabfield().click();
    }
    //This method is to create a case
    public void Createcase() throws AWTException, InterruptedException, IOException {
        getmenufield().click();
        getselectcreatecase().click();
        getwait();
        File("Case type");
        getselecttype().sendKeys(excelCellValue);
        getwait();
        Enter().keyPress(KeyEvent.VK_ENTER);
        getwait();

        File("Country");
        getselectcountry().sendKeys(excelCellValue);
        getwait();
        Enter().keyPress(KeyEvent.VK_ENTER);
        getwait();

        File("Application type");
        getselectapplicationtype().sendKeys(excelCellValue);
        getwait();
        Enter().keyPress(KeyEvent.VK_ENTER);
        getwait();

        File("Catchword");
        getcathword().sendKeys(excelCellValue);

        File("Service level");
        getservicelevel().sendKeys(excelCellValue);
        getwait();
        Enter().keyPress(KeyEvent.VK_ENTER);
        getwait();

        File("Team");
        getteam().sendKeys(excelCellValue);
        getwait();
        Enter().keyPress(KeyEvent.VK_ENTER);
        getwait();

        getokbutton().click();

        getpopupokbutton().click();
        getwait();

    }
    //This method is to perform documentcreation
    public void documentcreation() throws InterruptedException, AWTException, IOException {
        add_document();

        Enter().keyPress(KeyEvent.VK_CONTROL);
        Enter().keyPress(KeyEvent.VK_V);
        Enter().keyRelease(KeyEvent.VK_V);
        Enter().keyRelease(KeyEvent.VK_CONTROL);
        Enter().keyPress(KeyEvent.VK_ENTER);
        Enter().keyRelease(KeyEvent.VK_ENTER);
        getwait();
        Enter().keyPress(KeyEvent.VK_CONTROL);
        Enter().keyPress(KeyEvent.VK_V);
        Enter().keyRelease(KeyEvent.VK_V);
        Enter().keyRelease(KeyEvent.VK_CONTROL);
        Enter().keyPress(KeyEvent.VK_ENTER);
        Enter().keyRelease(KeyEvent.VK_ENTER);
        getwait();
        waitUntil(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='OK']")));
        getadddocumentokbutton();

    }

    //This method is to perform logout
    public void logout() throws InterruptedException {
        getwait();
        getlogout().click();
        getwait();
    }


}





















