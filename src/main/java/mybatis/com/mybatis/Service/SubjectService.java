package mybatis.com.mybatis.Service;

import mybatis.com.mybatis.Entity.SubjectEntity;
import mybatis.com.mybatis.Repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class SubjectService {

    @Autowired
    SubjectRepository subjectRepository;

    public List<SubjectEntity> getSubjects(){
        return this.subjectRepository.getSubjects();
    }

    public void insertSubject(SubjectEntity subjectEntity){
        this.subjectRepository.insertSubject(subjectEntity);
    }

}
