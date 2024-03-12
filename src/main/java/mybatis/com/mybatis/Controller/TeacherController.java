package mybatis.com.mybatis.Controller;

import mybatis.com.mybatis.Dto.TeacherCreationDto;
import mybatis.com.mybatis.Dto.TeacherDto;
import mybatis.com.mybatis.Dto.TeacherDtoForList;
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
    public ResponseEntity<List<TeacherDtoForList>> getTeachers(){
        List<TeacherDtoForList> teacherDtoList = this.teacherService.getTeachers();
        return new ResponseEntity<>(teacherDtoList, HttpStatus.OK);
    }

    @GetMapping("/{id}/subjects")
    public ResponseEntity<TeacherDto> getStudentWithSubjectList(@PathVariable(name = "id") Integer id){
        TeacherDto teacherDto = this.teacherService.getTeacherById(id);
        return new ResponseEntity<>(teacherDto, HttpStatus.OK);
    }


    @PostMapping()
    public ResponseEntity<TeacherDto> postTeacher(@RequestBody TeacherCreationDto teacherCreationDto){
        TeacherDto teacherDto = this.teacherService.insertTeacher(teacherCreationDto);
        return new ResponseEntity<>(teacherDto, HttpStatus.CREATED);
   }

    @GetMapping("/{id}/subjects")
    public ResponseEntity<TeacherEntity> getStudentWithSubjectList(@PathVariable(name = "id") Integer id){
        TeacherEntity teacherEntity = this.teacherService.getTeacherById(id);
        return new ResponseEntity<>(teacherEntity, HttpStatus.OK);
    }

}
