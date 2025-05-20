package pl.edu.vistula.RestAPI.Product.API.response;

import pl.edu.vistula.RestAPI.Product.API.support.productexceptionsupplier;

public class productresponse {

    private final Long id;
    private final String name;

    public productresponse(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
