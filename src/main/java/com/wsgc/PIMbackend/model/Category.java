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
@Table(name = "Category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CategoryID")
    private Long id;
    @Column(name = "Name")
    private String name;
    @Column(name = "SEO_copy")
    private String SeoCopy;
    @Column(name = "Description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "SuperCategoryID")
    private SuperCategory superCategory;

    @OneToMany(targetEntity = SubCategory.class, mappedBy = "id", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    List<SubCategory> SubCategory;

    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    public Long getId() {
        return id;
    }


    // Getter and Setter methods
}
