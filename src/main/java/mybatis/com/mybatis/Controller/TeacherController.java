package mybatis.com.mybatis.Controller;

import mybatis.com.mybatis.Entity.StudentEntity;
import mybatis.com.mybatis.Entity.TeacherEntity;
import mybatis.com.mybatis.Repository.TeacherRepository;
import mybatis.com.mybatis.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    TeacherService teacherService;
    @GetMapping()
    public ResponseEntity<List<TeacherEntity>> getTeachers(){
       List<TeacherEntity> teacherEntities = teacherRepository.findAllTeachers();
       System.out.println(teacherEntities.get(0).getSubjectEntities());
        return new ResponseEntity<>(teacherEntities, HttpStatus.OK);
    }

    @GetMapping("/{id}/subjects")
    public ResponseEntity<TeacherEntity> getStudentWithSubjectList(@PathVariable(name = "id") Integer id){
        TeacherEntity teacherEntity = teacherRepository.findTeacherById(id);
        return new ResponseEntity<>(teacherEntity, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<String> postTeacher(@RequestBody TeacherEntity teacherEntity){
        this.teacherRepository.addTeacher(teacherEntity);
        String n = "created";
        return new ResponseEntity<>(n, HttpStatus.CREATED);
    }
}
