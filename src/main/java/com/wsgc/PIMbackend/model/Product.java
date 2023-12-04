package com.wsgc.PIMbackend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductID")
    private Long id;
    @Column(name = "Name")
    private String name;

    @Column(name = "Price")
    private Long price;
    @Column(name = "Stock")
    private Long stock;
    @Column(name = "Swatches")
    private String swatches;
    @Column(name = "Attribute")
    private String attribute;
    @Column(name = "SEO_copy")
    private String seoCopy;
    @Column(name = "Description")
    private String description;
    @Column(name = "SKU")
    private Long sku;


    @ManyToOne
    @JoinColumn(name = "SubCategoryID")
    private SubCategory subCategory;

    @OneToMany(targetEntity = Sku.class, mappedBy = "id", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    List<Sku> Skew;

    @OneToMany(targetEntity = Attributes.class, mappedBy = "id", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    List<Attributes> Attributes;

    public Product(String number, String sampleProduct, double v) {
    }

    public Long getId() {
        return id;
    }


    // Getter and Setter methods
}
