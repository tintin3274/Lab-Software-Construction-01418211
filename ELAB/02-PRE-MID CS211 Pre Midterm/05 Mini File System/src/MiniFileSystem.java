//elab-source:MiniFileSystem.java

import java.util.ArrayList;

public class MiniFileSystem {
    private String fileName;
    private String text;

    public MiniFileSystem(String fileName){
        this.fileName = fileName;
        text = "";
    }

    public String getFileName() {
        return fileName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text){
        this.text = text;
    }

    public static void touch(ArrayList<MiniFileSystem> file, String fileName){
        boolean notFound = true;
            for(MiniFileSystem f: file){
                if(f.getFileName().equals(fileName)){
                    notFound = false;
                }
            }
            if(notFound){
                file.add(new MiniFileSystem(fileName));
            }
            else {
                System.out.println("File "+fileName+" Already Exist");
            }
    }


    public static void echo(ArrayList<MiniFileSystem> file, String input){
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
            text = inputSplit[1];
            mode = inputSplit[2];
            fileName = inputSplit[3];
        }

        for(MiniFileSystem f: file){
            if(f.getFileName().equals(fileName)){
                if(mode.equals(">>")){
                    f.setText(f.getText()+text);
                }
                else if(mode.equals(">")){
                    f.setText(text);
                }
                notFound = false;
            }
        }

        if(notFound){
            System.out.println("File "+fileName+" Not Found");
        }
    }


    public static void cat(ArrayList<MiniFileSystem> file, String fileName){
        boolean notFound = true;

        for(MiniFileSystem f: file){
            if(f.getFileName().equals(fileName)){
                System.out.println(f.getText());
                notFound = false;
            }
        }

        if(notFound){
            System.out.println("File "+fileName+" Not Found");
        }
    }
}
