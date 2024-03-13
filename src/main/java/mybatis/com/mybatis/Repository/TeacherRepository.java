package mybatis.com.mybatis.Repository;

import mybatis.com.mybatis.Dto.TeacherDtoForList;
import mybatis.com.mybatis.Entity.TeacherEntity;

import java.util.List;

public interface TeacherRepository {
    List<TeacherEntity> getTeachers();

    TeacherEntity getTeacherById(Integer id);

    void insertTeacher(TeacherEntity teacherEntity);

    List<TeacherEntity> getTeachersByGenderByMinAgeByMaxAge(String gender, Integer minAge, Integer maxAge);
    List<TeacherEntity> getTeachersByGenderByAge(String gender, Integer age);

    List<TeacherEntity> getTeachersByGenderByMinAge(String gender, Integer minAge);

    List<TeacherEntity> getTeachersByGenderByMaxAge(String gender, Integer maxAge);

    List<TeacherEntity> getTeachersByGender(String gender);

    List<TeacherEntity> getTeachersBetweenMinAgeAndMaxAge(Integer minAge, Integer maxAge);

    List<TeacherEntity> getTeachersByMinAge(Integer minAge);

    List<TeacherEntity> getTeachersByMaxAge(Integer maxAge);

    List<TeacherEntity> getTeachersByAge(Integer age);

    List<TeacherEntity> getTeachersBySubject(String subject);

}

