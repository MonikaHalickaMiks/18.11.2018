package pl.sda.entity;

public class Shop {

    private String name;
    private String address;
    private String tephone;
    private String mail;
    private String nip;
    private Company company;

    public Shop(String name, String address, String tephone, String mail, String nip, Company company) {
        this.name = name;
        this.address = address;
        this.tephone = tephone;
        this.mail = mail;
        this.nip = nip;
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getTephone() {
        return tephone;
    }

    public String getMail() {
        return mail;
    }

    public String getNip() {
        return nip;
    }

    public Company getCompany() {
        return company;
    }
}
