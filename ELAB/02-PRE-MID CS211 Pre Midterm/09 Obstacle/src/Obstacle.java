//elab-source:Obstacle.java

public class Obstacle {
    private int length;

    public void setLength(int length){
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public String image(){
        String image = "";
        for(int i=0; i<length; i++){
            image += '*';
        }
        return image;
    }
}
