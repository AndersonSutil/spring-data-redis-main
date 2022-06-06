package com.javatechie.redis.respository;

import com.javatechie.redis.entity.Numero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDao {

    public static final String HASH_KEY = "Product";
    @Autowired
    private RedisTemplate template;

    public Numero save(Numero product){
        template.opsForHash().put(HASH_KEY,product.getNum(),product);
        return product;
    }

    public List<Numero> findAll(){
        return template.opsForHash().values(HASH_KEY);
    }

    public Numero findProductById(int num){
        return (Numero) template.opsForHash().get(HASH_KEY,num);
    }


    public String deleteProduct(int num){
         template.opsForHash().delete(HASH_KEY,num);
        return "num removed !!";
    }
}
