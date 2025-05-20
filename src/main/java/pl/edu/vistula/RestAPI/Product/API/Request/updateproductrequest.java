package pl.edu.vistula.RestAPI.Product.API.Request;

import com.fasterxml.jackson.annotation.JsonCreator;


public class updateproductrequest extends productrequest{

    private final Long id;

    @JsonCreator
    public updateproductrequest(String name, Long id){
        super(name);
        this.id = id;
    }
    public Long getId() { return id; }

}

