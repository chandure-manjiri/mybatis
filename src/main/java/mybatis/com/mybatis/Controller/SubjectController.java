package mybatis.com.mybatis.Controller;

import mybatis.com.mybatis.Entity.StudentEntity;
import mybatis.com.mybatis.Entity.SubjectEntity;
import mybatis.com.mybatis.Repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    @Autowired
    SubjectRepository subjectRepository;

    @GetMapping()
    public ResponseEntity<List<SubjectEntity>> getSubjects(){
       List<SubjectEntity> subjectEntities = this.subjectRepository.findAllSubjects();
        return new ResponseEntity<>(subjectEntities, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<String> postSubject(@RequestBody SubjectEntity subjectEntity){
        this.subjectRepository.addSubject(subjectEntity);
        String n = "created";
        return new ResponseEntity<>(n, HttpStatus.CREATED);
    }
}
