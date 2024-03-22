package mybatis.com.mybatis.ManagementRepository;

import mybatis.com.mybatis.ManagementEntity.MessOwnerEntity;
import mybatis.com.mybatis.config.ManagementDataSource.ManagementDatabaseConnMapper;

import java.util.List;
@ManagementDatabaseConnMapper
public interface MessOwnerRepository {
    List<MessOwnerEntity> findAllMessOwnersByMessId(Integer messId);
    List<MessOwnerEntity> findAllMessOwners();
    void add(MessOwnerEntity messOwnerEntity);
}
