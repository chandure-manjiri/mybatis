package Repository;

import Entity.TeacherEntity;

import java.util.List;

public interface TeacherRepository {
    List<TeacherEntity> getTeachers();

    TeacherEntity getTeacherById(Integer id);
}
