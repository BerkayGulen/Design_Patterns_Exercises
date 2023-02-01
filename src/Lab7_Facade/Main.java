package Lab7_Facade;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Customer customer = new Customer("Berkay Gülen",1234);
        Customer customer2 = new Customer("Ali Bey",1234);


        Bank_A bank_a = new Bank_A();
        Bank_B bank_b = new Bank_B();

        CentralBank centralBank = CentralBank.getInstance(bank_a,bank_b);
        ArrayList<Boolean> actions = new ArrayList<>();

        actions.add(true);
        actions.add(true);
        actions.add(true);

        centralBank.bankAction(customer,100,500,"A",actions);
        centralBank.bankAction(customer2,1050,2000,"B",actions);




    }
}
