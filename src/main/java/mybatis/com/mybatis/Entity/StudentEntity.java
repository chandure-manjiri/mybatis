package mybatis.com.mybatis.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentEntity {
    private Integer id;
    private String firstName;
    private String lastName;
    private String gender;
    private Integer age;
    private List<SubjectEntity> subjectEntityList;
}
