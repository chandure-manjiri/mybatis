package mybatis.com.mybatis.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@MapperScan(
        value = "mybatis.com.mybatis",
        annotationClass = PostgreSQLConnMapper.class,
        sqlSessionFactoryRef = "PostgreSQLSessionFactory")
@Configuration
public class PostgreSQLConfig1 {
    @Bean(name = "PostgreSQLDataSource1")
    @Primary
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource firstDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "PostgreSQLSessionFactory")
    public SqlSessionFactory postgresSqlSessionFactory(
            @Qualifier("PostgreSQLDataSource1") DataSource postgresDataSource) throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(postgresDataSource);
        sqlSessionFactoryBean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("mapper/postgresql1/*.xml"));
        sqlSessionFactoryBean.setTypeAliasesPackage("mybatis/com/mybatis/Entity");
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "PostgreSQLSessionTemplate")
    public SqlSessionTemplate postgresSqlSessionTemplate(
            @Qualifier("PostgreSQLSessionFactory")
            SqlSessionFactory postgresSessionTemplate){
        return new SqlSessionTemplate(postgresSessionTemplate);
    }

    @Bean(name = "PostgreSQLTransactionManager")
    public DataSourceTransactionManager PrimaryTransactionManager(
            @Qualifier("PostgreSQLDataSource")
            DataSource postgresqlDataSource) {

        return new DataSourceTransactionManager(postgresqlDataSource);
    }
}
