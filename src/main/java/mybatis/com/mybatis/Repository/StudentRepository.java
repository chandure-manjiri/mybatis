package mybatis.com.mybatis.Repository;

import mybatis.com.mybatis.Entity.StudentEntity;
import mybatis.com.mybatis.Entity.SubjectEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentRepository {
    List<StudentEntity> getStudents();
    //StudentEntity getStudentById(Integer id);

    StudentEntity getStudentById(@Param("id")Integer id);

    void insertStudent(StudentEntity studentEntity);

    void assignSubjectsToStudent(@Param("id")Integer id, @Param("subjectEntityList")List<SubjectEntity> subjectEntityList);
}
