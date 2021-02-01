public class Car extends Vehicle {
    private int wheel;

    public Car(int passenger, String brand, int wheel){
        super(passenger, brand);
        this.wheel = wheel;
    }

    public void move(){
        super.move();
        System.out.println("Car move");
    }

    public void move(int distance){
        move();
        System.out.println("Move "+distance);
    }

    public void startEngine(){
        setPassenger(getPassenger()-1);
        System.out.println("Start engine");
    }
}
