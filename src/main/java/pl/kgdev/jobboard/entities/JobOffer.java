package pl.kgdev.jobboard.entities;

import javax.persistence.*;

@Entity
public class JobOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @ManyToOne
    private Category category;
    @ManyToOne
    private City city;
    private String content;
    private String company_name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;
    private double Salary;

    public JobOffer() {
    }

    public JobOffer(String name, Category category, City city, String content, String company_name, User user, double salary) {
        this.name = name;
        this.category = category;
        this.city = city;
        this.content = content;
        this.company_name = company_name;
        this.user = user;
        Salary = salary;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getSalary() {
        return Salary;
    }

    public void setSalary(double salary) {
        Salary = salary;
    }

    @Override
    public String toString() {
        return "JobOffer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", city=" + city +
                ", content='" + content + '\'' +
                ", company_name='" + company_name + '\'' +
                ", user=" + user +
                ", Salary=" + Salary +
                '}';
    }
}
