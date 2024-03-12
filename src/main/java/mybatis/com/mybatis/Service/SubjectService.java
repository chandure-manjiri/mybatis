package mybatis.com.mybatis.Service;

import mybatis.com.mybatis.Dto.SubjectCreationDto;
import mybatis.com.mybatis.Dto.SubjectDto;
import mybatis.com.mybatis.Entity.SubjectEntity;
import mybatis.com.mybatis.MapStruct.SubjectMapper;

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

    @Autowired
    SubjectMapper subjectMapper;

    public List<SubjectDto> getSubjects(){

        List<SubjectEntity> subjectEntityList = this.subjectRepository.getSubjects();
        return this.subjectMapper.toDtoList(subjectEntityList);
    }

    public SubjectDto insertSubject(SubjectCreationDto subjectCreationDto) {
        SubjectEntity subjectEntity = this.subjectMapper.toSubjectEntity(subjectCreationDto);
        this.subjectRepository.insertSubject(subjectEntity);
        return this.subjectMapper.toDto(subjectEntity);
    }

}
