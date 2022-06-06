package com.javatechie.redis;

import com.javatechie.redis.entity.Numero;
import com.javatechie.redis.respository.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/num")
public class SpringDataRedisExampleApplication {
    @Autowired
    private ProductDao dao;

    @PostMapping
    public Numero save(@RequestBody Numero product) {
        return dao.save(product);
    }

    @GetMapping
    public List<Numero> getAllProducts() {
        return dao.findAll();
    }

    @GetMapping("/{num}")
    public Numero findProduct(@PathVariable int num) {
        return dao.findProductById(num);
    }
    @DeleteMapping("/{num}")
    public String remove(@PathVariable int num)   {
    	return dao.deleteProduct(num);
	}


    public static void main(String[] args) {
        SpringApplication.run(SpringDataRedisExampleApplication.class, args);
    }

}
