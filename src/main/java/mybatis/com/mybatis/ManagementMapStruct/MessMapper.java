package mybatis.com.mybatis.ManagementMapStruct;

import mybatis.com.mybatis.ManagementDto.MessCreationDto;
import mybatis.com.mybatis.ManagementDto.MessDto;
import mybatis.com.mybatis.ManagementDto.MessOwnersDto;
import mybatis.com.mybatis.ManagementEntity.MessEntity;
import mybatis.com.mybatis.ManagementEntity.MessOwnerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = MessOwnerMapper.class)
public interface MessMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "name")
    @Mapping(target = "contactNumber", source = "contactNumber")
    @Mapping(target = "messType", source = "messType")
    @Mapping(target = "location", source = "location")
    MessEntity toEntity(MessCreationDto messCreationDto);
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "contactNumber", source = "contactNumber")
    @Mapping(target = "messType", source = "messType")
    @Mapping(target = "location", source = "location")
    MessDto toDto(MessEntity messEntity);

    List<MessDto> toDtoList(List<MessEntity> messEntities);

    @Mapping(source = "messEntity.id", target = "id")
    @Mapping(source = "messEntity.name", target = "name")
    @Mapping(source = "messOwnerEntities", target = "messOwnerDtos")
    MessOwnersDto toMessOwnersDto(MessEntity messEntity, List<MessOwnerEntity> messOwnerEntities);
}
