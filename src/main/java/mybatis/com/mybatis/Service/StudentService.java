package mybatis.com.mybatis.Service;

import mybatis.com.mybatis.Entity.StudentEntity;
import mybatis.com.mybatis.Entity.SubjectEntity;
import mybatis.com.mybatis.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public List<StudentEntity> getAllStudent(){
        return this.studentRepository.getStudents();
    }

    public StudentEntity getStudentById(Integer id){
        return this.studentRepository.getStudentById(id);
    }

    public void postStudent(StudentEntity studentEntity){
        this.studentRepository.insertStudent(studentEntity);
    }

    public void assignSubjectsToStudent( Integer id, List<SubjectEntity> subjectEntityList){
        this.studentRepository.assignSubjectsToStudent(id, subjectEntityList);
    }
}
