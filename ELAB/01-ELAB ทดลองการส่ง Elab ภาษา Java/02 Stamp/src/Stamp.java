//elab-source:Stamp.java

public class Stamp {
    private double total;

    public Stamp(){
        total = 0;
    }
    public void purchase(double total){
        this.total += total;
    }
    public int calculateStamp(){
        return (int) total/50;
    }
}
