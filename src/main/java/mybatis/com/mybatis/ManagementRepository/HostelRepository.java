package mybatis.com.mybatis.ManagementRepository;

import mybatis.com.mybatis.ManagementEntity.HostelEntity;
import mybatis.com.mybatis.config.ManagementDataSource.ManagementDatabaseConnMapper;

import java.util.List;
@ManagementDatabaseConnMapper
public interface HostelRepository {
    List<HostelEntity> findAllHostels();
    void add(HostelEntity hostelEntity);
}
