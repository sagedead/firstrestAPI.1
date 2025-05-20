package pl.edu.vistula.RestAPI.Product.API.support;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import pl.edu.vistula.RestAPI.Product.API.support.exception.productnotfoundexception;
import pl.edu.vistula.RestAPI.sharedapiresponse.errormessageresponse;

@ControllerAdvice

public class productexceptionadvisor {

    private static final Logger LOG = LoggerFactory.getLogger(productexceptionadvisor.class);

    @ExceptionHandler(productnotfoundexception.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public errormessageresponse productnotfound(Exception e){
        LOG.error(e.getMessage(), e);
        return new errormessageresponse(e.getLocalizedMessage());
    }
}
