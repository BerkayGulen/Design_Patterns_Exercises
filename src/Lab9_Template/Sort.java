package Lab9_Template;

import java.util.Scanner;

public abstract class Sort {
    private Scanner input = new Scanner(System.in);
    protected int arr[] = new int[5];
    protected int index = 0;

    protected void sort() {
        getInput();
        sortingAlgorithm();
        display();
    }

    public void sortingAlgorithm() {
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (compare(arr[i], arr[j])) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }


    public void getInput() {
        while (true) {
            try {
                System.out.print("Enter Number: ");
                int x = input.nextInt();
                arr[index] = x;
                index++;
                if (checkInput() == false) continue;
                break;
            } catch (Exception e) {
                System.out.println("Max Number Of Array Size!!!");
                break;
            }

        }

    }

    public abstract boolean compare(int x, int y);


    public boolean checkInput() {
        if (arr[index - 1] < 0) {
            arr[index - 1] = 0;
            return true;
        }
        return false;
    }

    public void display() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }

}
