package mybatis.com.mybatis.Repository;

import mybatis.com.mybatis.Entity.StudentEntity;
import mybatis.com.mybatis.Entity.SubjectEntity;

import java.util.List;

public interface SubjectRepository {
    List<SubjectEntity> getSubjects();

    void insertSubject(SubjectEntity subjectEntity);
}
