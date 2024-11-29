package edu.uptc.example.entityes;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Product")
public class product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false, length = 20)
    private String name;
    @Column(nullable = false, length = 20)
    private int stock;

    @ManyToMany(mappedBy = "products")
    private List<sale> sales;

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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public List<sale> getSales() {
        return sales;
    }

    public void setSales(List<sale> sales) {
        this.sales = sales;
    }
}
