package mybatis.com.mybatis.Controller;

import mybatis.com.mybatis.Entity.StudentEntity;
import mybatis.com.mybatis.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/students")
    public ResponseEntity< List<StudentEntity>> getStudents(){
        List<StudentEntity> studentEntities = studentRepository.getStudents();
//        String n = "manjiri";
        return new ResponseEntity<>(studentEntities, HttpStatus.OK);
    }
}
