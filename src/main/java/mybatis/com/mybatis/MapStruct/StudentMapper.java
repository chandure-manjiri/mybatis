<<<<<<< HEAD
package mybatis.com.mybatis.MapStruct;
import mybatis.com.mybatis.Dto.StudentCreationDto;
import mybatis.com.mybatis.Dto.StudentDto;
import mybatis.com.mybatis.Dto.StudentDtoForList;
import mybatis.com.mybatis.Dto.StudentDtoForSubject;
import mybatis.com.mybatis.Entity.StudentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

=======
package mybatis.com.mybatis.mapper;

import mybatis.com.mybatis.Dto.StudentCreationDto;
import mybatis.com.mybatis.Dto.StudentDto;
import mybatis.com.mybatis.Entity.StudentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
>>>>>>> 9a94f47 (changed in mapper xml file for getting entity after saving to database in same query)

import java.util.List;

@Mapper(componentModel = "spring", uses = SubjectMapper.class)
public interface StudentMapper {

<<<<<<< HEAD
    @Mapping(target="firstName", expression = "java(convertToFirstName(studentCreationDto))")
    @Mapping(target="lastName", expression = "java(convertToLastName(studentCreationDto))")
=======
    @Mapping(source = "fullName", target="firstName", expression = "java(convertToFirstName(studentCreationDto))")
    @Mapping(source = "fullName", target="firstName", expression = "java(convertToLastName(studentCreationDto))")
>>>>>>> 9a94f47 (changed in mapper xml file for getting entity after saving to database in same query)
    @Mapping(source = "gender", target = "gender")
    @Mapping(source = "age", target = "age")
    StudentEntity toEntity(StudentCreationDto studentCreationDto);

    default String convertToFirstName(StudentCreationDto studentCreationDto){
        if (studentCreationDto.getFullName() == null){
            return null;
        }
        return studentCreationDto.getFullName().substring(0, studentCreationDto.getFullName().indexOf(" "));
    }

<<<<<<< HEAD
    default String convertToLastName(StudentCreationDto studentCreationDto){
        if (studentCreationDto.getFullName() == null){
            return null;
        }
        return studentCreationDto.getFullName().substring(studentCreationDto.getFullName().indexOf(" ") + 1);
    }

    @Mapping(source = "id", target = "id")
    @Mapping(target = "fullName", expression = "java(convertToFullName(studentEntity.getFirstName(), studentEntity.getLastName()))")
    @Mapping(source = "gender", target = "gender")
    @Mapping(source = "age", target = "age")
    @Mapping(source = "subjectEntityList", target = "subjectDtoList")
    StudentDto toDto(StudentEntity studentEntity);

    default String convertToFullName(String firstName, String lastname){
        String fullName = firstName;
        fullName += " ";
        fullName += lastname;
        return  fullName;
    }
    @Mapping(source = "id", target = "id")
    @Mapping(target = "fullName", expression = "java(convertToFullName(studentEntity.getFirstName(), studentEntity.getLastName()))")
    @Mapping(source = "gender", target = "gender")
    @Mapping(source = "age", target = "age")
    StudentDtoForList toStudentDtoForList(StudentEntity studentEntity);
    List<StudentDtoForList> toDtoList(List<StudentEntity> studentEntityList);

    @Mapping(source = "id", target = "id")
    @Mapping(target = "fullName", expression = "java(convertToFullName(studentEntity.getFirstName(), studentEntity.getLastName()))")
    @Mapping(source = "subjectEntityList", target = "subjectDtoList")
    StudentDtoForSubject toDtoForSubject(StudentEntity studentEntity);
=======
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



>>>>>>> 9a94f47 (changed in mapper xml file for getting entity after saving to database in same query)
}
