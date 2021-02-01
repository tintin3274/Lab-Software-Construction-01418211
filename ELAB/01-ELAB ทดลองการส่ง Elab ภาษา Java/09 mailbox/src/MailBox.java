// elab-source: MailBox.java

public class MailBox {
    private int totalMail;
    private int floor;
    private int room;

    private static int floorC = 0;
    private static int roomC = 0;

    public static MailBox[][] createMailBox(){
        MailBox[][] mailbox = new MailBox[12][10];
        for(int i=0; i<12; i++){
            for(int j=0; j<10; j++){
                mailbox[i][j] = new MailBox(i, j);
            }
        }
        return mailbox;
    }

    public MailBox(int floor, int room){
        totalMail = 0;
        this.floor = floor+1;
        this.room = room;
    }

    public MailBox(){
        totalMail = 0;
    }

    public void addMail(int amountMail){
        if(amountMail>0){
            totalMail += amountMail;
        }
    }

    public int getTotalMail() {
        return totalMail;
    }

    public void clearMail(){
        totalMail = 0;
    }

    public int getFloor() {
        return floor;
    }

    public int getRoom() {
        return room;
    }

    public static int getFloorC() {
        return floorC;
    }

    public static int getRoomC() {
        return roomC;
    }

    public static boolean checkRoom(String numRoom){
        if(Integer.parseInt(numRoom) >= 14010 && Integer.parseInt(numRoom) <= 14129){
            floorC = Integer.parseInt(numRoom.substring(2, 4));
            roomC = Integer.parseInt(String.valueOf((numRoom.charAt(4))));
            return true;
        }
        return false;
    }

    public static void insertMail(MailBox[][] mailbox, int amountMail){
        mailbox[floorC-1][roomC].addMail(amountMail);
    }
}
