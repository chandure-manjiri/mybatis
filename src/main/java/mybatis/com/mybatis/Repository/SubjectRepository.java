package mybatis.com.mybatis.Repository;

import mybatis.com.mybatis.Entity.SubjectEntity;
import mybatis.com.mybatis.config.SchoolDataSource.SchoolDatabaseConnMapper;

import java.util.List;
@SchoolDatabaseConnMapper
public interface SubjectRepository {
    List<SubjectEntity> findAllSubjects();

    void addSubject(SubjectEntity subjectEntity);
}
