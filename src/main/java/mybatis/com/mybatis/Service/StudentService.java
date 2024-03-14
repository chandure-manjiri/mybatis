package mybatis.com.mybatis.Service;

import mybatis.com.mybatis.Dto.*;
import mybatis.com.mybatis.Entity.StudentEntity;
import mybatis.com.mybatis.Entity.SubjectEntity;
import mybatis.com.mybatis.MapStruct.SubjectMapper;
import mybatis.com.mybatis.Repository.StudentRepository;
import mybatis.com.mybatis.MapStruct.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentMapper studentMapper;

    @Autowired
    SubjectMapper subjectMapper;

    public List<StudentDtoForList> getAllStudent(){
        List<StudentEntity> studentEntityList =  this.studentRepository.findAllStudents();
        return this.studentMapper.toDtoList(studentEntityList);
    }


    public StudentDtoForSubject getStudentById(Integer id){
        StudentEntity studentEntity = this.studentRepository.findStudentById(id);
        return this.studentMapper.toDtoForSubject(studentEntity);
   }

    public StudentDto postStudent(StudentCreationDto studentCreationDto){
        StudentEntity studentEntity = this.studentMapper.toEntity(studentCreationDto);
       this.studentRepository.addStudent(studentEntity);
        return this.studentMapper.toDto(studentEntity);
    }

    public StudentDto assignSubjectsToStudent( Integer id, List<SubjectDto> subjectDtoList){
        List<SubjectEntity> subjectEntityList = this.subjectMapper.toEntityList(subjectDtoList);
        this.studentRepository.assignSubjectsToStudent(id, subjectEntityList);
        StudentEntity studentEntity = this.studentRepository.findStudentById(id);
        return this.studentMapper.toDto(studentEntity);
    }
}
