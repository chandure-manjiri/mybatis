package mybatis.com.mybatis.Controller;

import mybatis.com.mybatis.Entity.StudentEntity;
import mybatis.com.mybatis.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping()
    public ResponseEntity< List<StudentEntity>> getStudents(){
        List<StudentEntity> studentEntities = studentRepository.getStudents();
        return new ResponseEntity<>(studentEntities, HttpStatus.OK);
    }

    @GetMapping("/{id}/subjects")
    public ResponseEntity<StudentEntity> getStudentWithSubjectList(@PathVariable (name = "id") Integer id){
        StudentEntity studentEntity= studentRepository.getSubjectListOfStudent(id);
        return new ResponseEntity<>(studentEntity, HttpStatus.OK);
    }
}
