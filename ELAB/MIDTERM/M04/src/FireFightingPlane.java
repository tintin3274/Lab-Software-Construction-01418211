//elab-source:FireFightingPlane.java

public class FireFightingPlane {
    private int water;
    String output;

    public void fillWater(int water){
        this.water += water;
    }

    public void drive(){
        if(water>0){
            System.out.println(getOutput());
        }
    }

    public String getOutput() {
        output = "";
        for (int i=0; i<water; i++){
            output += "*";
        }
        water = 0;
        return output;
    }

    public int getWater() {
        return water;
    }
}
