package Lab4_Composite;

import java.util.ArrayList;

public class CompositeElement implements MovieElement{

    private String name;
    private ArrayList<MovieElement> movieElements = new ArrayList<>();


    public CompositeElement(String name) {
        this.name = name;
    }


    public void add(MovieElement movieElement){
        this.movieElements.add(movieElement);
    }

    public void remove(MovieElement movieElement){
        this.movieElements.remove(movieElement);
    }


    @Override
    public void display(int indent) {
        for (int i = 1; i <= indent; i++) System.out.print("-");
        System.out.println("+ " + getName());

        // Display each child element on this node
        for (int i = 0; i < movieElements.size(); i++) {
            movieElements.get(i).display(indent + 2);
        }
    }

    @Override
    public String getName() {
        return this.name;
    }

}
