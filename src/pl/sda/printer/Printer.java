package pl.sda.printer;

public class Printer {
    public static final int PRINTER_LENGTH = 40;


    public static void printCanter(String string) {


        int stringLenght = string.length();
        int printerLength = PRINTER_LENGTH; // tu =40 zamienilismy za pom. ctr alt + c  do stalej

        int spaceLeft = PRINTER_LENGTH - stringLenght;
        int spaceCount = spaceLeft / 2;

        printSpacees(spaceCount);
        System.out.println(string.toUpperCase());


    }

    public static void printJustyfy(String string1, String string2) {

        int spaceLeft = PRINTER_LENGTH - string1.length() - string2.length();
        System.out.print(string1.toUpperCase());
        printSpacees(spaceLeft);
        System.out.println(string2.toUpperCase());

    }

    public static void printRighr(String string) {

        int stringLenght = string.length();


        int spaceLeft = PRINTER_LENGTH - stringLenght;
        int spaceCount = spaceLeft;

        for (int i = 0; i < spaceCount; i++) {
            System.out.print(" ");
        }
        System.out.println(string.toUpperCase());

    }

    public static void printLeft(String string) {
        System.out.println(trim(string));
    }

    private static String trim(String string) {
        if (string.length() > PRINTER_LENGTH) {
            String trimedString = string.substring(0, PRINTER_LENGTH - 3) + "...";
            return trimedString.toUpperCase();

        } else {
            return string.toUpperCase();
        }
    }

    public static void separator() {

        for (int i = 0; i < PRINTER_LENGTH; i++) {
            System.out.print("-");
        }
    }

    private static void printSpacees(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
        }

    }
}