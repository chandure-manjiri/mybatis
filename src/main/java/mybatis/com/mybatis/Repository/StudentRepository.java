package mybatis.com.mybatis.Repository;

import mybatis.com.mybatis.Entity.StudentEntity;
import mybatis.com.mybatis.Entity.SubjectEntity;
import mybatis.com.mybatis.config.PostgreSQLConnMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@PostgreSQLConnMapper("PostgreSQLStudentRepo")
public interface StudentRepository {
    List<StudentEntity> findAllStudents();
    //StudentEntity getStudentById(Integer id);

    StudentEntity findStudentById(@Param("id")Integer id);

    void addStudent(StudentEntity studentEntity);

    void assignSubjectsToStudent(@Param("id")Integer id, @Param("subjectEntities")List<SubjectEntity> subjectEntities);
}
