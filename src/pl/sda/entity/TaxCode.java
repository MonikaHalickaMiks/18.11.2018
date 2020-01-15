package pl.sda.entity;

public enum TaxCode {

    A(0.23),
    B(0.08),
    C(0.00),
    D(0.05);


    private final double taxAmount;

    TaxCode(double taxAmount) {
        this.taxAmount = taxAmount;
    }

    public double calculateTax(double amount){
        return amount * taxAmount;

    }

    public static void main(String[] args) {
        System.out.println(TaxCode.A.calculateTax(100));
        System.out.println(TaxCode.B.calculateTax(100));
        System.out.println(TaxCode.C.calculateTax(100));
        System.out.println(TaxCode.D.calculateTax(100));

        System.out.println(TaxCode.A.getPercentTax());

    }

    public String getPercentTax(){

        return Double.valueOf(taxAmount * 100).intValue() + "%"; //nie ma kropki  np. 23,0 tylko od razzu 23%


    }



}
