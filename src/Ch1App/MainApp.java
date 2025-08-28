/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ch1App;

/**
 *
 * @author HP
 */
public class MainApp {

    public static void main(String[] args) {
        Double data1[] = {3.0, 4.0, 1.0, 5.0};

        Person persons[] = {
            new Student("Salah", "Engninering", 88),
            new Employee("Abd", "IT", 1000),
            new Student("Ali", "CS", 79.8)
        };
        show(persons);
    }

    public static <T> void show(T data[]) {
        for (T d : data) {
            System.out.println(d);
        }
    }
}
