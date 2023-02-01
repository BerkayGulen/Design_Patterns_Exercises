package Lab3_Iterator;//import java.util.Collection;

public class BrassIterator implements AbstractIterator {

    //Fields
    private Orchestra orchestra;
    private int _current;

    //*****************************************************************************************************************
    //constructor

    public BrassIterator(Orchestra orchestra){
        this.orchestra = orchestra;
        this._current = 0;
    }
    public BrassIterator(){}

    //*****************************************************************************************************************
    //Methods

    @Override
    public void first() {
        this._current = 0;
    }

    @Override
    public void next() {
        this._current ++;
    }

    @Override
    public Boolean isDone() {
        return this._current >= orchestra.getCount();
    }

    @Override
    public Instruments currentItem() {
        return (isDone() ? null: orchestra.get(_current));
    }

    @Override
    public void showModelInfo2(AbstractIterator i) {
        System.out.println("Iterating");
        for (i.first(); !i.isDone(); i.next()) {
            if (i.currentItem() instanceof Brass) {
                i.currentItem().sound();
            }
        }
        System.out.println();
    }
}
