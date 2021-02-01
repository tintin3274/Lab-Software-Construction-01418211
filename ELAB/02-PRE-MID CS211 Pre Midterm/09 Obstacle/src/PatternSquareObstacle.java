//elab-source:PatternSquareObstacle.java

public class PatternSquareObstacle extends SquareObstacle{
    char pattern = '*';

    public void setPattern(char pattern){
        this.pattern = pattern;
    }

    public String image(){
        String image = "";
        image = super.image().replace('*', pattern);
        return image;
    }
}
