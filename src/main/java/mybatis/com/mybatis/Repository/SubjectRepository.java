package mybatis.com.mybatis.Repository;

import mybatis.com.mybatis.Entity.StudentEntity;
import mybatis.com.mybatis.Entity.SubjectEntity;
import mybatis.com.mybatis.config.PostgreSQLConnMapper;

import java.util.List;
@PostgreSQLConnMapper("PostgreSQLSubjectRepo")
public interface SubjectRepository {
    List<SubjectEntity> findAllSubjects();

    void addSubject(SubjectEntity subjectEntity);
}
