package connectdatabase;

import java.util.Scanner;

public class Student {

    private int id;
    private String name;
    private int age;

    public Student() {
    }

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.println("id: ");
        id = sc.nextInt();
        sc.nextLine();
        System.out.println("Name: ");
        name = sc.nextLine();
        System.out.println("Age");
        age = sc.nextInt();
    }

    

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
