import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyFileTest {

    @Test   // Annotation
    void testNewFile(){
        MyFile file = new MyFile("filename.txt");
        assertEquals("filename.txt", file.getName());
    }

    @Test
    void testNewFile_withEmptyContent(){
        MyFile file = new MyFile("filename.txt");
        assertEquals("", file.getContent());
    }

    @Test
    void test_writeContent(){
        MyFile file = new MyFile("error.log");
        file.setContent("Error on Thursday, 13:22");
        assertEquals("Error on Thursday, 13:22", file.getContent());
    }

    @Test
    void test_overWriteContent(){
        MyFile file = new MyFile("error.log");
        file.setContent("Error on Thursday, 13:22");
        file.setContent("OverWrite Error");
        assertEquals("OverWrite Error", file.getContent());
    }

    @Test
    @DisplayName("เพิ่มเนื้อหาในไฟล์")
    void test_appendContent(){
        MyFile file = new MyFile("student.csv");
        file.appendContent("Two Popthorn,");
        file.appendContent("Jumbo");
        assertEquals("Two Popthorn,Jumbo", file.getContent());
    }

    @Test
    void test_appendContentAfterSetContent(){
        MyFile file = new MyFile("tester.cvm");
        file.setContent("This is text set.");
        file.appendContent(" And This is text append.");
        assertEquals("This is text set. And This is text append.", file.getContent());
    }

    @Test
    void test_appendContentAfterAppendContent(){
        MyFile file = new MyFile("Logi.sm");
        file.appendContent("append Logi logi lo~~");
        file.appendContent(" Test append");
        assertEquals("append Logi logi lo~~ Test append", file.getContent());
    }
}

//TDD
//Test Driven Development
//- Unit Testing