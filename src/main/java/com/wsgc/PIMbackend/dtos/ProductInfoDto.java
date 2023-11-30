package com.wsgc.PIMbackend.dtos;

import com.wsgc.PIMbackend.model.SuperCategory;
import lombok.Getter;
import lombok.Setter;
import net.bytebuddy.implementation.bind.annotation.Super;

import java.util.List;

@Getter
@Setter
public class ProductInfoDto {
    private String apiDesc;

    private List<SuperCategory> supercategories;


}
