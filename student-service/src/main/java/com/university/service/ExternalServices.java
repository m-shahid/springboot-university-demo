package com.university.service;

import com.university.feignclient.GenericFeignClient;
import com.university.model.AddressResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExternalServices {

    private int count = 1;

    Logger logger = LoggerFactory.getLogger(ExternalServices.class);

    @Autowired
    GenericFeignClient feignClient;

    // name must be the same which you have mentioned in properties files
    // e.g resilience4j.circuitbreaker.instances.addressService.sliding-window-size=10
    // in above addressService is used and hence using the same name below
    @CircuitBreaker(name = "addressService", fallbackMethod = "fallbackGetAddressResponse")
    public AddressResponse getAddressResponse(long addressId) {
        logger.info("Count : " + count++);
        return feignClient.getById(addressId);
    }

    public AddressResponse fallbackGetAddressResponse(long addressId, Throwable th) {
        logger.info("GetAddressResponse failed and falling back due to exception : " + th.getMessage());
        return new AddressResponse();
    }
}
