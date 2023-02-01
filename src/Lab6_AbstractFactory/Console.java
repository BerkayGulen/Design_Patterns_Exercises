package Lab6_AbstractFactory;

public class Console extends Product {
    protected String name;
    protected double price;

    @Override
    public String displayName() {
        return name;
    }

    @Override
    double getPrice() {
        return price;
    }
}

class SonyConsole extends Console{

    public SonyConsole(double price){
        this.name = new String("PS5");
        this.price = price;
    }

}

class NintendoConsole extends Console{

    public NintendoConsole(double price){
        this.name = "Switch";
        this.price = price;
    }
}

class MicrosoftConsole extends Console{

    public MicrosoftConsole(double price){
        this.name = new String("XBox One");
        this.price = price;
    }

}