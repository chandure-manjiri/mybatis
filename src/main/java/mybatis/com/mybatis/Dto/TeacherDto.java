package mybatis.com.mybatis.Dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import mybatis.com.mybatis.Entity.SubjectEntity;

import java.util.List;

@Data
public class TeacherDto {
    private Integer id;
    private String fullName;
    private String gender;
    private Integer age;
    private String phoneNumber;
    private String email;
    private List<SubjectDto> subjectDtoList;
}
