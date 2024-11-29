//package com.example.demo.mapper;
//
//import com.example.demo.dto.AddressDTO;
//import com.example.demo.dto.EmployeeDTO;
//import com.example.demo.model.Address;
//import com.example.demo.model.Employee;
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//import org.mapstruct.factory.Mappers;
//
//import java.util.List;
//
//@Mapper(componentModel = "spring", uses = AddressMapper.class)
//public interface EmployeeMapper {
//
//    @Mapping(source = "addresses", target = "addresses")
//    EmployeeDTO toEmployeeDTO(Employee employee);
//
//    @Mapping(source = "addresses", target = "addresses")
//    Employee toEmployee(EmployeeDTO employeeDTO);
//
//    List<EmployeeDTO> toEmployeeDTOList(List<Employee> employees);
//
//    List<Employee> toEmployeeList(List<EmployeeDTO> employeeDTOs);
//}
