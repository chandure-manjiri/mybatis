package mybatis.com.mybatis.Service;

import mybatis.com.mybatis.Dto.StudentCreationDto;
import mybatis.com.mybatis.Entity.StudentEntity;
import mybatis.com.mybatis.Entity.SubjectEntity;
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



    public List<StudentEntity> getAllStudent(){
        return this.studentRepository.getStudents();
    }

    public StudentEntity getStudentById(Integer id){
        return this.studentRepository.getStudentById(id);
    }

    public StudentEntity postStudent(StudentCreationDto studentCreationDto){
        StudentEntity studentEntity = this.studentMapper.toEntity(studentCreationDto);
        this.studentRepository.insertStudent(studentEntity);
        return studentEntity;
    }

    public void assignSubjectsToStudent( Integer id, List<SubjectEntity> subjectEntityList){
        this.studentRepository.assignSubjectsToStudent(id, subjectEntityList);
    }
}
