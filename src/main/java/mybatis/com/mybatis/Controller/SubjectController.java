package mybatis.com.mybatis.Controller;

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
    public ResponseEntity<List<SubjectEntity>> getSubjects(){
       List<SubjectEntity> subjectEntities = this.subjectService.findAllSubjects();
       return new ResponseEntity<>(subjectEntities, HttpStatus.OK);
    }

    @PostMapping()

    public ResponseEntity<SubjectEntity> postSubject(@RequestBody SubjectEntity subjectRequestEntity){
         SubjectEntity subjectResponseEntity = this.subjectService.addSubject(subjectRequestEntity);
         return new ResponseEntity<>(subjectResponseEntity, HttpStatus.CREATED);
    }
}
