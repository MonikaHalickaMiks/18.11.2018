package pl.sda.entity;

public class Company {

    private String nameCompany;
    private String adressCompany;
    private String codeCompany;
    private String cityCompany;

    public Company(String nameCompany, String adressCompany, String codeCompany, String cityCompany) {
        this.nameCompany = nameCompany;
        this.adressCompany = adressCompany;
        this.codeCompany = codeCompany;
        this.cityCompany = cityCompany;
    }


    public String getFullAddress(){
        return adressCompany + " " + codeCompany + " " + cityCompany;
    }


    public String getNameCompany() {
        return nameCompany;
    }

    public String getAdressCompany() {
        return adressCompany;
    }

    public String getCodeCompany() {
        return codeCompany;
    }

    public String getCityCompany() {
        return cityCompany;
    }
}
