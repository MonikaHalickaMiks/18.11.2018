package pl.sda.entity;

public class ReciptPosition {

    private Product product;
    private double quantity;

    public ReciptPosition(Product product, double quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public double getQuantity() {
        return quantity;
    }

    public  double sumarize(){            //ile bedą kosztować produkty za zszt
return product.getPrice() * quantity;
    }
}
