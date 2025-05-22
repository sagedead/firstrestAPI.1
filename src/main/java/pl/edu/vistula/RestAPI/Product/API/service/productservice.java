package pl.edu.vistula.RestAPI.Product.API.service;

import org.springframework.stereotype.Service;
import pl.edu.vistula.RestAPI.Product.API.Request.productrequest;
import pl.edu.vistula.RestAPI.Product.API.Request.updateproductrequest;
import pl.edu.vistula.RestAPI.Product.API.domain.Product;
import pl.edu.vistula.RestAPI.Product.API.repository.productrepository;
import pl.edu.vistula.RestAPI.Product.API.response.productresponse;
import pl.edu.vistula.RestAPI.Product.API.support.productexceptionsupplier;
import pl.edu.vistula.RestAPI.Product.API.support.productmapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class productservice {

    private final productrepository productRepository;
    private final productmapper productMapper;

    public productservice(productrepository productRepository, productmapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public productresponse create(productrequest productRequest){
        Product product = productMapper.toproduct(productRequest);
        Product saved = productRepository.save(product);
        return productMapper.toproductresponse(saved);
    }

    public productresponse update(Long id, updateproductrequest updateproductrequest) {
        Product existing = productRepository.findById(id)
                .orElseThrow(productexceptionsupplier.productNotFound(id));

        Product updated = productMapper.toProduct(existing, updateproductrequest);
        Product saved = productRepository.save(updated);

        return productMapper.toproductresponse(saved);
    }

    public productresponse find(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(productexceptionsupplier.productNotFound(id));
        return productMapper.toproductresponse(product);
    }

    public List<productresponse> findAll() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::toproductresponse)
                .collect(Collectors.toList());
    }

    public void delete(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(productexceptionsupplier.productNotFound(id));
        productRepository.deleteById(product.getId());
    }
}
