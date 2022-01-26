package com.university.feignclient;

import com.university.model.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "api-gateway")
public interface GenericFeignClient {

    @GetMapping("address-service/api/address/get/{id}")
    public AddressResponse getById(@PathVariable long id);

}
