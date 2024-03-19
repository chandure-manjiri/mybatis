package mybatis.com.mybatis.ManagementDto;

import lombok.Data;

import java.util.List;
@Data
public class MessOwnerCreationDto {
    private String fullName;
    private Integer age;
    private String gender;
    private String contactNumber;
    private Integer messId;
}
