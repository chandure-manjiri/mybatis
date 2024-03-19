package mybatis.com.mybatis.ManagementService;

import mybatis.com.mybatis.ManagementDto.HostelCreationDto;
import mybatis.com.mybatis.ManagementDto.HostelDto;
import mybatis.com.mybatis.ManagementEntity.HostelEntity;
import mybatis.com.mybatis.ManagementMapStruct.HostelMapper;
import mybatis.com.mybatis.ManagementRepository.HostelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class HostelService{

    @Autowired
    HostelRepository hostelRepository;

    @Autowired
    HostelMapper hostelMapper;
    public List<HostelDto> getAllHostels() {
        List<HostelEntity> hostelEntities = this.hostelRepository.findAllHostels();
        return this.hostelMapper.toDtoList(hostelEntities);
    }

    public HostelDto createHostel(HostelCreationDto hostelCreationDto) {
        HostelEntity hostelEntity = this.hostelMapper.toEntity(hostelCreationDto);
        this.hostelRepository.add(hostelEntity);
        return this.hostelMapper.toDto(hostelEntity);
    }
}
