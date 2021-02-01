import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandSystemTest {

    @Test
    void test_executeTouch(){
        CommandSystem system = new CommandSystem();
        system.execute("touch file-name");
        assertEquals("touch", system.getCommand());
        assertEquals("file-name", system.getParams());
        assertEquals(null, system.getOutput());
    }

    @Test
    void test_executeTouchFileAlreadyExist(){
        CommandSystem system = new CommandSystem();
        system.execute("touch file-name");
        assertEquals("touch", system.getCommand());
        assertEquals("file-name", system.getParams());
        assertEquals(null, system.getOutput());

        system.execute("touch file-name");
        assertEquals("touch", system.getCommand());
        assertEquals("file-name", system.getParams());
        assertEquals("File file-name Already Exist", system.getOutput());
    }

    @Test
    void test_executeEcho(){
        CommandSystem system = new CommandSystem();
        system.execute("touch file-name");
        system.execute("echo \"text\" > file-name");
        assertEquals("echo", system.getCommand());
        assertEquals("\"text\" > file-name", system.getParams());
        assertEquals(null, system.getOutput());

        system.execute("echo \"text\" >> file-name");
        assertEquals("echo", system.getCommand());
        assertEquals("\"text\" >> file-name", system.getParams());
        assertEquals(null, system.getOutput());
    }

    @Test
    void test_executeEchoFileNotFound(){
        CommandSystem system = new CommandSystem();
        system.execute("echo \"text\" > new-file-name.md");
        assertEquals("echo", system.getCommand());
        assertEquals("\"text\" > new-file-name.md", system.getParams());
        assertEquals("File new-file-name.md Not Found", system.getOutput());

        system.execute("echo \"text\" >> new-file-name.md");
        assertEquals("echo", system.getCommand());
        assertEquals("\"text\" >> new-file-name.md", system.getParams());
        assertEquals("File new-file-name.md Not Found", system.getOutput());
    }

    @Test
    void test_executeExit(){
        CommandSystem system = new CommandSystem();
        system.execute("exit");
        assertEquals("exit", system.getCommand());
        assertEquals("", system.getParams());
        assertEquals(null, system.getOutput());
    }

    @Test
    void test_commandCat(){
        CommandSystem system = new CommandSystem();
        system.execute("touch readme.md");
        system.execute("echo TEXT > readme.md");
        system.execute("cat readme.md");
        assertEquals("TEXT", system.getOutput());
    }

    @Test
    void test_commandCatFileNotFound(){
        CommandSystem system = new CommandSystem();
        system.execute("echo TEXT > readmePlease.md");
        assertEquals("File readmePlease.md Not Found", system.getOutput());
        system.execute("cat readmePlease.md");
        assertEquals("File readmePlease.md Not Found", system.getOutput());
    }
}