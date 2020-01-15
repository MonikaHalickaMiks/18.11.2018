package pl.sda.Recive;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class Paragon {

    public static final int PRINTER_LENGTH = 40;

    public static void main(String[] args) {
//nr1
        printCanter("SDA SHOP SPÓŁKA Z O.O.");
        printCanter("UL. SZKOLENIOWA 5/22 00-036 WARSZAWA");
        printCanter("SKLEP SDA JAVALUB");
        printCanter("UL. SKLEPOWA 6/17 20-011 LUBLIN");
        printCanter("TEL: 560-234-234 JAVALUB@SDASHOP.COM");
        printCanter("NIP 523-645-31-53");
        printJustyfy(LocalDate.now().toString(), "1456");


        separator();
        printCanter("Paragon fiskalny");
        printJustyfy("Nazwa   ilosc x cena", " Wartosc    ptu");
        separator();

//zad5
        String[] productName = {
                "Komputer Osobisty",
                "Montaż, transport i instalacja komputera osobistego",
                "Szkolenie w zakresie obsługi komputera",
                "Płyn chłodniczy do komputera"
        };

        double[] productPrice = {3999.99, 50, 1499.89, 14.99};

        String[] productUnit = {"szt", "usł", "usł", "kg"};

        double[] productQuantity = {3, 3, 1, 2.5};

        String[] productTax = {"A", "B", "B", "D"};


        DecimalFormat priceFormat = new DecimalFormat("#.00");
        DecimalFormat quantityFormat = new DecimalFormat("#.##");


        for (int i = 0; i < productName.length; i++) { //wyswietla po kolei z pierwszej tablicy
            printLeft(productName[i]);
        /*     System.out.println(productQuantity[i] + productUnit[i] + "x" + productPrice[i] + "   " + productQuantity[i]*productPrice[i] + "   " + productTax[i] );

            separator();

*/
            double quantity = productQuantity[i];
            String unit = productUnit[i];
            double price = productPrice[i];
            String tax = productTax[i];

            String firstPart = "     " + quantityFormat.format(quantity) + "  " + unit + " x " + priceFormat.format(price);


            double value = quantity * price;
            String secondPart = priceFormat.format(value) + "  " + tax;
            printJustyfy(firstPart, secondPart);

        }
        separator();

        double sumTax = 0;

        sumTax += printTax(productPrice, productQuantity, productTax, priceFormat, "A", 0.23);
        sumTax += printTax(productPrice, productQuantity, productTax, priceFormat, "B", 0.08);
        sumTax += printTax(productPrice, productQuantity, productTax, priceFormat, "C", 0.00);
        sumTax += printTax(productPrice, productQuantity, productTax, priceFormat, "D", 0.05);

        printJustyfy("Suma PTU", priceFormat.format(sumTax));
        separator();


        double sumValue = 0;
        for (int i = 0; i < productPrice.length; i++) {
            sumValue += productPrice[i] * productQuantity[i];

        }
        printJustyfy("Suma PLN", priceFormat.format(sumValue));
        separator();

        String hour = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        printJustyfy("Godzina", hour);

        printCanter("Numer Kontrolny");
        printCanter("#" + UUID.randomUUID().toString() + "#");
        printCanter("BHH 1234568");

        printJustyfy("gotówka", priceFormat.format(sumValue));


    }

    private static double printTax(double[] productPrice, double[] productQuantity, String[] productTax, DecimalFormat priceFormat, String taxCode, double taxPercent) {
        double sumValue = 0;


        for (int i = 0; i < productTax.length; i++) {   // liczymy sume opodatkowania
            if (productTax[i].equals(taxCode)) {
                sumValue += productPrice[i] * productQuantity[i];
            }

        }
        if (sumValue == 0) return 0;

        double tax = sumValue * taxPercent;

        String firstPart = "Sp. op." + taxCode + "  " + priceFormat.format(sumValue) + " PTU " + (taxPercent * 100) + "%";  //obliczamy
        String secondPart = priceFormat.format(tax);
        printJustyfy(firstPart, secondPart);

        return tax;
    }


    //nr2


    private static void printCanter(String string) {


        int stringLenght = string.length();
        int printerLength = PRINTER_LENGTH; // tu =40 zamienilismy za pom. ctr alt + c  do stalej

        int spaceLeft = PRINTER_LENGTH - stringLenght;
        int spaceCount = spaceLeft / 2;

        printSpacees(spaceCount);
        System.out.println(string.toUpperCase());


    }

    // metoda która dodalam za pom ctr alt M do metody powstala mowa metoda a nasze for zaostalo zamienione na
    private static void printSpacees(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
        }
    }

   /*
   // wytównuje do prawej

   public static void main(String[] args) {

       printRight("SDA SHOP SPÓŁKA Z O.O.");
       printRight("UL. SZKOLENIOWA 5/22 00-036 WARSZAWA");
       printRight("SKLEP SDA JAVALUB");
       printRight("UL. SKLEPOWA 6/17 20-011 LUBLIN");
       printRight("TEL: 560-234-234 JAVALUB@SDASHOP.COM");
       printRight("NIP 523-645-31-53");
       printRight(LocalDate.now() + "               1456");


    }*/


    private static void printRighr(String string) {


        int stringLenght = string.length();


        int spaceLeft = PRINTER_LENGTH - stringLenght;
        int spaceCount = spaceLeft;

        for (int i = 0; i < spaceCount; i++) {
            System.out.print(" ");
        }
        System.out.println(string.toUpperCase());

    }


    //wytownuje do lewej


    private static void printLeft(String string) {
        System.out.println(trim(string));
    }

    //zad 7
    private static String trim(String string) {
        if (string.length() > PRINTER_LENGTH) {
            String trimedString = string.substring(0, PRINTER_LENGTH - 3) + "...";
            return trimedString.toUpperCase();

        } else {
            return string.toUpperCase();
        }
    }


    //zad3

    private static void printJustyfy(String string1, String string2) {

        int spaceLeft = PRINTER_LENGTH - string1.length() - string2.length();
        System.out.print(string1.toUpperCase());
        printSpacees(spaceLeft);
        System.out.println(string2.toUpperCase());

    }


//zad4

    private static void separator() {

        for (int i = 0; i < PRINTER_LENGTH; i++) {
            System.out.print("-");

        }

        System.out.println();
    }


}
