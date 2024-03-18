package mybatis.com.mybatis.Dto;

import lombok.Data;
import mybatis.com.mybatis.Entity.SubjectEntity;

import java.util.List;

@Data
public class StudentDto {
    private Integer id;
    private String fullName;
    private String gender;
    private Integer age;
    private List<SubjectDto> subjectDtoList;
}
