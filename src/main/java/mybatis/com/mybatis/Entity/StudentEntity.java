package mybatis.com.mybatis.Entity;

import lombok.*;

import java.util.List;
@Data
public class StudentEntity {
    private Integer id;
    private String firstName;
    private String lastName;
    private String gender;
    private Integer age;
    private List<SubjectEntity> subjectEntities;
}
