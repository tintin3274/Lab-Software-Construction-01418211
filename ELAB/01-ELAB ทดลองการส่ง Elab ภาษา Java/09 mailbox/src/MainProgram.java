// elab-source: MainProgram.java
// elab-mainclass: MainProgram

import java.util.Scanner;
public class MainProgram {
    public static void main(String[] args) {
        // initialize MailBox object
        MailBox[][] mailbox = MailBox.createMailBox();

        System.out.println("Welcome to Comsi Condominium");
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("Please select menu [I] = insert mail ; [C] = check total mail ; [G] = get mail ; [E] = exit");
            String command = sc.next();
            if(command.toLowerCase().charAt(0) == 'i'){
                System.out.println("Please enter [roomNumber numberOfMail] e.g. 14019 5");
                String numRoom = sc.next();
                int amountMail = sc.nextInt();
                if(MailBox.checkRoom(numRoom)){
                    MailBox.insertMail(mailbox, amountMail);
                } else {
                    System.out.println("Invalid Room Number");
                }

            }else if(command.toLowerCase().charAt(0) == 'c'){
                System.out.println("Please enter [roomNumber] e.g. 14019");
                String numRoom = sc.next();
                if(MailBox.checkRoom(numRoom)){
                        System.out.println("Total Mail in Your MailBox :  "+mailbox[MailBox.getFloorC()-1][MailBox.getRoomC()].getTotalMail());
                } else {
                    System.out.println("Invalid Room Number");
                }


            }else if (command.toLowerCase().charAt(0) == 'g'){
                System.out.println("Please enter [roomNumber] e.g. 14019");
                String numRoom = sc.next();
                if(MailBox.checkRoom(numRoom)){
                    if(mailbox[MailBox.getFloorC()-1][MailBox.getRoomC()].getTotalMail()>0){
                        mailbox[MailBox.getFloorC()-1][MailBox.getRoomC()].clearMail();
                    } else{
                        System.out.println("Not Found Mail in Room "+numRoom);
                    }

                } else {
                    System.out.println("Invalid Room Number");
                }

            }else if(command.toLowerCase().charAt(0 )== 'e'){
                break;
            }
        }
    }
}
