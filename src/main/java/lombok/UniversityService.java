package lombok;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
@Builder

public class UniversityService {

    public int calcAverageGradeOfCourse(Course course){
        int averageGrade = 0;
        for (Student student : course.students)
        {
            averageGrade += student.getGrade();
        }
        return averageGrade;
    }

    public int calcAverageGradeOfUniversity(University university){
        int averageGrade = 0;
        for(Course course : university.courses()){
            for (Student student : course.students)
            {
                averageGrade += student.getGrade();
            }
        }
        return averageGrade;
    }

    public List<Student> filterStudentsByGrade(University university){
        List<Student> filteredStudentList = new ArrayList<>();
        for(Student student : university.students())
            if(student.getGrade() >= 2){
                filteredStudentList.add(student);
            }
        return filteredStudentList;
    }
}
