package pl.edu.vistula.RestAPI.Product.API.support.exception;

public class productnotfoundexception extends RuntimeException {
    public productnotfoundexception (Long id){
        super(String.format("Product with %d not found"));
    }


}
