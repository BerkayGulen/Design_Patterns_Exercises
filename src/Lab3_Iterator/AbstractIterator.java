package Lab3_Iterator;

public interface AbstractIterator {
    void first();

    void next();

    Boolean isDone();

    Instruments currentItem();

    void showModelInfo2(AbstractIterator abstractIterator);
}
