package mybatis.com.mybatis.Controller;

import mybatis.com.mybatis.Dto.StudentCreationDto;
import mybatis.com.mybatis.Entity.StudentEntity;
import mybatis.com.mybatis.Entity.SubjectEntity;
import mybatis.com.mybatis.Repository.StudentRepository;
import mybatis.com.mybatis.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping()
    public ResponseEntity< List<StudentEntity>> getStudents(){
        List<StudentEntity> studentEntities = this.studentService.findAllStudents();
        return new ResponseEntity<>(studentEntities, HttpStatus.OK);
    }

    @GetMapping("/{id}/subjects")
    public ResponseEntity<StudentEntity> getStudentWithSubjectList(@PathVariable (name = "id") Integer id){
        StudentEntity studentEntity= this.studentService.findStudentById(id);
        return new ResponseEntity<>(studentEntity, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<StudentEntity> postStudent(@RequestBody StudentEntity studentEntity){
        StudentEntity studentEntity  = this.studentService.addStudent(studentEntity);
        return new ResponseEntity<>(studentEntity, HttpStatus.CREATED);
    }

    @PostMapping("/{id}/subjects")
    public ResponseEntity<String> assignSubjectsToStudent(@PathVariable (name ="id") Integer id,@RequestBody List<SubjectEntity> subjectEntityList){
        this.studentService.assignSubjectsToStudent(id, subjectEntityList);
        String n = "get assigned";
        return new ResponseEntity<>(n, HttpStatus.OK);
    }
}
