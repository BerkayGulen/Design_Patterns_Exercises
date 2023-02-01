package Lab3_Iterator;//import java.util.Collection;

public class OrchestraIterator implements AbstractIterator{

    //Fields
    private Orchestra orchestra;
    private int _current;
    //*****************************************************************************************************************
    //constructor

    public OrchestraIterator(Orchestra orchestra){
        this.orchestra = orchestra;
        this._current = 0;
    }
    public OrchestraIterator(){}

    //*****************************************************************************************************************
    //Methods

    @Override
    public void first(){
        _current = orchestra.getCount() - 1;
    }
    @Override
    public void next() {
        this._current --;
    }
    @Override
    public Boolean isDone() {
        return this._current <0 ;
    }
    @Override
    public Instruments currentItem() {
        return (isDone() ? null: orchestra.get(_current));
    }

    @Override
    public  void showModelInfo2(AbstractIterator i) {
        System.out.println("Iterating");

        for (i.first(); !i.isDone(); i.next()) {
            i.currentItem().sound();

        }
        System.out.println();

    }
}
