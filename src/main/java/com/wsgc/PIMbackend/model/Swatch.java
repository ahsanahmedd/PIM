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
@Table(name = "Swatch")
public class Swatch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SwatchID")
    private Long id;
    @Column(name = "ImageURL")
    private String imageURL;
    @Column(name = "Description")
    private String description;


    @ManyToOne
    @JoinColumn(name = "Attributes_ID")
    private Attributes attributes;

//    @OneToMany(targetEntity = Product.class, mappedBy = "id", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
//    List<Product> Product;



    // Getter and Setter methods
}
