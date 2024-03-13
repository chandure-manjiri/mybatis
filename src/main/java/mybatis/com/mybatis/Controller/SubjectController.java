package mybatis.com.mybatis.Controller;

import mybatis.com.mybatis.Dto.SubjectCreationDto;
import mybatis.com.mybatis.Dto.SubjectDto;
import mybatis.com.mybatis.Entity.StudentEntity;
import mybatis.com.mybatis.Entity.SubjectEntity;
import mybatis.com.mybatis.Repository.SubjectRepository;
import mybatis.com.mybatis.Service.StudentService;
import mybatis.com.mybatis.Service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    @Autowired
    SubjectService subjectService;
    @GetMapping()
    public ResponseEntity<List<SubjectDto>> getSubjects(){
        List<SubjectDto> subjectDtoList = this.subjectService.getSubjects();
        return new ResponseEntity<>(subjectDtoList, HttpStatus.OK);
    }
     @PostMapping()
    public ResponseEntity<SubjectDto> postSubject(@RequestBody SubjectCreationDto subjectCreationDto){
         SubjectDto subjectDto = this.subjectService.insertSubject(subjectCreationDto);
         return new ResponseEntity<>(subjectDto, HttpStatus.CREATED);
   }
}
