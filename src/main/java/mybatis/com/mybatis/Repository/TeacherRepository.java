package mybatis.com.mybatis.Repository;

import mybatis.com.mybatis.Entity.TeacherEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherRepository {

    List<TeacherEntity> findAllTeachers(@Param("minAge") Integer minAge, @Param("maxAge") Integer maxAge, @Param("gender") String gender, @Param("subject") String subject);
    TeacherEntity findTeacherById(Integer id);

    void addTeacher(TeacherEntity teacherEntity);
}
