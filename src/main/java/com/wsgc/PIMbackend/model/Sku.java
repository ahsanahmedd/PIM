package com.wsgc.PIMbackend.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Sku")
public class Sku {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SkuID")
    private Long id;
//    @Column(name = "Primary")
//    private Boolean isPrimary;

    @Column(name = "Name")
    private String name;

    @Column(name = "Price")
    private Long price;
    @Column(name = "Discount")
    private Long discount;
    @Column(name = "MinimumSellingPrice")
    private Long minimum_selling_price ;
    @Column(name = "MaximumSellingPrice")
    private Long maximum_selling_price ;
    @Column(name = "Stock")
    private Long stock;
    @Column(name = "SEO_copy")
    private String SeoCopy;
    @Column(name = "Colour")
    private String colour;
    @Column(name = "Height")
    private Long height;
    @Column(name = "Width")
    private Long width;
    @Column(name = "Depth")
    private Long depth;
    @Column(name = "Size")
    private Long size;
    @Column(name = "Weight")
    private Long weight;
    @Column(name = "Description")
    private String description;


    @ManyToOne
    @JoinColumn(name = "ProductID")
    private Product product;
}
