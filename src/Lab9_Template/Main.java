package Lab9_Template;

public class Main {

    public static void main(String[] args) {



        Sort sort = new AscendingSort();
        Sort sort1 = new DescendingSort();
        Sort sort2 = new AscendingOrderNegative();
        System.out.println("asecnding ");

        sort.sort();
        System.out.println();
        sort1.sort();
        System.out.println();
        sort2.sort();



    }
}
