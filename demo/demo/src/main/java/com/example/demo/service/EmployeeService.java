package com.example.demo.service;


import com.example.demo.exception.EmployeeAlreadyExistsException;
import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.model.Address;
import com.example.demo.model.Employee;
import com.example.demo.repository.AddressRepository;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

//    @Autowired
//    private EmployeeMapper employeeMapper;
//
//    @Autowired
//    private AddressMapper addressMapper;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private AddressRepository addressRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
//        return employeeMapper.toEmployeeDTOList(employees);
    }

    public Employee getEmployeeById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isEmpty()){
            throw new EmployeeNotFoundException("Employee with id number : " + id + " doesn't exist");
        } else {
//            return employeeMapper.toEmployeeDTO(employee.get());
            return employee.get();
        }
    }

    public Employee saveEmployee(Employee employeeDTO) {
        if(ObjectUtils.isEmpty(employeeDTO.getId())){
            Employee savedEmployee = employeeRepository.save(employeeDTO);
            if(employeeRepository.findById(savedEmployee.getId()).isPresent()){
                return employeeRepository.findById(savedEmployee.getId()).get();
            } else {
                throw new EmployeeNotFoundException("Employee with id number : " + employeeDTO.getId() + " doesn't exist");
            }
        } else {
            throw new EmployeeAlreadyExistsException("Employee with id number :" + employeeDTO.getId() + " already exist");
        }


    }

    public Employee updateEmployee(Employee employee) {

        if(employeeRepository.findById(employee.getId()).isEmpty()){
            throw new EmployeeNotFoundException("Employee with id number : " + employee.getId() + " doesn't exist");
        }else {
            return employeeRepository.save(employee);
        }
    }

}
