package org.example.recursion;

public class Recursion {

    public static void main(String[] args) {
        Integer n = 5;
//        String name = "abc";

        //function calling func
        //recusrion
//        printName(name,n);


        //print n to 1 by backtrack
//        backTrack(number);


        //sum of first N numbers
        Integer sumOfN = sumOfNumbers(n, 0);
//        System.out.println("Sum : " + sumOfN);


        //functional recursion
        //sum of N numbers;
        Integer funcSumOfN = sumOfNumbersFunctional(n);
//        System.out.println("SUM : "+ funcSumOfN);

        //factorial
        Integer factorial = factorialofN(n);
//        System.out.println("factorial : " + factorial);

        //Nth Fibonacci Number
        Integer fib = fibonacci(n);
//        System.out.println("fibo Number : " + fib);


    }

    private static Integer fibonacci(Integer n) {
        if(n<=1) {
            return n;
        } else{
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }

    private static Integer factorialofN(Integer i) {

        if(i==0){
            return 1;
        } else{
            return i*(factorialofN(i-1));
        }
    }

    private static Integer sumOfNumbersFunctional(Integer i) {

        if(i==0){
            return 0;
        } else{
            return i + sumOfNumbersFunctional(i-1);
        }
    }

    private static Integer sumOfNumbers(Integer i, Integer sum) {
        if(i<1){
            return sum;
        } else{
            return sumOfNumbers(i-1,sum + i);
        }
    }

    private static void backTrack(Integer i) {

        if(i<1){
        } else {
            backTrack(i-1);
            System.out.println(i);
        }
    }

    private static void printName(String name, Integer i) {

        if(i>=1){
            System.out.println(name);
            printName(name,i-1);
        } else{
            return;
        }


    }
}
