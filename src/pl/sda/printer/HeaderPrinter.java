package pl.sda.printer;

import pl.sda.entity.Shop;

import java.time.LocalDate;

public class HeaderPrinter {

    private Printer printer;

    public HeaderPrinter(Printer printer) {
        this.printer = printer;
    }
    public void print (Shop shop){


     printer.printCanter(shop.getCompany().getNameCompany());
        printer.printCanter(shop.getCompany().getFullAddress());
        printer.printCanter(shop.getName());
        printer.printCanter(shop.getAddress());
        printer.printCanter(shop.getTephone() + " " + shop.getMail());
        printer.printCanter(shop.getNip());
        printer.printJustyfy(LocalDate.now().toString(), "1456");


        printer.separator();
}
  }