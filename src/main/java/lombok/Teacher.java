package lombok;
@Builder
@With
public record Teacher(
        int id,
        String name,
        String subject
) {
}
