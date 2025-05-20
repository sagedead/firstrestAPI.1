package pl.edu.vistula.RestAPI.Product.API.support;

import pl.edu.vistula.RestAPI.Product.API.support.exception.productnotfoundexception;
import java.util.function.Supplier;


public class productexceptionsupplier {
    public static Supplier<productnotfoundexception> productNotFound(Long id) {
        return () -> new productnotfoundexception(id);
    }

}
