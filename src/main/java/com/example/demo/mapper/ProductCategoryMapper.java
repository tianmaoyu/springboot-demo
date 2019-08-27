package com.example.demo.mapper;

import com.example.demo.entity.ProductCategory;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductCategoryMapper {

    @Select("select * from product_category where id=#{id} ")
    ProductCategory findById(Integer id);

    @Select("select * from product_category ")
    @Results({
            @Result(column = "coulumn1",property = "property1"),
            @Result(column = "coulumn2",property = "property2"),
    })
   List<ProductCategory>  findAll();


    List<ProductCategory>  selectAll();

    ProductCategory selectById(Integer id);
}
