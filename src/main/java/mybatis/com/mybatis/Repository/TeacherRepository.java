package mybatis.com.mybatis.Repository;

import mybatis.com.mybatis.Dto.TeacherDtoForList;
import mybatis.com.mybatis.Entity.TeacherEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherRepository {
    List<TeacherEntity> getTeachers();

    TeacherEntity getTeacherById(Integer id);

    void insertTeacher(TeacherEntity teacherEntity);

    List<TeacherEntity> getTeachersByGenderByMinAgeByMaxAge(@Param("gender")String gender, @Param("minAge")Integer minAge, @Param("maxAge")Integer maxAge);
    List<TeacherEntity> getTeachersByGenderByAge(@Param("gender")String gender,@Param("age") Integer age);

    List<TeacherEntity> getTeachersByGenderByMinAge(@Param("gender")String gender, @Param("minAge")Integer minAge);

    List<TeacherEntity> getTeachersByGenderByMaxAge(@Param("gender")String gender, @Param("maxAge")Integer maxAge);

    List<TeacherEntity> getTeachersByGender(@Param("gender")String gender);

    List<TeacherEntity> getTeachersBetweenMinAgeAndMaxAge(@Param("minAge")Integer minAge,@Param("maxAge")Integer maxAge);

    List<TeacherEntity> getTeachersByMinAge(@Param("minAge")Integer minAge);

    List<TeacherEntity> getTeachersByMaxAge(@Param("maxAge")Integer maxAge);

    List<TeacherEntity> getTeachersByAge(@Param("age")Integer age);

    List<TeacherEntity> getTeacherBySubject(@Param("subject") String subject);

}

