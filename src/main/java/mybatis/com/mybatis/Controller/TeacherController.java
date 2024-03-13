package mybatis.com.mybatis.Controller;

import mybatis.com.mybatis.Dto.TeacherCreationDto;
import mybatis.com.mybatis.Dto.TeacherDto;
import mybatis.com.mybatis.Dto.TeacherDtoForList;
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
    public ResponseEntity<List<TeacherDtoForList>> getTeachers(
         @RequestParam(name = "gender", required = false) String gender,
         @RequestParam(name = "age", required = false) Integer age,
         @RequestParam(name = "minAge", required = false) Integer minAge,
         @RequestParam(name = "maxAge", required = false) Integer maxAge,
         @RequestParam(name = "subject", required = false) String subject
    ){
        List<TeacherDtoForList> teacherDtoList = null;
        if(gender != null && minAge != null && maxAge != null){
            teacherDtoList = this.teacherService.getTeachersByGenderByMinAgeByMaxAge(gender, minAge, maxAge);
        }
        else if (gender != null && age != null) {
            teacherDtoList = this.teacherService.getTeachersByGenderByAge(gender, age);
        }
        else if(gender != null && minAge != null){
            teacherDtoList = this.teacherService.getTeachersByGenderByMinAge(gender, minAge);
        }
        else if(gender != null && maxAge != null){
            teacherDtoList = this.teacherService.getTeachersByGenderByMaxAge(gender, maxAge);
        }
        else if(gender != null){
            teacherDtoList = this.teacherService.getTeachersByGender(gender);
        }
        else if(minAge != null && maxAge != null){
            teacherDtoList = this.teacherService.getTeachersBetweenMinAgeAndMaxAge(minAge, maxAge);
        }
        else if(minAge != null){
            teacherDtoList = this.teacherService.getTeachersByMinAge(minAge);
        }
        else if(maxAge != null){
            teacherDtoList = this.teacherService.getTeachersByMaxAge(maxAge);
        }
        else if(age != null){
            teacherDtoList = this.teacherService.getTeachersByAge(age);
        }
        else if(subject != null){
            teacherDtoList = this.teacherService.getTeachersBySubject(subject);
        }
        else{
            teacherDtoList = this.teacherService.getTeachers();
       }

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
}
