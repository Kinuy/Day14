package lombok;

import java.util.List;
@Builder
@With
public record University(
        int id,
        String name,
        List<Course> courses,
        List<Student> students
) {
}
