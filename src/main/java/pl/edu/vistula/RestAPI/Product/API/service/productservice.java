package pl.edu.vistula.RestAPI.Product.API.service;

import org.springframework.stereotype.Service;
import pl.edu.vistula.RestAPI.Product.API.Request.productrequest;
import pl.edu.vistula.RestAPI.Product.API.Request.updateproductrequest;
import pl.edu.vistula.RestAPI.Product.API.domain.Product;
import pl.edu.vistula.RestAPI.Product.API.repository.oldproductrepository;
import pl.edu.vistula.RestAPI.Product.API.response.productresponse;
import pl.edu.vistula.RestAPI.Product.API.support.productexceptionsupplier;
import pl.edu.vistula.RestAPI.Product.API.support.productmapper;
import java.util.List;


import java.util.stream.Collectors;

@Service
public class productservice {

    private final oldproductrepository productRepository;

    private final productmapper productMapper;

    public productservice(oldproductrepository productRepository, productmapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public productresponse create(productrequest productRequest){
        Product product = productRepository.save(productMapper.toproduct(productRequest));
        return productMapper.toproductresponse(product);


    }

    public productresponse update(Long id, updateproductrequest updateproductrequest) {
        Product product = productRepository.findById(id).orElseThrow(productexceptionsupplier.productNotFound(id));
        productRepository.save(productMapper.toProduct(product, updateproductrequest));
        return productMapper.toproductresponse(product);
    }
    public productresponse find(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(productexceptionsupplier.productNotFound(id));
        return productMapper.toproductresponse(product);
    }

    public List<productresponse> findAll() {
        return productRepository.findAll().stream().map(productMapper::toproductresponse).collect(Collectors.toList());
    }

    public void delete(Long id) {
        Product product = productRepository.findById(id).orElseThrow(productexceptionsupplier.productNotFound(id));
        productRepository.deleteById(product.getId());
    }

}
