package mybatis.com.mybatis.ManagementRepository;

import mybatis.com.mybatis.ManagementEntity.MessEntity;
import mybatis.com.mybatis.config.ManagementDataSource.ManagementDatabaseConnMapper;

import java.util.List;
@ManagementDatabaseConnMapper
public interface MessRepository {
    List<MessEntity> findAllMess();
    void add(MessEntity messEntity);
    MessEntity findMessByID(Integer messId);
}
