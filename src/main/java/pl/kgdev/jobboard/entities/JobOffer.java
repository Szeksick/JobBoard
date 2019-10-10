package pl.kgdev.jobboard.entities;

import javax.persistence.*;

@Entity
public class JobOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
//    @ManyToOne
    private Long id_category;
//    @ManyToOne
    private Long id_city;
    private String content;
    private String company_name;
//    @ManyToOne
    private Long id_user;
    private double Salary;

    public JobOffer(String name, Long id_category, Long id_city, String content, String company_name, Long id_user, double salary) {
        this.name = name;
        this.id_category = id_category;
        this.id_city = id_city;
        this.content = content;
        this.company_name = company_name;
        this.id_user = id_user;
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

    public Long getId_category() {
        return id_category;
    }

    public void setId_category(Long id_category) {
        this.id_category = id_category;
    }

    public Long getId_city() {
        return id_city;
    }

    public void setId_city(Long id_city) {
        this.id_city = id_city;
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

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
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
                ", id_category=" + id_category +
                ", id_city=" + id_city +
                ", content='" + content + '\'' +
                '}';
    }
}
