package Lab8_Adapter;

import java.util.HashMap;
import java.util.Map;

class New_Bank_A {
    protected HashMap<Customer, Integer> customers = new HashMap<>();

    public void newCustomer(Customer c, int limit){
        customers.put(c,limit);
    }

    public int checkLimit(String fN){
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
                    System.out.println("New Bank A: Customer " + fullname + ", your limit is increased to " + newLimit + ".");
                } else if (newLimit > tuple.getValue() && newLimit < (tuple.getValue() * 2)) {
                    tuple.setValue(newLimit);
                    System.out.println("New Bank A: Customer " + fullname + ", your limit is increased to " + newLimit + ".");
                } else {
                    System.out.println("New Bank A: We cannot increase your limit " + fullname + ".");
                }
                return;
            }
        }
        System.out.println("New Bank A: No customer with name: " + fullname + ".");
    }
}