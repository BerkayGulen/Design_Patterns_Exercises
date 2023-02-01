package Lab7_Facade;

import java.util.ArrayList;
import java.util.Locale;

public class CentralBank {
    private Bank_A bank_a;
    private Bank_B bank_b;
    private static CentralBank centralBank;

    private CentralBank(Bank_A bank_a, Bank_B bank_b) {
        this.bank_a = bank_a;
        this.bank_b = bank_b;
    }

    public static CentralBank getInstance(Bank_A bank_a, Bank_B bank_b) {
        if (centralBank == null) {
            centralBank = new CentralBank(bank_a, bank_b);
            return centralBank;
        }
        return centralBank;
    }

    public Boolean bankAction(Customer customer, int initialLimit, int newLimit, String bankName, ArrayList<Boolean> actions) {

        if (bankName.toUpperCase(Locale.ROOT).equals("A")) {
            //add customer
            if (actions.get(0)) {
                bank_a.addCustomer(customer, initialLimit);
                System.out.println("Customer Added to Bank A");
            }
            //get limit
            if (actions.get(1)) {
                System.out.println("Your Limit is: " + bank_a.getLimit(customer.getTC()));
            }
            //raise limit
            if (actions.get(2)) {
                bank_a.raiseLimit(customer.getTC(), newLimit);
            }
        } else if (bankName.toUpperCase(Locale.ROOT).equals("B")) {
            if (actions.get(0)) {
                bank_b.newCustomer(customer, initialLimit);
                System.out.println("Customer Added to Bank B");
            }
            //get limit
            if (actions.get(1)) {
                System.out.println("Your Limit is: " + bank_b.getLimit(customer.getFullname()));
            }
            //raise limit
            if (actions.get(2)) {
                bank_b.changeLimit(customer.getFullname(), newLimit);
            }

        } else {
            System.out.println("Wrong Bank Input!!!");
        }


        return null;
    }
}
