import java.util.ArrayList;
import java.util.Arrays;

public class CommandSystem {
    private ArrayList<MyFile> files = new ArrayList<>();
    private String command;
    private String params;
    private String output;

    public void execute(String commandLine){
        String commandLineSplit[] = commandLine.split(" ");
        command = commandLineSplit[0];
        switch (command){
            case "touch": params = commandLineSplit[1]; touch(files, params);break;
            case "echo": params = commandLine.substring(5); echo(files, params);break;
            case "cat": params = commandLineSplit[1]; cat(files, params);break;
            case "exit": params = "";
        }
    }

    public String getCommand() {
        return command;
    }

    public String getParams() {
        return params;
    }

    public String getOutput() {
        return output;
    }

    private void touch(ArrayList<MyFile> files, String fileName){
        output = null;
        boolean notFound = true;
        for(MyFile f: files){
            if(f.getName().equals(fileName)){
                notFound = false;
            }
        }
        if(notFound){
            files.add(new MyFile(fileName));
        }
        else {
            output = "File "+fileName+" Already Exist";
        }
    }


    private void echo(ArrayList<MyFile> files, String input){
        output = null;
        String text;
        String mode;
        String fileName;
        boolean notFound = true;

        if(input.contains("\"")){
            int last = (input.indexOf('\"', 2));
            text = input.substring(2, last);
            int head = last+2;
            last = (input.indexOf(' ', head));
            mode = input.substring(head, last);
            head = last+1;
            fileName = input.substring(head);
        }
        else{
            String inputSplit[] = input.split(" ");
            text = inputSplit[0];
            mode = inputSplit[1];
            fileName = inputSplit[2];
        }

        for(MyFile f: files){
            if(f.getName().equals(fileName)){
                if(mode.equals(">>")){
                    f.appendContent(text);
                }
                else if(mode.equals(">")){
                    f.setContent(text);
                }
                notFound = false;
            }
        }

        if(notFound){
            output = "File "+fileName+" Not Found";
        }
    }


    private void cat(ArrayList<MyFile> files, String fileName){
        output = null;
        boolean notFound = true;

        for(MyFile f: files){
            if(f.getName().equals(fileName)){
                output = f.getContent();
                notFound = false;
            }
        }

        if(notFound){
            output = "File "+fileName+" Not Found";
        }
    }
}
