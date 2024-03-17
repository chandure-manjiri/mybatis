package mybatis.com.mybatis.Dto;

import lombok.Data;
import mybatis.com.mybatis.Dto.TeacherCreationDto;
import mybatis.com.mybatis.Entity.TeacherEntity;

@Data
public class SubjectCreationDto {
    private String name;
    private TeacherCreationDto teacherCreationDto;
}
