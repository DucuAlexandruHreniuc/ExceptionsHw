import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class Student implements Comparable<Student> {
    public static void addStudent(Student student) {
        studentList.add(student);
        if (student.age < 18) {
            studentList.remove(student);
            try {
               throw new RuntimeException("\nCannot add student!\nStudent " + student.firstName + " " + student.lastName + " is under 18 years old.");

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        if (student.firstName.isEmpty() || student.lastName.isEmpty() || student.cnp.isEmpty() || student.dateOfBirth.isEmpty()) {
            studentList.remove(student);
            try {
                throw new RuntimeException("\nCannot add student!\nAt least one field is empty.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (student.age >= 122) {
            studentList.remove(student);
            try {
                throw new RuntimeException("\nCannot add a student that was born in 1900 or earlier!");
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    String firstName;
    String lastName;
    String dateOfBirth;
    String cnp;
    Gender gender;
    int age;

    public Student(String firstName, String lastName, String dateOfBirth, Gender gender, String cnp) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.cnp = cnp;
        age = ageCalc();
    }

    public int ageCalc() {
        this.dateOfBirth = String.valueOf(dateOfBirth);
        LocalDate dob = LocalDate.parse(dateOfBirth);
        LocalDate curDate = LocalDate.now();
        Period period = Period.between(dob, curDate);
        int result = period.getYears();
        //System.out.printf("Your age is %d years %d months and %d days.", period.getYears(), period.getMonths(), period.getDays());
        return result;
    }

    @Override
    public String toString() {
        return "\nFirst name: " + firstName + "\nLast name: " + lastName + "\nDate of birth: " + dateOfBirth + "\nGender: " + gender + "\nCNP: " + cnp + "\nAge: " + age;
    }

    static Set<Student> studentList = new TreeSet<>();

    @Override
    public int compareTo(Student otherStudent) {
        if (age > otherStudent.age) {
            return 1;
        }
        if (age < otherStudent.age) {
            return -1;
        }
//        if (cnp == otherStudent.cnp){
//                throw new RuntimeException("There can't be two persons with the same CNP");
//        }
        return lastName.compareTo(otherStudent.lastName);
    }

    public static void listStudentsByDateOfBirth() {
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    public static void listAllStudentsByAge(int age) {
        System.out.println("\nAll the students with the age of " + age + " are:\n");
        for (Student student : studentList) {
            if (student.age == age) {
                System.out.println(student);
            }
        }

    }
    public static void deleteStudentByCnp(String cnp) {
        Iterator<Student> iterator = studentList.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.cnp.equals(cnp)) {
                iterator.remove();
                System.out.println("Student " + student.firstName + " " + student.lastName + " has been deleted successfully");
            }
            }
        }
    }
