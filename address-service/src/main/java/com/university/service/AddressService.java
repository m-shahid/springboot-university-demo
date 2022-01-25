package com.university.service;

import com.university.entity.Address;
import com.university.model.AddressRequest;
import com.university.model.AddressResponse;
import com.university.repository.AddressRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    Logger logger = LoggerFactory.getLogger(AddressService.class);

    @Autowired
    AddressRepository addressRepository;

    public AddressResponse createAddress(AddressRequest request) {

        Address address = new Address();

        address.setCity(request.getCity());
        address.setStreet(request.getStreet());

        addressRepository.save(address);

        return new AddressResponse(address);
    }

    public  AddressResponse getById(long id) {

        Address address = addressRepository.findById(id).get();

        return new AddressResponse(address);

    }

}
