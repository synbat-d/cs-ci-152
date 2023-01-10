package instances;

public class Student implements Comparable<Student> {
    private String name;
    private String lastName;
    private int age;
    private int id;

    public Student(String name, String lastName, int age, int id) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.id = id;
    }

    public void incrimentAge() {
        this.age++;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "{Student first " +
            "name: " + name +
            ", lastName: " + lastName +
            ", age: " + age +
            ", id: " + id + "}";
    }

    @Override
    public int compareTo(Student o) {
        if (this.id > o.getId()) {
            return 1;
        } else if (this.id < o.getId()) {
            return -1;
        } else {
            return 0;
        }
    }
}
