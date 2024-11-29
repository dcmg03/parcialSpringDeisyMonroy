package edu.uptc.example.entityes;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Customers")
public class customers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false, length = 20)
    private String name;
    @Column(nullable = false, length = 20)
    private String lastName;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<sale> sales;

    public customers() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<sale> getSales() {
        return sales;
    }

    public void setSales(List<sale> sales) {
        this.sales = sales;
    }
}
