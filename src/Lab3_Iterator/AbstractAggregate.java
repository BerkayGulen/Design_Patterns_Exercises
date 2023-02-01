package Lab3_Iterator;

public interface AbstractAggregate {
    int getCount();

    Instruments get(int index);

    void addInstruments(Instruments instrument);

    AbstractIterator createIterator(int iteratorIndex);


}
