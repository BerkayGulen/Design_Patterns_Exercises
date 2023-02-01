package Lab6_AbstractFactory;

public class Joypad extends Product{

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

class SonyJoypad extends Joypad{
    public SonyJoypad(double price){
        this.name = "PS5 Controller";
        this.price = price;
    }
}

class NintendoJoypad extends Joypad{
    public NintendoJoypad(double price){
        this.name = "JoyCon";
        this.price = price;
    }
}


class MicrosoftJoypad extends Joypad{
    public MicrosoftJoypad(double price){
        this.name = "XBox Controller";
        this.price = price;
    }
}
