//elab-source:ChemicalFireFightingPlane.java

public class ChemicalFireFightingPlane extends FireFightingPlane{
    private char chemical = '*';

    public ChemicalFireFightingPlane (char chemical){
        if(chemical != '*'){
            this.chemical = chemical;
        }
    }

    public void setChemical(char chemical){
        if(chemical != '*'){
            this.chemical = chemical;
        }
    }

    @Override
    public void drive() {
        if(super.getWater()>0){
            String line = getOutput();
            System.out.println(line+"\n"+line.replace('*',chemical)+"\n"+line);
        }
    }
}
