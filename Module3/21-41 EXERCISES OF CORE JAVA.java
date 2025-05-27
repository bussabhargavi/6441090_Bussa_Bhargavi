// Exercise 21: Custom Exception
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class CustomExceptionExample {
    public static void main(String[] args) {
        int age = 16;
        try {
            if (age < 18)
                throw new InvalidAgeException("Age must be at least 18.");
            System.out.println("Valid age: " + age);
        } catch (InvalidAgeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

// Exercise 22: File Writing
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class FileWriteExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string to write to file: ");
        String input = sc.nextLine();

        try (FileWriter writer = new FileWriter("output.txt")) {
            writer.write(input);
            System.out.println("Data written to output.txt.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// Exercise 23: File Reading
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class FileReadExample {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("output.txt"))) {
            String line;
            while ((line = reader.readLine()) != null)
                System.out.println(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// Exercise 24: ArrayList Example
import java.util.ArrayList;
import java.util.Scanner;

class ArrayListExample {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter student names (type 'end' to finish):");
        while (true) {
            String name = sc.nextLine();
            if (name.equalsIgnoreCase("end")) break;
            names.add(name);
        }
        System.out.println("Students: " + names);
    }
}

// Exercise 25: HashMap Example
import java.util.HashMap;
import java.util.Scanner;

class HashMapExample {
    public static void main(String[] args) {
        HashMap<Integer, String> students = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter student ID and name (type -1 to stop):");
        while (true) {
            int id = sc.nextInt();
            if (id == -1) break;
            sc.nextLine(); // consume newline
            String name = sc.nextLine();
            students.put(id, name);
        }

        System.out.print("Enter ID to lookup: ");
        int searchId = sc.nextInt();
        System.out.println("Name: " + students.getOrDefault(searchId, "Not found"));
    }
}

// Exercise 26: Thread Creation
class MyThread extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++)
            System.out.println(Thread.currentThread().getName() + ": message " + i);
    }
}

class ThreadExample {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        t1.start();
        t2.start();
    }
}

// Exercise 27: Lambda Expressions
import java.util.*;

class LambdaSort {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Banana", "Apple", "Cherry", "Mango");
        Collections.sort(list, (a, b) -> a.compareTo(b));
        System.out.println("Sorted list: " + list);
    }
}

// Exercise 28: Stream API
import java.util.*;
import java.util.stream.Collectors;

class StreamExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 15, 20, 25, 30);
        List<Integer> evens = numbers.stream()
                                     .filter(n -> n % 2 == 0)
                                     .collect(Collectors.toList());
        System.out.println("Even numbers: " + evens);
    }
}

// Exercise 29: Records (Java 16+)
record Person(String name, int age) {}

class RecordExample {
    public static void main(String[] args) {
        List<Person> people = List.of(new Person("Alice", 22), new Person("Bob", 30));
        people.stream()
              .filter(p -> p.age() > 25)
              .forEach(System.out::println);
    }
}

// Exercise 30: Pattern Matching for switch (Java 21)
class PatternSwitchExample {
    public static void checkType(Object obj) {
        switch (obj) {
            case Integer i -> System.out.println("Integer: " + i);
            case String s -> System.out.println("String: " + s);
            case Double d -> System.out.println("Double: " + d);
            default -> System.out.println("Other type");
        }
    }

    public static void main(String[] args) {
        checkType(42);
        checkType("Hello");
        checkType(3.14);
    }
}

// Exercise 31: Basic JDBC Connection
import java.sql.*;

class JDBCBasic {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:students.db";
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM students")) {

            while (rs.next()) {
                System.out.println("Name: " + rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

// Exercise 32: Insert and Update Operations in JDBC
class StudentDAO {
    Connection conn;

    StudentDAO() throws SQLException {
        conn = DriverManager.getConnection("jdbc:sqlite:students.db");
    }

    void insertStudent(int id, String name) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("INSERT INTO students(id, name) VALUES(?, ?)");
        ps.setInt(1, id);
        ps.setString(2, name);
        ps.executeUpdate();
    }

    void updateStudent(int id, String newName) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("UPDATE students SET name=? WHERE id=?");
        ps.setString(1, newName);
        ps.setInt(2, id);
        ps.executeUpdate();
    }
}

// Exercise 33: Transaction Handling in JDBC
class TransactionExample {
    public static void main(String[] args) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:sqlite:bank.db");
        try {
            conn.setAutoCommit(false);

            PreparedStatement debit = conn.prepareStatement("UPDATE accounts SET balance = balance - ? WHERE id = ?");
            PreparedStatement credit = conn.prepareStatement("UPDATE accounts SET balance = balance + ? WHERE id = ?");

            debit.setInt(1, 100);
            debit.setInt(2, 1);
            credit.setInt(1, 100);
            credit.setInt(2, 2);

            debit.executeUpdate();
            credit.executeUpdate();
            conn.commit();
            System.out.println("Transaction Successful");
        } catch (SQLException e) {
            conn.rollback();
            System.out.println("Transaction Failed, Rolled Back");
        }
    }
}

// Exercise 34: Java Modules

module-info.java in com.utils:
module com.utils {
    exports com.utils;
}

module-info.java in com.greetings:
module com.greetings {
    requires com.utils;
}

// Exercise 35: TCP Client-Server Chat

// Server
import java.net.*;
import java.io.*;

class ChatServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(1234);
        System.out.println("Server started. Waiting for client...");
        Socket socket = server.accept();
        System.out.println("Client connected.");
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
        output.println("Hello from server!");
        System.out.println("Client says: " + input.readLine());
        socket.close();
        server.close();
    }
}

// Client
class ChatClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 1234);
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
        System.out.println("Server says: " + input.readLine());
        output.println("Hi Server!");
        socket.close();
    }
}

// Exercise 36: HTTP Client API
import java.net.URI;
import java.net.http.*;

class HTTPExample {
    public static void main(String[] args) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest req = HttpRequest.newBuilder()
                                     .uri(URI.create("https://api.github.com"))
                                     .build();

        HttpResponse<String> res = client.send(req, HttpResponse.BodyHandlers.ofString());
        System.out.println("Status: " + res.statusCode());
        System.out.println("Body: " + res.body());
    }
}

// Exercise 37: Using javap

Demo.java:
public class Demo {
    public static int square(int x) {
        return x * x;
    }

    public static void main(String[] args) {
        System.out.println(square(5));
    }
}

Command to Compile and Inspect:
javac Demo.java
javap -c Demo

Sample Output (bytecode):
Compiled from "Demo.java"
public class Demo {
  public Demo();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public static int square(int);
    Code:
       0: iload_0
       1: iload_0
       2: imul
       3: ireturn

  public static void main(java.lang.String[]);
    Code:
       0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
       3: iconst_5
       4: invokestatic  #3                  // Method square:(I)I
       7: invokevirtual #4                  // Method java/io/PrintStream.println:(I)V
      10: return
}

// Exercise 38: Decompile

Steps:
Write a simple program like:
public class Hello {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}
Compile:
javac Hello.java
Use a decompiler like:
JD-GUI
CFR
Sample CFR usage:
sh
Copy
Edit
java -jar cfr.jar Hello.class

// Exercise 39: Reflection
import java.lang.reflect.*;

class ReflectionExample {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("java.util.ArrayList");
        Method[] methods = clazz.getDeclaredMethods();
        for (Method m : methods) {
            System.out.println(m.getName());
        }
    }
}

// Exercise 40: Virtual Threads (Java 21)
class VirtualThreads {
    public static void main(String[] args) {
        for (int i = 0; i < 100_000; i++) {
            Thread.startVirtualThread(() -> System.out.println("Hello from virtual thread"));
        }
    }
}

// Exercise 41: Executor Service and Callable
import java.util.concurrent.*;
import java.util.*;

class CallableExample {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        List<Callable<String>> tasks = List.of(
            () -> "Task 1",
            () -> "Task 2",
            () -> "Task 3"
        );

        List<Future<String>> results = executor.invokeAll(tasks);
        for (Future<String> f : results) {
            System.out.println(f.get());
        }

        executor.shutdown();
    }
}
