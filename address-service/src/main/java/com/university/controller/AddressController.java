package com.university.controller;

import com.university.model.AddressRequest;
import com.university.model.AddressResponse;
import com.university.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    @Autowired
    AddressService addressService;

    @Value("${qa.url}")
    String qaUrl;

    @PostMapping("/create")
    public AddressResponse createAddress(@RequestBody AddressRequest request) {
        return addressService.createAddress(request);
    }

    @GetMapping("/get/{id}")
    public AddressResponse getById(@PathVariable long id) {
        return addressService.getById(id);
    }

    @GetMapping("/get/url")
    public String testConfigProfile() {
        return qaUrl;
    }

}
