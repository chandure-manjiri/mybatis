package mybatis.com.mybatis.Controller;

import mybatis.com.mybatis.Dto.*;
import mybatis.com.mybatis.Dto.StudentCreationDto;
import mybatis.com.mybatis.Dto.StudentDto;
import mybatis.com.mybatis.Dto.StudentDtoForList;
import mybatis.com.mybatis.Dto.SubjectDto;
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
    public ResponseEntity< List<StudentDtoForList>> getStudents(){
        List<StudentDtoForList> studentDtoList = this.studentService.getAllStudent();
        return new ResponseEntity<>(studentDtoList, HttpStatus.OK);
    }

    @GetMapping("/{id}/subjects")
    public ResponseEntity<StudentDtoForSubject> getStudentWithSubjectList(@PathVariable (name = "id") Integer id) {
        StudentDtoForSubject studentDtoForSubject = this.studentService.getStudentById(id);
        return new ResponseEntity<>(studentDtoForSubject, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<StudentDto> postStudent(@RequestBody StudentCreationDto studentCreationDto){
        StudentDto studentDto  = this.studentService.postStudent(studentCreationDto);
        return new ResponseEntity<>(studentDto, HttpStatus.CREATED);
    }

    @PostMapping("/{id}/subjects")
    public ResponseEntity<StudentDto> assignSubjectsToStudent(@PathVariable (name ="id") Integer id,@RequestBody List<SubjectDto> subjectDtoList){
         StudentDto studentDto = this.studentService.assignSubjectsToStudent(id, subjectDtoList);
         return new ResponseEntity<>(studentDto, HttpStatus.OK);
    }
}
