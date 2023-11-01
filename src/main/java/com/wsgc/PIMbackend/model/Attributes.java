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
@Table(name = "Attributes")
public class Attributes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AttributesID")
    private Long id;
    @Column(name = "Name")
    private String name;
    @Column(name = "SEO_copy")
    private String SeoCopy;
    @Column(name = "Description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "Product_ID")
    private Product product;

    @OneToMany(targetEntity = Swatch.class, mappedBy = "id", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    List<Swatch> Swatch ;



    // Getter and Setter methods
}

