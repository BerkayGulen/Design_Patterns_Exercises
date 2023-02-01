package Lab6_AbstractFactory;

public class BuildProduct {
    private Console console;
    private Joypad joypad;

    public void createProduct(GamingFactory factory) {
        console = (Console) factory.create(0);
        joypad = (Joypad) factory.create(1);
    }

    public void displayProduct() {
        System.out.println("Name: " + console.displayName());
        System.out.println("Price: " + console.getPrice());

        System.out.println("Name: " + joypad.displayName());
        System.out.println("Price: " + joypad.getPrice());

    }
}
