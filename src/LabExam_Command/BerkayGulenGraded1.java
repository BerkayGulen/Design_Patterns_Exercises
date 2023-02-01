package LabExam_Command;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class BerkayGulenGraded1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String userInput;

        //PART 1
        User user = new User(); //create user
        System.out.print("Enter text for part 1: ");
        userInput = input.nextLine();//get user Input

        Manipulator manipulator = new Manipulator(userInput);

        UpperCommand upperCommand = new UpperCommand(manipulator);//Create Upper Command
        user.execute(upperCommand);

        ClearCommand clearCommand = new ClearCommand(manipulator);//Create Clear Command
        user.execute(clearCommand);

        ReverseCommand reverseCommand = new ReverseCommand(manipulator);//Create reverse Command
        user.execute(reverseCommand);

        user.displayCommandHistory();//display command history

        //PART2
        System.out.print("Enter text for part 2: ");
        userInput = input.nextLine();//get user Input for part2

        CompoundManipulationCommend compoundManipulationCommend = new CompoundManipulationCommend();
        manipulator = new Manipulator(userInput);
        upperCommand = new UpperCommand(manipulator);
        clearCommand = new ClearCommand(manipulator);
        reverseCommand = new ReverseCommand(manipulator);


        compoundManipulationCommend.add(clearCommand);
        compoundManipulationCommend.add(reverseCommand);
        compoundManipulationCommend.add(upperCommand);
        user.execute(compoundManipulationCommend);//Execute Macro Command

        compoundManipulationCommend.display();//Display Children of Macro Command


    }
}

interface Command {
    void execute();

    void display();
}

interface AbstractManipulator {
    void reverse();

    void upper();

    void clear();

}

class ReverseCommand implements Command {
    private Manipulator manipulator;

    public ReverseCommand(Manipulator manipulator) {
        this.manipulator = manipulator;
    }

    @Override
    public void execute() {
        this.manipulator.reverse();
    }

    @Override
    public void display() {
        System.out.println("REVERSE COMMAND");

    }
}

class UpperCommand implements Command {
    private Manipulator manipulator;

    public UpperCommand(Manipulator manipulator) {
        this.manipulator = manipulator;
    }

    @Override
    public void execute() {
        this.manipulator.upper();

    }

    @Override
    public void display() {
        System.out.println("UPPER COMMAND");

    }
}

class ClearCommand implements Command {

    private Manipulator manipulator;

    public ClearCommand(Manipulator manipulator) {
        this.manipulator = manipulator;
    }

    @Override
    public void execute() {
        this.manipulator.clear();
    }

    @Override
    public void display() {
        System.out.println("CLEAR COMMAND");
    }
}

class Manipulator implements AbstractManipulator {

    private String text;

    public Manipulator(String text) {
        this.text = text;
    }

    @Override
    public void reverse() {
        System.out.println("Reverse Command is Executing");
        this.text = new StringBuilder(this.text).reverse().toString();
        System.out.println("Reversed text: " + text);
    }

    @Override
    public void upper() {
        System.out.println("Upper Command is Executing");
        this.text = text.toUpperCase(Locale.ROOT);
        System.out.println("Upper text: " + text);
    }

    @Override
    public void clear() {
        System.out.println("Clear Command is Executing");
        this.text = text.replaceAll(" ", "");
        System.out.println("Cleared text: " + text);
    }
}

class CompoundManipulationCommend implements Command {
    private ArrayList<Command> commands = new ArrayList<>();

    public void add(Command command) {
        commands.add(command);
    }

    @Override
    public void execute() {

        for (Command command : commands) {
            command.execute();
        }
    }

    @Override
    public void display() {
        System.out.println("********************** Name Of The Children of Macro Command **********************");
        for (Command command : commands) {
            command.display();
        }

    }
}

class User {
    private ArrayList<Command> commands = new ArrayList<>();

    public void add(Command command) {
        commands.add(command);
    }

    public void execute(Command command) {
        command.execute();
        add(command);
    }

    public void displayCommandHistory() {
        System.out.println("********************** Command History **********************");
        for (Command command : commands) {
            command.display();
        }
    }
}







