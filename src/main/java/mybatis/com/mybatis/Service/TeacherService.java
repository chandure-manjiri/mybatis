package mybatis.com.mybatis.Service;

import mybatis.com.mybatis.Dto.TeacherCreationDto;
import mybatis.com.mybatis.Dto.TeacherDto;
import mybatis.com.mybatis.Dto.TeacherDtoForList;
import mybatis.com.mybatis.Entity.StudentEntity;
import mybatis.com.mybatis.Entity.TeacherEntity;
import mybatis.com.mybatis.MapStruct.TeacherMapper;
import mybatis.com.mybatis.Repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    TeacherMapper teacherMapper;

    public List<TeacherDtoForList> getTeachers(Integer minAge, Integer maxAge, String gender, String subject){

        List<TeacherEntity> teacherEntityList = this.teacherRepository.getTeachers(minAge, maxAge, gender, subject);
        return this.teacherMapper.toDtoList(teacherEntityList);
    }

    public TeacherDto getTeacherById(Integer id){

       TeacherEntity teacherEntity = teacherRepository.getTeacherById(id);
       return this.teacherMapper.toDto(teacherEntity);
    }

    public TeacherDto insertTeacher(TeacherCreationDto teacherCreationDto){
           TeacherEntity teacherEntity = this.teacherMapper.toEntity(teacherCreationDto);
           this.teacherRepository.insertTeacher(teacherEntity);
           return this.teacherMapper.toDto(teacherEntity);
    }

}
