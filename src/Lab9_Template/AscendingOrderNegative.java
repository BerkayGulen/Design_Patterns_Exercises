package Lab9_Template;

public class AscendingOrderNegative extends Sort
{
    @Override
    public boolean compare(int x, int y) {
        if (x > y ) return true;
        return false;

    }

    @Override
    public boolean checkInput() {

        if (arr[index - 1] == 0) {
            arr[index - 1] = 0;
            return true;
        }
        if (arr[index -1] > 0){
            System.out.println("Enter Valid Number");
            index --;
        }
        return false;
    }
}
