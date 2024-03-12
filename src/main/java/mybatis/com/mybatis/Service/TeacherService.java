package mybatis.com.mybatis.Service;

import mybatis.com.mybatis.Entity.StudentEntity;
import mybatis.com.mybatis.Entity.TeacherEntity;
import mybatis.com.mybatis.Repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    TeacherRepository teacherRepository;

    public List<TeacherEntity> getTeachers(){
        return this.teacherRepository.getTeachers();
    }

    public TeacherEntity getTeacherById(Integer id){
       return teacherRepository.getTeacherById(id);
    }

    public TeacherEntity insertTeacher(TeacherEntity teacherEntity){

           this.teacherRepository.insertTeacher(teacherEntity);
           return teacherEntity;
    }

}
