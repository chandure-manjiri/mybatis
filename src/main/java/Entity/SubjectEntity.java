package Entity;

import lombok.Data;

@Data
public class SubjectEntity {
    private Integer id;
    private String name;
    private Integer teacherId;
    private TeacherEntity teacherEntity;
}
