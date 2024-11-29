package edu.uptc.example.entityes;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Sales")
public class sale {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private customers customer;

    @ManyToMany
    @JoinTable(
            name = "sale_product",
            joinColumns = @JoinColumn(name = "sale_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<product> products;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public customers getCustomer() {
        return customer;
    }

    public void setCustomer(customers customer) {
        this.customer = customer;
    }

    public List<product> getProducts() {
        return products;
    }

    public void setProducts(List<product> products) {
        this.products = products;
    }
    public void addProduct(product product) {
        products.add(product);
    }
}
