package org.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Practice {

    public static void main(String[] args){

        List<Employee> employeeList = new ArrayList<Employee>();

        employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
        employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
        employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
        employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
        employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
        employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
        employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

//        Find out the count of male and female employees present in the organization?

        Map<String,Long> noOfMaleAndFemaleEmployees = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
//        System.out.println(noOfMaleAndFemaleEmployees);

//        Write a program to print the names of all departments in the organization.

        List<String> departments = employeeList.stream().map(Employee::getDepartment).distinct().toList();
//        System.out.println(departments);

//        Find the average age of Male and Female Employees.

        Map<String,Double> avgAge = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingInt(Employee::getAge)));
//        System.out.println(avgAge);

//        Get the Names of employees who joined after 2015.

        List<String> after2015 = employeeList.stream().filter(e -> e.getYearOfJoining()>2015).map(Employee::getName).toList();
//        System.out.println(after2015);

//        Count the number of employees in each department.

        Map<String,Long> noOfEmployeesInDepartment = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));
//        System.out.println(noOfEmployeesInDepartment);

//        Find out the average salary of each department.

        Map<String, Double> avgSalary = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingDouble(Employee::getSalary)));
//        System.out.println(avgSalary);

//        Find out the oldest employee, his/her age and department?

        Employee oldestEmployee = employeeList.stream().max(Comparator.comparingInt(Employee::getAge)).get();



//        System.out.println(oldestEmployee.getName() + ", " +oldestEmployee.getAge());

//        Find out the average and total salary of the organization.

        DoubleSummaryStatistics salary = employeeList.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
//        System.out.println(salary.getAverage() + ", " + salary.getSum());

//        List down the employees of each department.

        Map<String, List<Employee>> listEmployeeDepartment = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
//        System.out.println(listEmployeeDepartment);

//        Find out the highest experienced employees in the organization
        Optional<Employee> max = employeeList.stream().min(Comparator.comparingInt(Employee::getYearOfJoining));
//        System.out.println(max.get().getName());


//        Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years.

        Map<Boolean, List<Employee>> partitionEmployeesByAge=
                employeeList.stream().collect(Collectors.partitioningBy(e -> e.getAge() > 25));

        Set<Map.Entry<Boolean, List<Employee>>> entrySet = partitionEmployeesByAge.entrySet();

//        for (Map.Entry<Boolean, List<Employee>> entry : entrySet)
//        {
//            System.out.println("----------------------------");
//
//            if (entry.getKey())
//            {
//                System.out.println("Employees older than 25 years :");
//            }
//            else
//            {
//                System.out.println("Employees younger than or equal to 25 years :");
//            }
//
//            System.out.println("----------------------------");
//
//            List<Employee> list = entry.getValue();
//
//            for (Employee e : list)
//            {
//                System.out.println(e.getName());
//            }
//        }


//    Sort the List of Employee objects based on salary in Desc order

        List <Employee> employeesSortedList1 = employeeList.stream().sorted((e1,e2)-> (int) (e2.getSalary()-e1.getSalary())).toList();
//        System.out.println("sorted : " + employeesSortedList1.get(0).getSalary() + ", " +employeesSortedList1.get(1).getSalary());

        //Stream

        Stream<Employee> sorted = employeeList.stream().sorted((e1, e2) -> (int) (e2.getSalary() - e1.getSalary()));


//        Fetch the highest-paid male and female employee

        Map<String, Optional<Employee>> maxSalaryMaleAndFemaleEmployee = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));
//        for(Map.Entry<String, Optional<Employee>> entry : maxSalaryMaleAndFemaleEmployee.entrySet()){
//            System.out.println((entry.getKey() + ", " + entry.getValue().get().getSalary()));
//        }


//        Get the highest-paid employee in each department

        Map<String, Optional<Employee>> highestSalaryDepartment = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.maxBy((e1,e2)-> (int) (e2.getSalary()- e1.getSalary()))));
//        for(Map.Entry<String, Optional<Employee>> entry : highestSalaryDepartment.entrySet()){
//            System.out.println((entry.getKey() + ", " + entry.getValue().get().getSalary()));
//        }


        List<String> employee = employeeList.stream().sorted((e1,e2)-> (int) (e2.getAge() - e1.getAge())).map(e->e.getName() + " : " + e.getAge()).toList();
        List<String> employee1 = employeeList.stream().sorted(Comparator.comparingInt(Employee::getAge)).map(e->e.getName() + " : " + e.getAge()).toList();

//        System.out.println(employee);
//
//        System.out.println(employee1);
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        System.out.println(s1);
        System.out.println(s2);
    }







}
