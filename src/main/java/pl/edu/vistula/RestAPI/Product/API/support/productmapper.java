package pl.edu.vistula.RestAPI.Product.API.support;

import pl.edu.vistula.RestAPI.Product.API.Request.productrequest;
import org.springframework.stereotype.Component;
import pl.edu.vistula.RestAPI.Product.API.Request.updateproductrequest;
import pl.edu.vistula.RestAPI.Product.API.domain.Product;
import pl.edu.vistula.RestAPI.Product.API.response.productresponse;

@Component
public class productmapper {

    public Product toproduct(productrequest productRequest){
        return new Product(productRequest.getName());
    }

    public Product toProduct(Product product, updateproductrequest updateproductrequest){
        product.setName(updateproductrequest.getName());
        return product;
    }

    public productresponse toproductresponse (Product product){
        return new productresponse(product.getId(), product.getName());
    }
}
