import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner input = new Scanner(System.in);
        int choice;
        double factor;
        ArrayList<Part> parts = new ArrayList<Part>();
        parts.add(new Motherboard(1500, new PricePolicy()));
        parts.add(new Memory(800, new PricePolicy()));
        parts.add(new HardDisk(500, new PricePolicy()));

        while (true){
            System.out.println("Enter 1 to change Motherboard factor");
            System.out.println("Enter 2 to change Memory factor");
            System.out.println("Enter 3 to change HardDisk factor");
            System.out.println("Enter -1 to exit");
            System.out.print("Choice: ");
            choice = input.nextInt();
            if (choice == -1){
                break;
            }else if(choice == 1){
                System.out.print("enter new factor: ");
                factor = input.nextDouble();
                for (Part part: parts){
                    if (part instanceof Motherboard){
                        System.out.println("previous price of Motherboard: "+part.getPrice());
                        PricePolicy pricePolicy = new PricePolicy();
                        pricePolicy.setPrice(factor);
                        part.setPricePolicy(pricePolicy);
                        System.out.println("current price of Motherboard: "+part.getPrice()+"\n");

                    }
                }
            }else if(choice == 2){
                System.out.print("enter new factor: ");
                factor = input.nextDouble();
                for (Part part: parts){
                    if (part instanceof Memory){
                        System.out.println("previous price of Memory: "+part.getPrice());
                        PricePolicy pricePolicy = new PricePolicy();
                        pricePolicy.setPrice(factor);
                        part.setPricePolicy(pricePolicy);
                        System.out.println("current price of Memory: "+part.getPrice()+"\n");

                    }
                }
            }else if(choice == 3){
                System.out.print("enter new factor: ");
                factor = input.nextDouble();
                for (Part part: parts){
                    if (part instanceof HardDisk){
                        System.out.println("previous price of HardDisk: "+part.getPrice());
                        PricePolicy pricePolicy = new PricePolicy();
                        pricePolicy.setPrice(factor);
                        part.setPricePolicy(pricePolicy);
                        System.out.println("current price of HardDisk: "+part.getPrice()+"\n");

                    }
                }
            }

        }
        System.out.println("Total Price: "+totalPrice(parts));



    }
    public static double totalPrice(ArrayList<Part> parts){
        double totalPrice = 0;
                for(Part part: parts){
                    totalPrice += part.getPrice();
                }
        return totalPrice;
    }
}
