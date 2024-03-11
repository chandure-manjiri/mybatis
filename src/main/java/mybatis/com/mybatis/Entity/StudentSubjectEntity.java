package mybatis.com.mybatis.Entity;

import lombok.Data;

@Data
public class StudentSubjectEntity {
    private Integer id;
    private Integer stud_id;
    private StudentEntity studentEntity;
    private Integer sub_id;
    private SubjectEntity subjectEntity;
}
