package pl.kgdev.jobboard.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String vat;

    @NotNull
    private String street;

    @NotNull
    private String zip;

    @NotNull
    private String websiteUrl;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @NotNull
    @OneToOne
    private User user;

    public Company() {
    }

    public Company(@NotNull String name, @NotNull String vat, @NotNull String street, @NotNull String zip, @NotNull String websiteUrl, @NotNull City city, @NotNull User user) {
        this.name = name;
        this.vat = vat;
        this.street = street;
        this.zip = zip;
        this.websiteUrl = websiteUrl;
        this.city = city;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Company)) return false;
        Company company = (Company) o;
        return Objects.equals(getId(), company.getId()) &&
                Objects.equals(getName(), company.getName()) &&
                Objects.equals(getVat(), company.getVat()) &&
                Objects.equals(getStreet(), company.getStreet()) &&
                Objects.equals(getZip(), company.getZip()) &&
                Objects.equals(getWebsiteUrl(), company.getWebsiteUrl()) &&
                Objects.equals(getCity(), company.getCity()) &&
                Objects.equals(getUser(), company.getUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getVat(), getStreet(), getZip(), getWebsiteUrl(), getCity(), getUser());
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", vat='" + vat + '\'' +
                ", street='" + street + '\'' +
                ", zip='" + zip + '\'' +
                ", websiteUrl='" + websiteUrl + '\'' +
                ", city=" + city +
                ", user=" + user +
                '}';
    }
}
