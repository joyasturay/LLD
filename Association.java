import java.util.*;

class Student {
    private String name;
    List<Course> courses;

    public Student(String name) {
        this.name = name;
        courses = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public String getName() {
        return name;
    }

    public void getAllCourses() {
        for (int i = 0; i < courses.size(); i++) {
            System.out.println("Courses are: " + courses.get(i).getCourseName());
        }
    }
}
     class Course {
        String courseName;
        List<Student> students;

        public Course(String courseName) {
            this.courseName = courseName;
            students = new ArrayList<>();
        }
        
        public void addStudent(Student student) {
            students.add(student);
        }

        public String getCourseName() {
            return courseName;
        }
        
        public void getAllEnrolledStudents() {
            for (int i = 0; i < students.size(); i++) {
                System.out.println("Student name: " + students.get(i).getName());
            }
        }

    }
public class Association {
    public static void main(String[] args) {
        Student s1 = new Student("Hello");
        Student s2 = new Student("JO Anna");
        Course cs = new Course("CS");
        Course maths = new Course("Maths");
        cs.addStudent(s2);
        maths.addStudent(s2);
        s2.addCourse(maths);
        s2.addCourse(cs);
         cs.addStudent(s1);
         cs.getAllEnrolledStudents();
         s2.getAllCourses();
    }
}
