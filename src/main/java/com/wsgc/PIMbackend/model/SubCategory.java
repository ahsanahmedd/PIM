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
@Table(name = "SubCategory")
public class SubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SubCategoryID")
    private Long id;
    @Column(name = "Name")
    private String name;
    @Column(name = "SEO_copy")
    private String SeoCopy;
    @Column(name = "Description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "Category_ID")
    private Category Category;

    @OneToMany(targetEntity = Product.class, mappedBy = "id", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Product> Product;

    public SubCategory(Long id, String name) {
        this.id = id;
        this.name = name;


        // Getter and Setter methods
    }
}
