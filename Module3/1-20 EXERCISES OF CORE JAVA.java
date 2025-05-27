// 1. Hello World Program
class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}

// 2. Simple Calculator
import java.util.Scanner;

class SimpleCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        double num1 = sc.nextDouble();
        System.out.print("Enter second number: ");
        double num2 = sc.nextDouble();
        System.out.print("Choose operation (+, -, *, /): ");
        char op = sc.next().charAt(0);
        double result = 0;
        switch (op) {
            case '+': result = num1 + num2; break;
            case '-': result = num1 - num2; break;
            case '*': result = num1 * num2; break;
            case '/': 
                if (num2 != 0) result = num1 / num2;
                else {
                    System.out.println("Division by zero!");
                    return;
                }
                break;
            default: System.out.println("Invalid operation"); return;
        }
        System.out.println("Result: " + result);
    }
}

// 3. Even or Odd Checker
import java.util.Scanner;

class EvenOddChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int num = sc.nextInt();
        if (num % 2 == 0) System.out.println("Even");
        else System.out.println("Odd");
    }
}

// 4. Leap Year Checker
import java.util.Scanner;

class LeapYearChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a year: ");
        int year = sc.nextInt();
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
            System.out.println("Leap Year");
        else
            System.out.println("Not a Leap Year");
    }
}

// 5. Multiplication Table
import java.util.Scanner;

class MultiplicationTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        for (int i = 1; i <= 10; i++) {
            System.out.println(num + " x " + i + " = " + (num * i));
        }
    }
}

// 6. Data Type Demonstration
class DataTypes {
    public static void main(String[] args) {
        int a = 10;
        float b = 3.14f;
        double c = 2.718;
        char d = 'A';
        boolean e = true;
        System.out.println("int: " + a);
        System.out.println("float: " + b);
        System.out.println("double: " + c);
        System.out.println("char: " + d);
        System.out.println("boolean: " + e);
    }
}

// 7. Type Casting Example
class TypeCasting {
    public static void main(String[] args) {
        double d = 9.78;
        int i = (int) d;
        System.out.println("Double to int: " + i);

        int j = 10;
        double e = (double) j;
        System.out.println("Int to double: " + e);
    }
}

// 8. Operator Precedence
class OperatorPrecedence {
    public static void main(String[] args) {
        int result = 10 + 5 * 2;
        System.out.println("Result: " + result); // Multiplication happens before addition
    }
}

// 9. Grade Calculator
import java.util.Scanner;

class GradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter marks (0-100): ");
        int marks = sc.nextInt();
        if (marks >= 90) System.out.println("Grade: A");
        else if (marks >= 80) System.out.println("Grade: B");
        else if (marks >= 70) System.out.println("Grade: C");
        else if (marks >= 60) System.out.println("Grade: D");
        else System.out.println("Grade: F");
    }
}

// 10. Number Guessing Game
import java.util.Scanner;
import java.util.Random;

class NumberGuessingGame {
    public static void main(String[] args) {
        Random rand = new Random();
        int number = rand.nextInt(100) + 1;
        Scanner sc = new Scanner(System.in);
        int guess;
        do {
            System.out.print("Guess the number (1-100): ");
            guess = sc.nextInt();
            if (guess > number) System.out.println("Too high!");
            else if (guess < number) System.out.println("Too low!");
        } while (guess != number);
        System.out.println("Correct!");
    }
}

// 11. Factorial Calculator
import java.util.Scanner;

class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a non-negative integer: ");
        int num = sc.nextInt();
        long fact = 1;
        for (int i = 2; i <= num; i++) {
            fact *= i;
        }
        System.out.println("Factorial: " + fact);
    }
}

// 12. Method Overloading
class MethodOverloading {
    static int add(int a, int b) {
        return a + b;
    }

    static double add(double a, double b) {
        return a + b;
    }

    static int add(int a, int b, int c) {
        return a + b + c;
    }

    public static void main(String[] args) {
        System.out.println(add(5, 10));
        System.out.println(add(2.5, 3.5));
        System.out.println(add(1, 2, 3));
    }
}

// 13. Recursive Fibonacci
import java.util.Scanner;

class RecursiveFibonacci {
    static int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        System.out.println("Fibonacci: " + fibonacci(n));
    }
}

// 14. Array Sum and Average
import java.util.Scanner;

class ArraySumAverage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        int sum = 0;
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + (sum / (double) n));
    }
}

// 15. String Reversal
import java.util.Scanner;

class StringReversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        String reversed = new StringBuilder(str).reverse().toString();
        System.out.println("Reversed: " + reversed);
    }
}

// 16. Palindrome Checker
import java.util.Scanner;

class PalindromeChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine().replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String reversed = new StringBuilder(input).reverse().toString();
        if (input.equals(reversed)) System.out.println("Palindrome");
        else System.out.println("Not a palindrome");
    }
}

// 17. Class and Object Creation
class Car {
    String make, model;
    int year;

    Car(String make, String model, int year) {
        this.make = make; this.model = model; this.year = year;
    }

    void displayDetails() {
        System.out.println(make + " " + model + " (" + year + ")");
    }

    public static void main(String[] args) {
        Car car1 = new Car("Toyota", "Corolla", 2020);
        car1.displayDetails();
    }
}

// 18. Inheritance Example
class Animal {
    void makeSound() {
        System.out.println("Some sound");
    }
}

class Dog extends Animal {
    void makeSound() {
        System.out.println("Bark");
    }

    public static void main(String[] args) {
        Animal a = new Animal();
        Dog d = new Dog();
        a.makeSound();
        d.makeSound();
    }
}

// 19. Interface Implementation
interface Playable {
    void play();
}

class Guitar implements Playable {
    public void play() {
        System.out.println("Strumming Guitar");
    }
}

class Piano implements Playable {
    public void play() {
        System.out.println("Playing Piano");
    }

    public static void main(String[] args) {
        Playable g = new Guitar();
        Playable p = new Piano();
        g.play();
        p.play();
    }
}

// 20. Try-Catch Example
import java.util.Scanner;

class TryCatchExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter numerator: ");
            int a = sc.nextInt();
            System.out.print("Enter denominator: ");
            int b = sc.nextInt();
            int result = a / b;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero!");
        }
    }
}
