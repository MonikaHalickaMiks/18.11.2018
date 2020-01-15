package pl.sda.Recive;

import pl.sda.entity.*;
import pl.sda.printer.HeaderPrinter;
import pl.sda.printer.Printer;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class ParagomMain2 {



    public static void main(String[] args) {
        Company company = new Company("SDA SHOP SPÓŁKA Z O.O.", "UL. SZKOLENIOWA 5/22", "Warszawa", "00-036");
        Shop shop = new Shop("SKLEP SDA JAVALUB", "UL. SKLEPOWA 6/17 20-011 LUBLIN", "TEL: 560-234-234", "JAVALUB@SDASHOP.COM","NIP 523-645-31-53", company );

        Printer printer = new Printer();

       new HeaderPrinter(printer).print(shop);

        printer.printCanter("Paragon fiskalny");
        printer.printJustyfy("Nazwa   ilosc x cena", " Wartosc    ptu");
        printer.separator();

        Product komputer_osobisty = new Product("Komputer Osobisty",3999.99, TaxCode.A, Unit.PIECE );
        Product montaż = new Product( "Montaż, transport i instalacja komputera osobistego", 50, TaxCode.B, Unit.SERVICE);
        Product szkolenie = new Product("Szkolenie w zakresie obsługi komputera", 1499.89, TaxCode.B, Unit.SERVICE );
        Product płyn = new Product("Płyn chłodniczy do komputera", 14.99, TaxCode.D, Unit.KILOGRAM);

        ReciptPosition[] positions = {
             new ReciptPosition(komputer_osobisty, 3),
             new ReciptPosition(montaż, 3),
             new ReciptPosition(szkolenie, 1),
             new ReciptPosition(płyn, 2.5)
        };

        DecimalFormat priceFormat = new DecimalFormat("#.00");
        DecimalFormat quantityFormat = new DecimalFormat("#.##");

        for (ReciptPosition position : positions) {
            printer.printLeft(position.getProduct().getName());
        /*     System.out.println(productQuantity[i] + productUnit[i] + "x" + productPrice[i] + "   " + productQuantity[i]*productPrice[i] + "   " + productTax[i] );

            separator();
*/
            double quantity = position.getQuantity();
            String unit = position.getProduct().getUnit().getSymbol();
            double price = position.getProduct().getPrice();
            String tax = position.getProduct().getTaxCode().name();  //name - to nazwa enama np. 23%

            String firstPart = "     " + quantityFormat.format(quantity) + "  " + unit + " x " + priceFormat.format(price);

            double value = position.sumarize();
            String secondPart = priceFormat.format(value) + "  " + tax;
            printer.printJustyfy(firstPart, secondPart);
        }
        printer.separator();

        double sumTax = 0;

        sumTax += printTax(positions, priceFormat, TaxCode.A, printer);
        sumTax += printTax(positions, priceFormat, TaxCode.B, printer);
        sumTax += printTax(positions, priceFormat, TaxCode.C, printer);
        sumTax += printTax(positions, priceFormat, TaxCode.D, printer);

        printer.printJustyfy("Suma PTU", priceFormat.format(sumTax));
        printer.separator();

        double sumValue = 0;
        for (ReciptPosition position : positions) {
            sumValue += position.sumarize();

        }
        printer.printJustyfy("Suma PLN", priceFormat.format(sumValue));
        printer.separator();

        String hour = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        printer.printJustyfy("Godzina", hour);

        printer.printCanter("Numer Kontrolny");
        printer.printCanter("#" + UUID.randomUUID().toString() + "#");
        printer.printCanter("BHH 1234568");

        printer.printJustyfy("gotówka", priceFormat.format(sumValue));
    }

    private static double printTax(ReciptPosition[] positions, DecimalFormat priceFormat,TaxCode taxCode, Printer printer) {
        double sumValue = 0;

        for (ReciptPosition position : positions) {

            if (position.getProduct().getTaxCode().equals(taxCode)) {
                sumValue += position.sumarize();
            }
        }
        if (sumValue == 0) return 0;

        double tax = taxCode.calculateTax(sumValue);

        String firstPart = "Sp. op." + taxCode + "  " + priceFormat.format(sumValue) + " PTU " + taxCode.getPercentTax();  //obliczamy
        String secondPart = priceFormat.format(tax);
        printer.printJustyfy(firstPart, secondPart);

        return tax;
    }




}
