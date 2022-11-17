package edu.eec.pathwork;

/**
 * This class is a part of the package edu.eec.pathwork and the package
 * is a part of the project PathFinding.
 * <p>
 * Semantro/Integrated ICT Pvt. Ltd. Lalitpur, Nepal.
 * https://semantro.com/
 * https://integratedict.com.np/
 * <p>
 * Created by santa on 2022-11-15.
 */
public class Student {

    private int id;

    private String name;

    public Student() {
        this.id = -1;
        this.name = "";
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Student withId(int id) {
        return new Student(id, this.name);
    }

    public Student withName(String name){
        return new Student(this.id, name);
    }

    public static Student empty() {
        return new Student();
    }

}
