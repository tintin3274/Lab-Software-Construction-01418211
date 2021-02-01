public class Main {
    public static void main(String[] args) {
        GameCharacter slime = new GameCharacter(
                "Slime", 100, 40, new Weapon(0, 0));

        Weapon stick = new Weapon(3, 30);
        GameCharacter player = new GameCharacter("Inorin", 100, 20, stick);

        player.attack(slime);
        player.attack(slime);

        GameCharacter dragon = new GameCharacter(
                "Dragon", 2000, 250, new Weapon(0, 0));

        Gun rpg = new Gun(1200, 1, 1, 60);
        GameCharacter leon = new GameCharacter("Leon", 340, 44, rpg);

        leon.attack(dragon);
        leon.attack(dragon);

        Weapon a = new Gun(250, 25, 10, 99.99);

        Dog dog = new Dog("Inu", 100);
        dog.play();
        dog.play();
        dog.play();
        dog.play();
        dog.wash();

        Chicken kfc = new Chicken("ChickGo", 15.9);
        kfc.wash();
        dog.eat(kfc);

        Vegetable lettuce = new Vegetable("lettuce", 65.3);
        dog.eat(lettuce);

        Computer com = new Computer("My PC");

        Network network1 = new Network("True Online", "66.249.79.37");
        Network network2 = new Network("3BB", "27.55.6.145");
        Network network3 = new Network("Ais Fibre", "27.55.155.82");

        com.connect(network1);
        com.connect(network2);
        com.disconnect(network3);
        com.disconnect(network2);

        Radio radio = new Radio("Tanin");

        RemoteControl.increaseVolume(com);
        RemoteControl.decreaseVolume(radio);
    }
}
