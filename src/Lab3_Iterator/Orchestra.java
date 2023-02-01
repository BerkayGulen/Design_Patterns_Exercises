package Lab3_Iterator;

import java.util.ArrayList;

public class Orchestra implements AbstractAggregate {

    //fields
    private String name;
    private ArrayList<Instruments> instruments = new ArrayList<Instruments>();

    //*****************************************************************************************************************
    //constructor
    public Orchestra() {
    }

    public Orchestra(String name, ArrayList<Instruments> instruments) {
        this.name = name;
        this.instruments = instruments;
    }

    //*****************************************************************************************************************
    //Methods
    public AbstractIterator createIterator(int iteratorIndex) {
        if (iteratorIndex == 1) {
            return new OrchestraIterator(this);
        } else if (iteratorIndex == 2) {
            return new BrassIterator(this);
        } else return null;
    }

    public int getCount() {
        return instruments.size();
    }

    public Instruments get(int index) {
        return instruments.get(index);
    }

    public void addInstruments(Instruments instrument) {
        this.instruments.add(instrument);
    }


    public void play() {
        for (Instruments instrument : this.instruments) {
            instrument.sound();
        }
    }


    //*****************************************************************************************************************
    //accessors and mutators
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Instruments> getInstruments() {
        return instruments;
    }

    public void setInstruments(ArrayList<Instruments> instruments) {
        this.instruments = instruments;
    }

}
