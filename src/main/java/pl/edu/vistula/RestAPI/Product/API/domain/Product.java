package pl.edu.vistula.RestAPI.Product.API.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "Products")

public class Product {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    public Product(String name) { this.name = name;  }

    public Long getId() { return id; }

    public String getName() { return name; }

    public void setId(long id) { this.id = id; }

    public void setName(String name) { this.name = name; }
}
