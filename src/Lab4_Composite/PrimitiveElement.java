package Lab4_Composite;

//LEAF
public class PrimitiveElement implements MovieElement {

    private String name;
    private String director;
    private int year;

    public PrimitiveElement(String name, String director, int year) {
        this.name = name;
        this.director = director;
        this.year = year;
    }

    @Override
    public void display(int indent) {
        for(int i = 1;i <= indent;i++) 	System.out.print("-");
        System.out.println(" "  + name);
    }

    @Override
    public String getName() {
        return this.name;
    }
}
