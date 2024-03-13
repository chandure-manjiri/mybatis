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

    public List<TeacherDtoForList> getTeachers(){

        List<TeacherEntity> teacherEntityList = this.teacherRepository.getTeachers();
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

    public List<TeacherDtoForList> getTeachersByGenderByMinAgeByMaxAge(String gender, Integer minAge, Integer maxAge) {
        List<TeacherEntity> teacherEntityList = this.teacherRepository.getTeachersByGenderByMinAgeByMaxAge(gender, minAge, maxAge);
        return this.teacherMapper.toDtoList(teacherEntityList);
    }

    public List<TeacherDtoForList> getTeachersByGenderByAge(String gender, Integer age) {
        List<TeacherEntity> teacherEntityList = this.teacherRepository.getTeachersByGenderByAge(gender,age);
        return this.teacherMapper.toDtoList(teacherEntityList);
    }

    public List<TeacherDtoForList> getTeachersByGenderByMinAge(String gender, Integer minAge) {
        List<TeacherEntity> teacherEntityList = this.teacherRepository.getTeachersByGenderByMinAge(gender, minAge);
        return this.teacherMapper.toDtoList(teacherEntityList);
    }

    public List<TeacherDtoForList> getTeachersByGenderByMaxAge(String gender, Integer maxAge) {
        List<TeacherEntity> teacherEntityList = this.teacherRepository.getTeachersByGenderByMaxAge(gender, maxAge);
        return this.teacherMapper.toDtoList(teacherEntityList);
    }

    public List<TeacherDtoForList> getTeachersByGender(String gender) {
        List<TeacherEntity> teacherEntityList = this.teacherRepository.getTeachersByGender(gender);
        return this.teacherMapper.toDtoList(teacherEntityList);
    }

    public List<TeacherDtoForList> getTeachersBetweenMinAgeAndMaxAge(Integer minAge, Integer maxAge) {
        List<TeacherEntity> teacherEntityList = this.teacherRepository.getTeachersBetweenMinAgeAndMaxAge(minAge,maxAge);
        return this.teacherMapper.toDtoList(teacherEntityList);
    }

    public List<TeacherDtoForList> getTeachersByMinAge(Integer minAge) {
        List<TeacherEntity> teacherEntityList = this.teacherRepository.getTeachersByMinAge(minAge);
        return this.teacherMapper.toDtoList(teacherEntityList);
    }

    public List<TeacherDtoForList> getTeachersByMaxAge(Integer maxAge) {
        List<TeacherEntity> teacherEntityList = this.teacherRepository.getTeachersByMaxAge(maxAge);
        return this.teacherMapper.toDtoList(teacherEntityList);
    }

    public List<TeacherDtoForList> getTeachersByAge(Integer age) {
        List<TeacherEntity> teacherEntityList = this.teacherRepository.getTeachersByAge(age);
        return this.teacherMapper.toDtoList(teacherEntityList);
    }

    public List<TeacherDtoForList> getTeachersBySubject(String subject) {
        List<TeacherEntity> teacherEntityList = this.teacherRepository.getTeacherBySubject(subject);
        return this.teacherMapper.toDtoList(teacherEntityList);
    }
}
