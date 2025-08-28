/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ch1App;

/**
 *
 * @author HP
 */
public class Student implements Person {

    private String name;
    private String major;
    private double gtade;

    public Student(String name, String major, double gtade) {
        this.name = name;
        this.major = major;
        this.gtade = gtade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getMajor() {
        return major;
    }

    public void setGtade(double gtade) {
        this.gtade = gtade;
    }

    public double getGtade() {
        return gtade;
    }

    @Override
    public String toString() {
        return "Student{" + "name=" + name + ", major=" + major + ", gtade=" + gtade + '}';
    }

}
