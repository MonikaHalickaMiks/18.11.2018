package pl.sda.entity;

public enum Unit {
    KILOGRAM("kg"),
    PIECE("szt"),
    SERVICE("usł");

private  final String symbol;
    Unit(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }


}
