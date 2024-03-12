package mybatis.com.mybatis.mapper;

import mybatis.com.mybatis.Dto.StudentCreationDto;
import mybatis.com.mybatis.Dto.StudentDto;
import mybatis.com.mybatis.Entity.StudentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring", uses = SubjectMapper.class)
public interface StudentMapper {

    @Mapping(source = "fullName", target="firstName", expression = "java(convertToFirstName(studentCreationDto))")
    @Mapping(source = "fullName", target="firstName", expression = "java(convertToLastName(studentCreationDto))")
    @Mapping(source = "gender", target = "gender")
    @Mapping(source = "age", target = "age")
    StudentEntity toEntity(StudentCreationDto studentCreationDto);

    default String convertToFirstName(StudentCreationDto studentCreationDto){
        if (studentCreationDto.getFullName() == null){
            return null;
        }
        return studentCreationDto.getFullName().substring(0, studentCreationDto.getFullName().indexOf(" "));
    }

//    default String convertToLastName(StudentCreationDto studentCreationDto){
//        if (studentCreationDto.getFullName() == null){
//            return null;
//        }
//        return studentCreationDto.getFullName().substring(studentCreationDto.getFullName().indexOf(" ") + 1);
//    }

//    @Mapping(source = "id", target = "id")
//    @Mapping(target = "fullName", expression = "java(convertToFullName(studentEntity.getFirstName(), studentEntity.getLastName()))")
//    @Mapping(source = "gender", target = "gender")
//    @Mapping(source = "age", target = "age")
//    @Mapping(source = "subjectEntityList", target = "subjectEntityList")
//    StudentDto toDto(StudentEntity studentEntity);

//    @Named("toFullName")
//    default String convertToFullName(String firstName, String lastname){
//        String fullName = firstName;
//        fullName += " ";
//        fullName += lastname;
//        return  fullName;
//    }

//    List<StudentDto> toDtoList(List<StudentEntity> studentEntityList);



}
