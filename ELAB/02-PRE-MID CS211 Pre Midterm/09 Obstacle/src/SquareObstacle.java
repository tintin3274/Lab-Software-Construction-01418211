//elab-source:SquareObstacle.java

public class SquareObstacle extends Obstacle{
    public String image(){
        String image = "";
        for(int i=0; i<super.getLength(); i++){
            image += super.image()+"\n";
        }
        return image;
    }
}
