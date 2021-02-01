public class CafeCard {
    private String cardHolderName;
    private double balance;

    private CafeCard(String cardHolderName, double balance) {
        this.cardHolderName = cardHolderName;
        this.balance = balance;
    }

    public CafeCard() {
        this("Anonymous", 0);
    }

    public CafeCard(String name) {
        this(name, 0);
    }

    public void getCardinfo() {
        System.out.println("<Name: " + cardHolderName + "> - <Balance: " + balance + " baht>");
    }

    public void addCredit(double amount) {
        if (amount >= 100) {
            balance += amount;
            getCardinfo();
        } else {
            System.out.println("Sorry, unable to top up Please top up a minimum of 100 baht.");
            getCardinfo();
        }
    }

    public void paid(double amount) {
        if (balance >= amount) {
            balance -= amount;
            getCardinfo();
        } else {
            System.out.println("There is not enough balance in the card. Please top up.");
            getCardinfo();
        }
    }
}