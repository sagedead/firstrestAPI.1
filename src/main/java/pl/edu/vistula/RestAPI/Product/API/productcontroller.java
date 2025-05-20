package pl.edu.vistula.RestAPI.Product.API;


import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import pl.edu.vistula.RestAPI.Product.API.Request.productrequest;
import pl.edu.vistula.RestAPI.Product.API.Request.updateproductrequest;
import pl.edu.vistula.RestAPI.Product.API.response.productresponse;
import pl.edu.vistula.RestAPI.Product.API.service.productservice;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class productcontroller {

    private final productservice productservice;

    public productcontroller(productservice productservice) {
        this.productservice = productservice;
    }



    @PostMapping
    @Operation(summary = "create product")
    public ResponseEntity<productresponse> create(@RequestBody productrequest productRequest){
        productresponse productresponse = productservice.create(productRequest);
        return new ResponseEntity<>(productresponse, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation
    public ResponseEntity<productresponse> find(@PathVariable Long id){
        productresponse productresponse = productservice.find (id);
        return ResponseEntity.status(HttpStatus.OK).body(productresponse);
    }

    @PutMapping("/{id}")
    @Operation(summary = "update product")
    public ResponseEntity<productresponse> update (@PathVariable Long id, @RequestBody updateproductrequest updateproductrequest){
        productresponse productresponse = productservice.update(id, updateproductrequest);
        return ResponseEntity.status(HttpStatus.OK).body(productresponse);
    }

    @GetMapping
    @Operation(summary = "find all products")
    public ResponseEntity<List<productresponse>> findAll(){
        List<productresponse> productResponse = productservice.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(productResponse);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete item")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        productservice.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
