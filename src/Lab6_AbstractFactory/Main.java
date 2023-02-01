package Lab6_AbstractFactory;

public class Main {

    public static void main(String[] args) {
	// write your code here
        GamingFactory sony = SonyFactory.getInstanceO();
        GamingFactory nintendo = new NintendoFactory();
        GamingFactory microsoft = new MicrosoftFactory();

        BuildProduct product = new BuildProduct();

        product.createProduct(sony);
        product.displayProduct();

        System.out.println("-------------------------------------------");

        product.createProduct(nintendo);
        product.displayProduct();

        System.out.println("--------------------------------------------");
        product.createProduct(microsoft);
        product.displayProduct();





    }
}
