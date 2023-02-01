package Lab8_Adapter;

public class Main { // Bank

    public static void main(String [] args){
        Customer c1 = new Customer("Berkay Gülen", 12345);
        IBank b1 = new Adapter(new New_Bank_A());

        b1.addCustomer(c1,9000);

        System.out.println("Initial Limits:");
        System.out.println(b1.learnLimit(12345));

        b1.raiseLimit(12345,17000);

        System.out.println("Edited Limits:");
        System.out.println(b1.learnLimit(12345));

    }
}
