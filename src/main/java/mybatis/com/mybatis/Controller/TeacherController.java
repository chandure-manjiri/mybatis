package mybatis.com.mybatis.Controller;
import jakarta.validation.Valid;
import mybatis.com.mybatis.Dto.TeacherCreationDto;
import mybatis.com.mybatis.Dto.TeacherDto;
import mybatis.com.mybatis.Dto.TeacherDtoForList;
import mybatis.com.mybatis.Exception.ResourceNotFoundException;
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
    public ResponseEntity<List<TeacherDtoForList>> getTeachers(@RequestParam(name = "minAge", required = false) Integer minAge ,
                                                               @RequestParam(name = "maxAge", required = false) Integer maxAge,
                                                               @RequestParam(name = "gender", required = false) String gender,
                                                               @RequestParam(name = "subject", required = false) String subject){

        List<TeacherDtoForList> teacherDtoList = this.teacherService.getTeachers(minAge, maxAge, gender, subject);
        return new ResponseEntity<>(teacherDtoList, HttpStatus.OK);
    }

    @GetMapping("/{id}/subjects")
    public ResponseEntity<TeacherDto> getTeacherWithSubjectList(@PathVariable(name = "id") Integer id) throws ResourceNotFoundException {
        TeacherDto teacherDto = this.teacherService.getTeacherById(id);
        return new ResponseEntity<>(teacherDto, HttpStatus.OK);
    }


    @PostMapping()
    public ResponseEntity<TeacherDto> postTeacher(@Valid @RequestBody TeacherCreationDto teacherCreationDto){
        TeacherDto teacherDto = this.teacherService.insertTeacher(teacherCreationDto);
        return new ResponseEntity<>(teacherDto, HttpStatus.CREATED);
   }
}
