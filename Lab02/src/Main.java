import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input;
        int round = 1;

        System.out.println("!!!! Monster Fight !!!!");
        System.out.println("Please input monster1 name hp atk def :");
        Monster m1 = new Monster(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextInt());
        System.out.println("Please input monster2 name hp atk def :");
        Monster m2 = new Monster(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextInt());
        System.out.println("");

        while (true) {
            System.out.println("Round : " + round);

            System.out.println(">>> Monster 1 turn <<<");
            if (m1.getCooldown()) {
                System.out.println("Monster 1 Can't use skill");
                m1.reCooldown();
            } else {
                System.out.println("Please enter skill A=attack H=heal");
                input = sc.next();

                if (input.equals("A") || input.equals("a")) {
                    m2.attacked(m1.getAtk());
                }

                if (input.equals("H") || input.equals("h")) {
                    System.out.println("Please enter recovery hp :");
                    m1.recovery(sc.nextInt());
                }

                System.out.println(m1.toString());
                System.out.println(m2.toString());

                if (m2.getHp() == 0) {
                    System.out.println("\nThe Winner Is ..........");
                    System.out.println(m1.toString());
                    break;
                }
            }

            System.out.println(">>> Monster 2 turn <<<");
            if (m2.getCooldown()) {
                System.out.println("Monster 2 Can't use skill");
                m2.reCooldown();
            } else {
                System.out.println("Please enter skill A=attack H=heal");
                input = sc.next();

                if (input.equals("A") || input.equals("a")) {
                    m1.attacked(m2.getAtk());
                }

                if (input.equals("H") || input.equals("h")) {
                    System.out.println("Please enter recovery hp :");
                    m2.recovery(sc.nextInt());
                }

                System.out.println(m1.toString());
                System.out.println(m2.toString());

                if (m1.getHp() == 0) {
                    System.out.println("\nThe Winner Is ..........");
                    System.out.println(m2.toString());
                    break;
                }
            }

            round++;
            System.out.println("");
        }
    }
}