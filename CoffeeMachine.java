package machine;
import java.util.Scanner;

public class CoffeeMachine {
    private int cash =550;
    private int water = 400;
    private int milk = 540;
    private int coffeeBeans = 120;
    private int cups = 9;
    public void setCash(int cash) {
        this.cash = cash;
    }
    public void setWater(int water) {
        this.water = water;
    }
    public void setMilk(int milk) {
        this.milk = milk;
    }
    public void setCoffeeBeans(int coffeeBeans) {
        this.coffeeBeans = coffeeBeans;
    }
    public void setCups(int cups) {
        this.cups = cups;
    }
    public int getCash() {
        return cash;
    }
    public int getWater() {
        return water;
    }
    public int getMilk() {
        return milk;
    }
    public int getCoffeeBeans() {
        return coffeeBeans;
    }
    public int getCups() {
        return cups;
    }
    public void stats(){
        System.out.println("The coffee machine has:");
        System.out.println(getWater()+" ml of water");
        System.out.println(getMilk()+" ml of milk");
        System.out.println(getCoffeeBeans()+" g of coffee beans");
        System.out.println(getCups()+" disposable cups");
        System.out.println("$"+getCash()+" of money");
    }
    public void buy(){
        Scanner sc = new Scanner(System.in);
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String input = sc.nextLine();
        if(input.equals("1")){
            if(getWater()<250||getCoffeeBeans()<16||getCups()<1){
                System.out.println("Sorry, not enough water!");
            }else {
                setWater(getWater() - 250);
                setCoffeeBeans(getCoffeeBeans() - 16);
                setCash(getCash() + 4);
                setCups(getCups() - 1);
                System.out.println("I have enough resources, making you a coffee!");
            }
        } else if (input.equals("2")) {
            if(getWater()<350||getCoffeeBeans()<20||getCups()<1||getMilk()<75){
                System.out.println("Sorry, not enough water!");
            }else {
                setWater(getWater() - 350);
                setCoffeeBeans(getCoffeeBeans() - 20);
                setMilk(getMilk() - 75);
                setCash(getCash() + 7);
                setCups(getCups() - 1);
                System.out.println("I have enough resources, making you a coffee!");
            }
        } else if (input.equals("3")) {
            if(getWater()<200||getCoffeeBeans()<12||getCups()<1||getMilk()<100){
                System.out.println("Sorry, not enough water!");
            }
            setWater(getWater()-200);
            setCoffeeBeans(getCoffeeBeans()-12);
            setMilk(getMilk()-100);
            setCash(getCash()+6);
            setCups(getCups()-1);
            System.out.println("I have enough resources, making you a coffee!");
        } else if (input.equals("back")) {
        }
    }
    public void fill(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Write how many ml of water you want to add:");
        int inputWater = sc.nextInt();
        setWater(getWater()+inputWater);
        System.out.println("Write how many ml of milk you want to add:");
        int inputMilk = sc.nextInt();
        setMilk(getMilk()+inputMilk);
        System.out.println("Write how many grams of coffee beans you want to add:");
        int inputBeans = sc.nextInt();
        setCoffeeBeans(getCoffeeBeans()+inputBeans);
        System.out.println("Write how many disposable cups you want to add:");
        int inputCups = sc.nextInt();
        setCups(getCups()+inputCups);
    }
    public void take(){
        System.out.println("I gave you $"+getCash());
        setCash(0);
    }
    public static void  menu(){
        Scanner sc = new Scanner(System.in);
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        String action = sc.nextLine();
        while (!action.equals("exit")) {
            switch (action){
                case("buy"):
                    coffeeMachine.buy();
                    break;
                case("fill"):
                    coffeeMachine.fill();
                    break;
                case("take"):
                    coffeeMachine.take();
                    break;
                case("remaining"):
                    coffeeMachine.stats();
                    break;
            }
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            action = sc.nextLine();
        }
    }

    public static void main(String[] args) {
        menu();
    }
}