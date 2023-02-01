package Lab4_Composite;

public class Main {

    public static void main(String[] args) {

        CompositeElement movies = new CompositeElement("Movies");

        //Action
        CompositeElement action = new CompositeElement("Action");
        //John Wick
        CompositeElement johnWick = new CompositeElement("John Wick");
        johnWick.add(new PrimitiveElement("John Wick 2","John",2012));
        johnWick.add(new PrimitiveElement("John Wick Parabellum","John",2015));
        //James Bond
        CompositeElement jamesBond = new CompositeElement("James Bond");
        jamesBond.add(new PrimitiveElement("Casino Royale","James",2009));
        jamesBond.add(new PrimitiveElement("No Time To Die","James",2011));

        action.add(johnWick);
        action.add(jamesBond);

        movies.add(action);

        movies.display(1);











    }
}
