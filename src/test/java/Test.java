import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Test extends Functions {




    @org.junit.Test
    //This method is to perform creating a case
    public void AddCaseTest() throws Exception {
        Initial_Setup();
        Login();
        Case_Create();
        Final_Setup();
    }

    @org.junit.Test
    //This method is to perform Adding a Document
    public void DocumentAddTest() throws Exception {
        Initial_Setup();
        Login();
        Document_Add();
        Final_Setup();
    }

    @org.junit.Test
    //This method is to perform Previewing a Document
    public void PreviewtheDocumentTest() throws Exception {
        Initial_Setup();
        Login();
        Document_Preview();
        Final_Setup();
    }

    @org.junit.Test
    //This method is to perform searcing a negative case no
    public void SearchforNegativeCase() throws Exception {
        Initial_Setup();
        Login();
        Search_Negative_Case();
        Final_Setup();
    }


}

