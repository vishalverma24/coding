package com.example.demo.service;

import com.example.demo.model.Address;
import com.example.demo.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private EmployeeService employeeService;

//    @Autowired
//    private AddressMapper addressMapper;

    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
//        return addressMapper.toAddressDTOList(addresses);
    }
    public List<Address> getAddressByEmployeeId(Long id) {
        return addressRepository.findByEmployee_Id(id);
//        return (addresses!=null) ? addressMapper.toAddressDTOList(addresses) : null;
    }

    public Address saveAddress(Address address) {

        return addressRepository.save(address);
    }
}
