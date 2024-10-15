package lombok;

import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Course {
    int id;
    String name;
    Teacher teacher;
    List<Student> students = new ArrayList<>();
}
