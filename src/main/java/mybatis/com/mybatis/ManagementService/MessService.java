package mybatis.com.mybatis.ManagementService;

import mybatis.com.mybatis.ManagementDto.MessCreationDto;
import mybatis.com.mybatis.ManagementDto.MessDto;
import mybatis.com.mybatis.ManagementDto.MessOwnersDto;
import mybatis.com.mybatis.ManagementEntity.MessEntity;
import mybatis.com.mybatis.ManagementEntity.MessOwnerEntity;
import mybatis.com.mybatis.ManagementMapStruct.MessMapper;
import mybatis.com.mybatis.ManagementRepository.MessOwnerRepository;
import mybatis.com.mybatis.ManagementRepository.MessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class MessService {
    @Autowired
    MessRepository messRepository;
    @Autowired
    MessMapper messMapper;

    @Autowired
    MessOwnerRepository messOwnerRepository;


    public List<MessDto> getAllMess(){
        List<MessEntity> messEntities = this.messRepository.findAllMess();
        return this.messMapper.toDtoList(messEntities);
    }


    public MessDto createMess(@RequestBody MessCreationDto messCreationDto){
        MessEntity messEntity = this.messMapper.toEntity(messCreationDto);
        this.messRepository.add(messEntity);
        return this.messMapper.toDto(messEntity);
    }


    public MessOwnersDto getAllOwners(Integer mess_id){
        MessEntity messEntity = this.messRepository.findMessByID(mess_id);
        List<MessOwnerEntity> messOwnerEntities = this.messOwnerRepository.findAllMessOwnersByMessId(mess_id);
        return this.messMapper.toMessOwnersDto(messEntity,messOwnerEntities);
    }
}
