<<<<<<< HEAD
package mybatis.com.mybatis.Dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import mybatis.com.mybatis.Entity.TeacherEntity;

@Data
public class SubjectCreationDto {
    private String name;
    private TeacherCreationDto TeacherCreationDto;
=======
package mybatis.com.mybatis.Dto;public class SubjectCreationDto {
>>>>>>> 9a94f47 (changed in mapper xml file for getting entity after saving to database in same query)
}
