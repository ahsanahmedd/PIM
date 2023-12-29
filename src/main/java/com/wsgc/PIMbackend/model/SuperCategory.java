package com.wsgc.PIMbackend.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@RequestMapping("SuperCategory")
@Table(name = "supercategory")


public class SuperCategory {

    @Column(name = "Name_of_SuperCategory")
    private String categoryname;
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

    public SuperCategory(Long id, String name) {
        this.id = id;
        this.name = name;

    }



    public Long getId() {
        return id;
    }
}
