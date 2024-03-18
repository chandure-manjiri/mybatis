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
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@MapperScan(
        value = "mybatis.com.mybatis",
        annotationClass = PostgreSQLConnMapper2.class,
        sqlSessionFactoryRef = "PostgreSQLSessionFactory2")
@Configuration
public class PostgreSQLConfig2 {
    @Bean(name = "PostgreSQLDataSource2")
    @ConfigurationProperties(prefix="spring.datasource2")
    public DataSource secondDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "PostgreSQLSessionFactory2")
    public SqlSessionFactory postgresSqlSessionFactory1(
            @Qualifier("PostgreSQLDataSource2") DataSource postgresDataSource2) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(postgresDataSource2);
        sqlSessionFactoryBean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("mapper/postgresql2/*.xml"));
        sqlSessionFactoryBean.setTypeAliasesPackage("mybatis/com/mybatis/MessEntity");
        return sqlSessionFactoryBean.getObject();
    }

        @Bean(name = "PostgreSQLSessionTemplate2")
        public SqlSessionTemplate postgresSqlSessionTemplate2(
                @Qualifier("PostgreSQLSessionFactory2")
                        SqlSessionFactory postgresSessionTemplate2){
            return new SqlSessionTemplate(postgresSessionTemplate2);
        }

        @Bean(name = "PostgreSQLTransactionManager2")
        public DataSourceTransactionManager secondaryTransactionManager(
                @Qualifier("PostgreSQLDataSource2")
                        DataSource postgresqlDataSource) {

            return new DataSourceTransactionManager(postgresqlDataSource);
        }
}
