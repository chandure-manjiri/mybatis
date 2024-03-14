package mybatis.com.mybatis.Repository;

import mybatis.com.mybatis.Entity.TeacherEntity;

import java.util.List;

public interface TeacherRepository {
    List<TeacherEntity> findAllTeachers();
    TeacherEntity findTeacherById(Integer id);

    void addTeacher(TeacherEntity teacherEntity);
}
