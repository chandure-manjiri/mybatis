package mybatis.com.mybatis.Repository;

import mybatis.com.mybatis.Entity.StudentEntity;

import java.util.List;

public interface StudentRepository {
    List<StudentEntity> getStudents();
    //StudentEntity getStudentById(Integer id);

  //  StudentEntity getSubjectListOfStudent(Integer id);
}
