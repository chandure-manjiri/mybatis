package mybatis.com.mybatis.Dto;

import lombok.Data;

@Data
public class TeacherCreationDto {
    private Integer id;
    private String fullName;
    private String gender;
    private Integer age;
    private String phoneNumber;
    private String email;
}
