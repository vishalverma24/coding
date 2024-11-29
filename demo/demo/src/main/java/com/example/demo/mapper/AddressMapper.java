//package com.example.demo.mapper;
//
//import com.example.demo.dto.AddressDTO;
//import com.example.demo.model.Address;
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//
//import java.util.List;
//
//@Mapper(componentModel = "spring")
//public interface AddressMapper {
//
//    @Mapping(source = "employee.id", target = "employeeId")
//    @Mapping(source = "employee.name", target = "employeeName")
//    AddressDTO toAddressDTO(Address address);
//
//    @Mapping(source = "employeeId", target = "employee.id")
//    @Mapping(source = "employeeName", target = "employee.name")
//    @Mapping(target = "id", ignore = true)
//    Address toAddress(AddressDTO addressDTO);
//
//    List<AddressDTO> toAddressDTOList(List<Address> addresses);
//
//    List<Address> toAddressList(List<AddressDTO> addressDTOs);
//}
