package lombok;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
import static jdk.internal.classfile.impl.DirectCodeBuilder.build;
*/

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        /*
        *
        Step 1: Add the Lombok dependency to your project and configure IntelliJ to support Lombok.

        Step 2: Create a simple class "Student" with the following attributes: id, name, address, grade.

        Step 2.5: Use the appropriate Lombok annotations to generate getters, setters, equals, hashCode, toString, and constructors for the entity.

        Step 3: Create a Teacher record with the following attributes: id, name, subject.

        Step 4: Create a class Course with the following attributes: id, name, teacher, students.

        Step 4.5: Use the appropriate Lombok annotations to generate getters, setters, equals, hashCode, toString, and constructors for the entity.

        Step 5: Write a "Main" class where you apply some examples of creating Students, Teachers, and Courses using the constructors.

        Step 6: In the "Main" class, check if the generated Lombok methods work correctly (getter, setter, toString, ...).
        *
        *
        *
        *
        Step 1: Add the Builder pattern to all entities and create additional objects with the Builder in the main method.
        Step 2: Use the With annotation to facilitate changing properties.

        Bonus:
        *
        Find out what the Lombok annotation @Value does and use it for the Course class.

        Create a record University with the following attributes: id, name, courses.

        Create a class UniversityService and implement the following methods there:

        Write a function to calculate the average grade of a Course (Pass the Course as a parameter).

        Write a function to calculate the average grade of the entire University (Pass a University object as a parameter).

        Write a function that retrieves all students from a University with a minimum grade of 2/"Good" and returns them as a list (Pass a University object as a parameter).
        *
*
        * */


        Course course = new Course();
        course.setName("Java");
        course.setId(1);
        course.setTeacher(new Teacher(1,"Peter","Math"));
        course.students.add(new Student(1,"Hans","Lincolnstraße 12",6));
        course.setStudents(course.students);
        System.out.println(course);
        System.out.println(course.getTeacher());

        Course course2 = Course.builder()
                .id(2)
                .name("Lombok")
                .students(course.students)
                .teacher(new Teacher(2,"Klaus","Bio"))
                .build();

        Teacher teacher1 = Teacher.builder()
                .id(1)
                .name("Paul")
                .subject("Bio")
                .build();

        Teacher teacher2 = Teacher.builder()
                .id(2)
                .name("Kay")
                .subject("Geo")
                .build();

        Teacher teacher3 = teacher1.withSubject("Math");
        System.out.println(teacher3);

        System.out.println(course2);



        // Bonus

        // create some students , teachers, courses
        createStudents();
        createCourses(createStudents());

        // create a university
        University university = University.builder()
                .courses(createCourses(createStudents()))
                .students(createStudents())
                .build();



        UniversityService universityService = UniversityService.builder().build();
        universityService.calcAverageGradeOfCourse(course2);
        universityService.calcAverageGradeOfUniversity(university);
        universityService.filterStudentsByGrade(university);
    }

    public static List<Student> createStudents() {
        List<Student> students = new ArrayList<>();
        String[] names = {"Paul","Marie","Lea","Carl","Ben"};
        int[] ids = {1,2,3,4,5};
        String[] adresses = {"SchnellStraße 1","SchnellStraße 2","SchnellStraße 3","SchnellStraße 4","SchnellStraße 5"};
        int[] grades = {1,4,7,2,3};
        for(int i = 0; i < names.length; i++) {
            students.add(Student.builder()
                    .id(ids[i])
                    .name(names[i])
                    .address(adresses[i])
                    .grade(grades[i])
                    .build());
        }
        return students;
    }
    public static List<Course> createCourses(List<Student> students) {
        List<Course> courses = new ArrayList<>();

        int[] ids = {1,2,3,4,5};
        String[] names = {"Math","Bio","Geo","Sport","Art"};
        String[] nameTeacher = {"Paul","Lars","Emma","Olaf","Paulina"};

        Collections.shuffle(students);
        List<Student> shuffledStudents = students.subList(0, 2);

        for(int i = 0; i < names.length; i++) {
            courses.add(Course.builder()
                    .id(ids[i])
                    .name(names[i])
                    .teacher(Teacher.builder()
                            .id(i)
                            .name(nameTeacher[i])
                            .subject(names[i])
                            .build())
                    .students(shuffledStudents)
                    .build());
        }
        return courses;
    }
}