package mybatis.com.mybatis.Entity;

import lombok.Data;

@Data
public class TeacherEntity {
    private Integer id;
    private String firstName;
    private String lastName;
    private String gender;
    private Integer age;
    private String phoneNumber;
    private String email;
    private SubjectEntity subjectEntity;
}
