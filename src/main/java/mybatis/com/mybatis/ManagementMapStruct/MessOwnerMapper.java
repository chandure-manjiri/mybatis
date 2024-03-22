package mybatis.com.mybatis.ManagementMapStruct;

import mybatis.com.mybatis.Dto.StudentCreationDto;
import mybatis.com.mybatis.ManagementDto.*;
import mybatis.com.mybatis.ManagementEntity.HostelEntity;
import mybatis.com.mybatis.ManagementEntity.MessEntity;
import mybatis.com.mybatis.ManagementEntity.MessOwnerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MessOwnerMapper {
//    private Integer id;
//    private String firstName;
//    private String lastName;
//    private Integer age;
//    private String gender;
//    private String contactNumber;
//    private Integer messId;
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "firstName", expression = "java(convertToFirstName(messOwnerCreationDto))")
    @Mapping(target = "lastName", expression = "java(convertToLastName(messOwnerCreationDto))")
    @Mapping(target = "age", source = "age")
    @Mapping(target = "gender", source = "gender")
    @Mapping(target = "contactNumber", source = "contactNumber")
    @Mapping(target = "messId", source = "messId")
    MessOwnerEntity toEntity(MessOwnerCreationDto messOwnerCreationDto);
    default String convertToFirstName(MessOwnerCreationDto messOwnerCreationDto){
        if (messOwnerCreationDto.getFullName() == null){
            return null;
        }
        return messOwnerCreationDto.getFullName().substring(0, messOwnerCreationDto.getFullName().indexOf(" "));
    }
    default String convertToLastName(MessOwnerCreationDto messOwnerCreationDto){
        if (messOwnerCreationDto.getFullName() == null){
            return null;
        }
        return messOwnerCreationDto.getFullName().substring(messOwnerCreationDto.getFullName().indexOf(" ") + 1);
    }
    @Mapping(target = "id", source = "id")
    @Mapping(target = "fullName", expression = "java(convertToFullName(messOwnerEntity.getFirstName(), messOwnerEntity.getLastName()))")
    @Mapping(target = "age", source = "age")
    @Mapping(target = "gender", source = "gender")
    @Mapping(target = "contactNumber", source = "contactNumber")
    @Mapping(target = "messId", source = "messId")
    MessOwnerDto toDto(MessOwnerEntity messOwnerEntity);

    default String convertToFullName(String firstName, String lastname){
        String fullName = firstName;
        fullName += " ";
        fullName += lastname;
        return  fullName;
    }
    List<MessOwnerDto> toDtoList(List<MessOwnerEntity> messOwnerEntities);
}
