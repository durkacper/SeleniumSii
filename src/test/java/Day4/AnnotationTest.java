package Day4;

import org.testng.annotations.*;

public class AnnotationTest {

    @BeforeClass
    public void executeBeforeVlass(){
        System.out.println("To sie wykona przed wszystkim");
    }

    @BeforeMethod
    public void executeBeforeMethod(){
        System.out.println("To sie wykona przed kazdym testem");
    }

    @Test
    public void myFirstTest(){
        System.out.println("To jest moj pierwszy test");
    }

    @Test
    public void mySecondTest(){
        System.out.println("To jest moj drugi");
    }

    @AfterMethod
    public void executeAfterMethod(){
        System.out.println("To sie wykona po kazdym tescie");
    }

    @AfterClass
    public void executeAfterClass(){
        System.out.println("To sie wykona po wszystkim");
    }

}
