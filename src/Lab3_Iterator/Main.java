package Lab3_Iterator;

public class Main {

    public static void main(String[] args) {
        AbstractAggregate aggregate = new Orchestra();

        aggregate.addInstruments(new Brass("Bras"));
        aggregate.addInstruments(new Keyboards("Keyboard"));
        aggregate.addInstruments(new Strings("Strings"));

        AbstractIterator abstractIterator = aggregate.createIterator(1);
        abstractIterator.showModelInfo2(abstractIterator);

    }
}
