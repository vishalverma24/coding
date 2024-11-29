package org.example;



import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
//        System.out.println("Hello and welcome!");



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


        Integer sumOfAge = employeeList.stream().map(Employee::getAge).mapToInt(n -> n).sum();
        System.out.println(sumOfAge);

        Map<String,Long> noOfMaleFemaleEmp = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
//        System.out.println(noOfMaleFemaleEmp);



        List<String> nameOfAllDepartments = employeeList.stream().map(Employee::getDepartment).distinct().toList();
//        System.out.println(nameOfAllDepartments);


        Map<String,Double> avgAgeEmpGender = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
//        System.out.println(avgAgeEmpGender);


        Optional<Employee> highestSalaryEmp = employeeList.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
//        System.out.println(highestSalaryEmp.get().getName());


        Optional<Employee> fifthHighSalaryEmp = employeeList.stream().sorted(Collections.reverseOrder(Comparator.comparingDouble(e -> e.getSalary()))).distinct().skip(4).findFirst();
//        System.out.println(fifthHighSalaryEmp.get().getName());


        List<Employee> empAfter2015 = employeeList.stream().filter(e -> e.getYearOfJoining()>2015).collect(Collectors.toList());
//        System.out.println(empAfter2015.size());


        Map<String, Long> employeeCountByDepartment = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
//        employeeCountByDepartment.entrySet().stream().forEach(k -> System.out.println(k.getKey() + " : " + k.getValue()));


        Map<String, Double> deptSalaryMap = employeeList.stream().collect(Collectors.groupingBy(e -> e.getDepartment(), Collectors.averagingDouble(e -> e.getSalary())));
//        deptSalaryMap.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).forEach(k -> System.out.println(k.getKey() + " : " + k.getValue()));

        Optional<Employee> youngestInProduct = employeeList.stream().filter(e -> e.getDepartment().equalsIgnoreCase("Product Development")).collect(Collectors.minBy(Comparator.comparingInt(e -> e.getAge())));
//        System.out.println(youngestInProduct.get().getName());


        Optional<Employee> seniorMostEmployeeWrapper = employeeList.stream().sorted(Comparator.comparingInt(Employee::getYearOfJoining)).findFirst();
//        System.out.println(seniorMostEmployeeWrapper.get().getName());


        Map<String, Long> countMaleFemaleEmployeesInSalesMarketing=
                employeeList.stream()
                        .filter(e -> Objects.equals(e.getDepartment(), "Sales And Marketing"))
                        .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
//        System.out.println(countMaleFemaleEmployeesInSalesMarketing);


        DoubleSummaryStatistics employeeSalaryStatistics=
                employeeList.stream().collect(Collectors.summarizingDouble(Employee::getSalary));

//        System.out.println("Average Salary = "+employeeSalaryStatistics.getAverage());

//        System.out.println("Total Salary = "+employeeSalaryStatistics.getSum());


        Map<Boolean, List<Employee>> partitionEmployeesByAge=
                employeeList.stream().collect(Collectors.partitioningBy(e -> e.getAge() > 25));


        Map<String, List<Employee>> deptEmplyoee = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));


        String str = "VishalVerma";

        String rev = str.chars().mapToObj(e -> (char) e).reduce("",(a,b) -> b+a, (x,y) -> y+x).replaceAll(" ","");

        //FIRST UNCOMMON CHARACTER
        Map<Character, Long> mp = str.chars().mapToObj(e -> (char)e).collect(Collectors.groupingBy(e -> e,Collectors.counting()));

//        System.out.println(mp);

//        for(Character c : str.chars().mapToObj(e -> (char) e).toList()){
//            if(mp.get(c) == 1){
//                System.out.println(c);
//                break;
//            }
//        }

//        rev.chars().mapToObj(e -> (char) e).forEach(System.out::println);


        List<List<Integer>> marksByStudents = List.of(
                List.of(60, 70, 80),
                List.of(50, 70, 85),
                List.of(65, 70, 75)
        );


//        System.out.println(marksByStudents.stream().flatMapToInt(s -> s.stream().mapToInt(e -> e)).average());


        User u1 = new User(1, "A", List.of(1));
        User u2 = new User(2, "B", List.of(11,21));
        User u3 = new User(3, "A", List.of(111,22,3));


        List<User> userList = List.of(u1,u2,u3);

//        userList.stream().flatMapToInt(e -> e.getPhone().stream().mapToInt(i -> i)).forEach(System.out::println);


        Map<Integer,Employee> empMap = employeeList.stream().collect(Collectors.toMap(e -> e.getId(),e->e));


        List<Integer> integerList = List.of(1,2,3,4,5,5,3,6);

        Map<Integer, Long> mapCount = integerList.stream().collect(Collectors.groupingBy(e->e,Collectors.counting()));
        System.out.println(mapCount);

        //Print minimum duplicate value
//        System.out.println(integerList.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting())).entrySet().stream().sorted(Map.Entry.comparingByKey()).filter(e -> e.getValue()>1).findFirst().get().getKey());


        LinkedList l = new LinkedList();

        l.insertInLinkedList(l,2);
        l.insertInLinkedList(l,3);
        l.insertInLinkedList(l,4);

        l.printLinkedList(l);

        l.reverseLinkedList(l);

        l.printLinkedList(l);


        l.head.next.next.next = l.head;

//        l.printLinkedList(l);

        System.out.println(l.detectLoop(l));;






    }
}