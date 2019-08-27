package com.example.demo.mapper;

import com.example.demo.entity.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryMapperTest {

    @Autowired
     private ProductCategoryMapper productCategoryMapper;

    @Test
    public void  getAll(){
        List<ProductCategory> all = productCategoryMapper.findAll();
        Assert.assertEquals(1,all.size());
    }

    @Test
    public void  findById(){
        ProductCategory all = productCategoryMapper.findById(1);
        Assert.assertEquals(new Integer(1),all.getId());
    }


    //xml 形式的
    @Test
    public void  selectAll(){
        List<ProductCategory> all = productCategoryMapper.selectAll();
        Assert.assertEquals(1,all.size());
    }

    @Test
    public void  selectById(){
        ProductCategory all = productCategoryMapper.selectById(1);
        Assert.assertEquals(new Integer(1),all.getId());
    }
}