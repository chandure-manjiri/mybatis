package mybatis.com.mybatis.ManagementService;

import mybatis.com.mybatis.ManagementDto.MessOwnerCreationDto;
import mybatis.com.mybatis.ManagementDto.MessOwnerDto;
import mybatis.com.mybatis.ManagementEntity.MessOwnerEntity;
import mybatis.com.mybatis.ManagementMapStruct.MessOwnerMapper;
import mybatis.com.mybatis.ManagementRepository.MessOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Service
public class MessOwnerService {

    @Autowired
    MessOwnerRepository messOwnerRepository;

    @Autowired
    MessOwnerMapper  messOwnerMapper;
    public List<MessOwnerDto> getMessOwners(){
           List<MessOwnerEntity> messOwnerEntities = this.messOwnerRepository.findAllMessOwners();
           return this.messOwnerMapper.toDtoList(messOwnerEntities);
         }


    public MessOwnerDto createMessOwner(@RequestBody MessOwnerCreationDto messOwnerCreationDto){
             MessOwnerEntity messOwnerEntity = this.messOwnerMapper.toEntity(messOwnerCreationDto);
             this.messOwnerRepository.add(messOwnerEntity);
             return this.messOwnerMapper.toDto(messOwnerEntity);
         }
}
