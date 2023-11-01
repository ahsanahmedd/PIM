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
@Table(name = "supercategory")
public class SuperCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "Name")
    private String name;
    @Column(name = "SEO_copy")
    private String SeoCopy;
    @Column(name = "Description")
    private String description;


    @OneToMany(targetEntity = Category.class, mappedBy = "id", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    List<Category> Category;

    public Long getId() {
        return id;
    }
}
