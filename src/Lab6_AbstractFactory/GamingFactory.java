package Lab6_AbstractFactory;

public abstract class GamingFactory {
    abstract public Product create(int i);
//    abstract public Console createConsole();
//    abstract public Joypad createJoypad();

}

class SonyFactory extends GamingFactory{
    private static SonyFactory sonyFactory;
    private SonyFactory(){}
    public static SonyFactory getInstanceO(){
        if (sonyFactory == null){
            sonyFactory = new SonyFactory();
        }
        return sonyFactory;
    }

    @Override
    public Product create(int i) {
        if (i == 0){
            return new SonyConsole(10000);
        }
        else if (i == 1){
            return new SonyJoypad(1000);
        }
        return null;
    }

//    @Override
//    public Console createConsole() {
//        return new SonyConsole(10000);
//    }
//
//    @Override
//    public Joypad createJoypad() {
//        return new SonyJoypad(1000);
//    }
}


class NintendoFactory extends GamingFactory{
    @Override
    public Product create(int i) {
        if (i == 0){
            return new NintendoConsole(7000);
        }
        else if (i == 1){
            return new NintendoJoypad(500);
        }
        return null;
    }


//    @Override
//    public Console createConsole() {
//        return new NintendoConsole(7000);
//    }
//
//    @Override
//    public Joypad createJoypad() {
//        return new NintendoJoypad(500);
//    }
}

class MicrosoftFactory extends GamingFactory{
    @Override
    public Product create(int i) {
        if (i == 0){
            return new MicrosoftConsole(5000);
        }
        else if (i == 1){
            return new MicrosoftJoypad(300);
        }
        return null;
    }

//    @Override
//    public Console createConsole() {
//        return new MicrosoftConsole(5000);
//    }
//
//    @Override
//    public Joypad createJoypad() {
//        return new MicrosoftJoypad(300);
//    }
}






