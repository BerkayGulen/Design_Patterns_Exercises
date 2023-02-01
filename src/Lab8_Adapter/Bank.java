package Lab8_Adapter;

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

interface IBank{
    void addCustomer(Customer c, int limit);
    int learnLimit(int tc);
    void raiseLimit(int tc, int newLimit);
}

class Bank_A implements IBank{
    private HashMap<Customer, Integer> customers = new HashMap<>();

    public void addCustomer(Customer c, int limit){
        customers.put(c,limit);
    }

    public int learnLimit(int tc){
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
        System.out.println("Bank A: No customer with TCKNO: " + tc + ".");
    }

}

class Adapter  implements IBank{
    private New_Bank_A new_bank_a;
    public Adapter(New_Bank_A new_bank_a){
        this.new_bank_a=new_bank_a;
    }

    @Override
    public void addCustomer(Customer c, int limit) {

        new_bank_a.newCustomer(c,limit);
    }

    @Override
    public int learnLimit(int tc) {
        for (Map.Entry<Customer, Integer> tuple : new_bank_a.customers.entrySet()) {
            if(tuple.getKey().getTC() == tc){
                return new_bank_a.checkLimit(tuple.getKey().getFullname());
            }
        }
        return -1;
    }

    @Override
    public void raiseLimit(int tc, int newLimit) {
        for (Map.Entry<Customer, Integer> tuple : new_bank_a.customers.entrySet()) {
            if(tuple.getKey().getTC() == tc){
                new_bank_a.changeLimit(tuple.getKey().getFullname(),newLimit);
            }
        }
    }
}

