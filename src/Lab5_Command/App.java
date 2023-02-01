package Lab5_Command;

import java.util.Locale;
import java.util.Scanner;
import java.util.ArrayList;

public class App {
}

interface Command {
    public void execute();

    public void unExecute();
}

interface Document {
    public void copy();

    public void paste();

    public void delete();
}

class ExcelCopy implements Command {

    private ExcelDocument excelDocument;

    public ExcelCopy(ExcelDocument excelDocument) {
        this.excelDocument = excelDocument;
    }

    @Override
    public void execute() {
        this.excelDocument.copy();
    }

    @Override
    public void unExecute() {

    }
}

class ExcelCopyAndPaste implements Command {
    private ExcelCopy excelCopy;
    private ExcelPaste excelPaste;

    public ExcelCopyAndPaste(ExcelCopy excelCopy, ExcelPaste excelPaste) {
        this.excelCopy = excelCopy;
        this.excelPaste = excelPaste;
    }

    @Override
    public void execute() {
        this.excelCopy.execute();
        this.excelPaste.execute();
    }

    @Override
    public void unExecute() {

    }
}

class ExcelDelete implements Command {
    ExcelDocument excelDocument;

    public ExcelDelete(ExcelDocument excelDocument) {
        this.excelDocument = excelDocument;
    }

    @Override
    public void execute() {
        excelDocument.delete();
    }

    @Override
    public void unExecute() {

    }
}

class ExcelDocument implements Document {
    private String text = "";

    @Override
    public void copy() {
        System.out.println("EXCEL");
        Scanner input = new Scanner(System.in);
        System.out.print("Enter text: ");
        this.text = input.next();

    }

    @Override
    public void paste() {
        System.out.println("EXCEL");
        System.out.println("Text is: " + this.text);
    }

    @Override
    public void delete() {
        this.text = "";
    }
}

class ExcelPaste implements Command {

    private ExcelDocument excelDocument;

    public ExcelPaste(ExcelDocument excelDocument) {
        this.excelDocument = excelDocument;
    }

    @Override
    public void execute() {
        this.excelDocument.paste();
    }

    @Override
    public void unExecute() {

    }
}

class MenuItem {
    private Command command;

    public MenuItem(Command command) {
        this.command = command;
    }

    public void click() {
        this.command.execute();
    }
}

class WordCopy implements Command {

    private WordDocument wordDocument;
    private String storedText = "";

    public WordCopy(WordDocument wordDocument) {
        this.wordDocument = wordDocument;
    }

    @Override
    public void execute() {
        this.wordDocument.copy();
        this.storedText = wordDocument.getText();
    }

    @Override
    public void unExecute() {
        wordDocument.setText(this.storedText);
    }

}

class WordCopyAndPaste implements Command {
    private WordCopy wordCopy;
    private WordPaste wordPaste;

    public WordCopyAndPaste(WordCopy wordCopy, WordPaste wordPaste) {
        this.wordCopy = wordCopy;
        this.wordPaste = wordPaste;
    }

    @Override
    public void execute() {
        this.wordCopy.execute();
        this.wordPaste.execute();
    }

    @Override
    public void unExecute() {

    }
}

class WordDelete implements Command {
    private WordDocument wordDocument;

    public WordDelete(WordDocument wordDocument) {
        this.wordDocument = wordDocument;
    }


    @Override
    public void execute() {
        wordDocument.delete();
    }

    @Override
    public void unExecute() {

    }
}

class WordDocument implements Document {
    private String text = "";

    @Override
    public void copy() {
        System.out.println("WORD");
        Scanner input = new Scanner(System.in);
        System.out.print("Enter text: ");
        this.text = input.next();
    }

    @Override
    public void paste() {
        System.out.println("WORD");
        System.out.println("Text is: " + this.text);
    }

    @Override
    public void delete() {
       setText("");
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

class WordPaste implements Command {

    private WordDocument wordDocument;

    public WordPaste(WordDocument wordDocument) {
        this.wordDocument = wordDocument;
    }

    @Override
    public void execute() {
        this.wordDocument.paste();
    }

    @Override
    public void unExecute() {

    }
}

class FrameWork {
     WordDocument wordDocument;
     ExcelDocument excelDocument;
     ArrayList<Command> commands = new ArrayList<>();
     static int status = 0;


    public void create(String extension, int Op) {
        if (extension.equals("doc")) {
            if (wordDocument == null) wordDocument = new WordDocument();
            if (status == 0) {
                wordDocument = new WordDocument();
                status++;
            }
            switch (Op) {
                case 1: {
                    WordCopy wordCopy = new WordCopy(wordDocument);
                    wordCopy.unExecute();
                    commands.add(wordCopy);
                    getUserToClick(new MenuItem(wordCopy));
                    break;
                }
                case 2: {
                    WordPaste wordPaste = new WordPaste(wordDocument);
                    getUserToClick(new MenuItem(wordPaste));
                    break;
                }
                case 3: {
                    WordCopyAndPaste copyAndPaste = new WordCopyAndPaste(new WordCopy(wordDocument), new WordPaste(wordDocument));
                    getUserToClick(new MenuItem(copyAndPaste));
                    break;
                }
                case 4: {
                    WordDelete wordDelete = new WordDelete(wordDocument);
                    getUserToClick(new MenuItem(wordDelete));
                    break;
                }
                case 5: {
                    userUndoes();
                }

            }
        } else if (extension.equals("xls")) {
            if (excelDocument == null) excelDocument = new ExcelDocument();
            if (status == 0) {
                excelDocument = new ExcelDocument();
                status++;
            }
            switch (Op) {
                case 1: {
                    ExcelCopy excelCopy = new ExcelCopy(excelDocument);
                    getUserToClick(new MenuItem(excelCopy));
                    break;
                }
                case 2: {
                    ExcelPaste excelPaste = new ExcelPaste(excelDocument);
                    getUserToClick(new MenuItem(excelPaste));
                    break;
                }
                case 3: {
                    ExcelCopyAndPaste excelCopyAndPaste = new ExcelCopyAndPaste(new ExcelCopy(excelDocument), new ExcelPaste(excelDocument));
                    getUserToClick(new MenuItem(excelCopyAndPaste));
                    break;
                }
                case 4: {
                    ExcelDelete excelDelete = new ExcelDelete(excelDocument);
                    getUserToClick(new MenuItem(excelDelete));
                    break;
                }
                case 5: {
                    userUndoes();
                }
            }
        }
    }

    public void getUserToClick(MenuItem menuItem) {
        menuItem.click();
    }

    public void userUndoes() {
        commands.get(commands.size()-1).unExecute();
        commands.remove(commands.size()-1);
//        for (Command command : commands) {
//            command.unExecute();
//        }
    }

}

class Main {
//    static int status;
//    static WordDocument wordDocument;
//    static ExcelDocument excelDocument;


    public static void main(String[] args) {
        FrameWork frameWork = new FrameWork();
        Scanner input = new Scanner(System.in);
        String extension = "";
        int operation = 0;
        while (true) {
            FrameWork.status = 0;
            System.out.println("""
                    ******************** MENU ******************** 
                    Extensions: 'doc','xls'
                    '-1': to terminate       
                    """);
            System.out.print("Enter extension: ");
            extension = input.next();
            if (extension.equals("-1")) System.exit(0);
            else if (extension.toLowerCase(Locale.ROOT).equals("doc") || extension.toLowerCase(Locale.ROOT).equals("xls")) {
                while (true) {

                    System.out.println("""
                              Operations: 
                            '1': Copy
                            '2': Paste
                            '3': Copy and Paste
                            '4': Delete
                            '5': Undo
                            '-1' exit and print the operations
                            """);
                    System.out.print("Enter Operation: ");
                    if (input.hasNextInt()) {
                        operation = input.nextInt();
//                        create(extension, operation);
                        frameWork.create(extension, operation);

                        if (operation == -1) break;
                    } else {
                        System.out.println("Enter Valid Operation!!!");
                    }
                }
            } else {
                System.out.println("Enter valid Document Type!!!");
            }
        }
    }
}


//
//    public static void create(String extension, int Op) {
//        if (extension.equals("doc")) {
//            if (wordDocument == null) wordDocument = new WordDocument();
//            if (status == 0) {
//                wordDocument = new WordDocument();
//                status++;
//            }
//            switch (Op) {
//                case 1: {
//                    WordCopy wordCopy = new WordCopy(wordDocument);
//                    getUserToClick(new MenuItem(wordCopy));
//                    break;
//                }
//                case 2: {
//                    WordPaste wordPaste = new WordPaste(wordDocument);
//                    getUserToClick(new MenuItem(wordPaste));
//                    break;
//                }
//                case 3: {
//                    WordCopyAndPaste copyAndPaste = new WordCopyAndPaste(new WordCopy(wordDocument), new WordPaste(wordDocument));
//                    getUserToClick(new MenuItem(copyAndPaste));
//                    break;
//                }
//                default: {
//                    System.out.println("Enter Valid Operation!!!");
//                }
//
//            }
//        } else if (extension.equals("xls")) {
//            if (excelDocument == null) excelDocument = new ExcelDocument();
//            if (status == 0) {
//                excelDocument = new ExcelDocument();
//                status++;
//            }
//            switch (Op) {
//                case 1: {
//                    ExcelCopy excelCopy = new ExcelCopy(excelDocument);
//                    getUserToClick(new MenuItem(excelCopy));
//                    break;
//                }
//                case 2: {
//                    ExcelPaste excelPaste = new ExcelPaste(excelDocument);
//                    getUserToClick(new MenuItem(excelPaste));
//                    break;
//                }
//                case 3: {
//                    ExcelCopyAndPaste excelCopyAndPaste = new ExcelCopyAndPaste(new ExcelCopy(excelDocument), new ExcelPaste(excelDocument));
//                    getUserToClick(new MenuItem(excelCopyAndPaste));
//                    break;
//                }
//                case 4:{
//
//                }
//                default: {
//                    System.out.println("Enter Valid Operation!!!");
//                }
//
//            }
//        }
//    }
//
//    public static void getUserToClick(MenuItem menuItem) {
//        menuItem.click();
//    }

















