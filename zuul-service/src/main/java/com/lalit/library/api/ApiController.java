package com.lalit.library.api;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ApiController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping(value = "customer/{customerId}" , produces = MediaType.APPLICATION_JSON_VALUE)
    @HystrixCommand(fallbackMethod = "defaultCustomer" , groupKey = "customer" , commandKey = "get-customer")
    public ResponseEntity<?> getCustomer(@PathVariable("customerId") String customerId){
        String url = "http://customer-service/customers/"+customerId;
        String customerResponse = restTemplate.getForObject(url,String.class);
        System.out.println(customerResponse);
        return ResponseEntity.ok(customerResponse);
    }

    public ResponseEntity<?> defaultCustomer(String customerId){
        return new ResponseEntity("{\"error\" : \"customer service is down\"}", HttpStatus.GATEWAY_TIMEOUT);
    }


}
