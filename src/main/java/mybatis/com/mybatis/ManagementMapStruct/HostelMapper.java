package mybatis.com.mybatis.ManagementMapStruct;

import mybatis.com.mybatis.ManagementDto.HostelCreationDto;
import mybatis.com.mybatis.ManagementDto.HostelDto;
import mybatis.com.mybatis.ManagementEntity.HostelEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
//private String name;
//private String hostelType;
//private String location;
@Mapper(componentModel = "spring")
public interface HostelMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "name")
    @Mapping(target = "hostelType", source = "hostelType")
    @Mapping(target = "location", source = "location")
    HostelEntity toEntity(HostelCreationDto hostelCreationDto);
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "hostelType", source = "hostelType")
    @Mapping(target = "location", source = "location")
    HostelDto toDto(HostelEntity hostelEntity);

    List<HostelDto> toDtoList(List<HostelEntity> hostelEntities);
}
