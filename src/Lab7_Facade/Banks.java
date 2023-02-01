package Lab7_Facade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Customer{
    private String fullname;
    private int TC;

    public Customer(String fN, int tc){
        fullname = fN;
        TC = tc;
    }

    public String getFullname() {
        return fullname;
    }

    public int getTC() {
        return TC;
    }
}

class Bank_A{
    private HashMap<Customer, Integer> customers = new HashMap<>();

    public void addCustomer(Customer c, int limit){
        customers.put(c,limit);
    }

    public int getLimit(int tc){
        for (Map.Entry<Customer, Integer> tuple : customers.entrySet()) {
            if(tuple.getKey().getTC() == tc){
                return tuple.getValue();
            }
        }
        return -1;
    }

    public void raiseLimit(int tc, int newLimit){
        for (Map.Entry<Customer, Integer> tuple : customers.entrySet()) {
            if(tuple.getKey().getTC() == tc) {
                if (newLimit > tuple.getValue() && tuple.getValue() < 10000) {
                    tuple.setValue(newLimit);
                    System.out.println("Bank A: Customer " + tc + " your, limit is increased to " + newLimit + ".");
                } else if (newLimit > tuple.getValue() && newLimit < 10000) {
                    tuple.setValue(newLimit);
                    System.out.println("Bank A: Customer " + tc + " your, limit is increased to " + newLimit + ".");
                } else {
                    System.out.println("Bank A: We cannot increase your limit " + tc + ".");
                }
                return;
            }
        }
        System.out.println("No customer with TCKNO: " + tc + ".");
    }

}

class Bank_B {
    private HashMap<Customer, Integer> customers = new HashMap<>();

    public void newCustomer(Customer c, int limit){
        customers.put(c,limit);
    }

    public int getLimit(String fN){
        for (Map.Entry<Customer, Integer> tuple : customers.entrySet()) {
            if(tuple.getKey().getFullname().equals(fN)){
                return tuple.getValue();
            }
        }
        return -1;
    }

    public void changeLimit(String fullname, int newLimit){
        for (Map.Entry<Customer, Integer> tuple : customers.entrySet()) {
            if(tuple.getKey().getFullname().equals(fullname)) {
                if (newLimit > tuple.getValue() && tuple.getValue() < 20000) {
                    tuple.setValue(newLimit);
                    System.out.println("Bank A: Customer " + fullname + ", your limit is increased to " + newLimit + ".");
                } else if (newLimit > tuple.getValue() && newLimit < (tuple.getValue() * 2)) {
                    tuple.setValue(newLimit);
                    System.out.println("Bank A: Customer " + fullname + ", your limit is increased to " + newLimit + ".");
                } else {
                    System.out.println("Bank A: We cannot increase your limit " + fullname + ".");
                }
                return;
            }
        }
        System.out.println("No customer with name: " + fullname + ".");
    }
}


public class Banks {
    public static void main(String [] args){
        Customer c1 = new Customer("Erdem Okur", 12345);
        Bank_A b1 = new Bank_A();
        Bank_B b2 = new Bank_B();

        b1.addCustomer(c1,9000);
        b2.newCustomer(c1,15000);

        System.out.println("Initial Limits:");
        System.out.println(b1.getLimit(12345));
        System.out.println(b2.getLimit("Erdem Okur"));

        b1.raiseLimit(12345,17000);
        b2.changeLimit("Erdem Okur",20000);

        System.out.println("Edited Limits:");
        System.out.println(b1.getLimit(12345));
        System.out.println(b2.getLimit("Erdem Okur"));
    }
}

