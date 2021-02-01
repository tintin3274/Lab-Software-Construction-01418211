//elab-source:Vehicle.java

public class Vehicle {
    private String brand; //ยี่ห้อพาหนะ
    private String model; //รุ่นพาพนะ
    private int capacity; //จำนวนคนที่จุอยู่
    private int maxCapacity; //จำนวนคนที่จุได้สูงสุด
    private double weight; //น้ำหนักที่จุอยู่
    private double maxWeight; //น้ำหนักที่จุได้สูงสุด
    private String plateNumber; //เลขทะเบียนพาหนะ

    public Vehicle(String brand, String model, int maxCapacity, double maxWeight, String plateNumber){
        this.brand = brand;
        this.model = model;
        this.maxCapacity = maxCapacity;
        this.maxWeight = maxWeight;
        this.plateNumber = plateNumber;
    }

    public void drive(){

    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public double getWeight() {
        return weight;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public String getPlateNumber() {
        return plateNumber;
    }
}
