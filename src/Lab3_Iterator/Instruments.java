package Lab3_Iterator;

public class Instruments {

    //Fields
    protected String name;
    protected  static int noOfInstruments;

    //*****************************************************************************************************************
    //constructor

    public Instruments(){}
    public Instruments(String name) {
        this.name = name;
        noOfInstruments++;
    }

    //*****************************************************************************************************************
    //Methods

    public void sound(){
        System.out.println("Name: "+getName()+"\n");
    }

    //*****************************************************************************************************************
    //accessors and mutators

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getNoOfInstruments() {
        return noOfInstruments;
    }

    public static void setNoOfInstruments(int noOfInstruments) {
        Instruments.noOfInstruments = noOfInstruments;
    }

}
