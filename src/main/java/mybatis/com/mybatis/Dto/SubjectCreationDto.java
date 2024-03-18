package mybatis.com.mybatis.Dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import mybatis.com.mybatis.Entity.TeacherEntity;

@Data
public class SubjectCreationDto {
    private String name;
    private TeacherCreationDto TeacherCreationDto;
}
