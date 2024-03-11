package mybatis.com.mybatis;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@OpenAPIDefinition(
		info = @Info(
				title = "mybatis",
				version = "1.0.0",
				description = "This project is used to maintain Student and Course Management",
				termsOfService = "Copyright@2023",
				contact = @Contact(
						name = "Manjiri Chandure",
						email = "chanduremanjiri@gmail.com"
				),
				license = @License(
						name = "license",
						url = "students-Courses/students"
				)
		)
)
@SpringBootApplication
@MapperScan("mybatis.com.mybatis.Repository")
public class MybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybatisApplication.class, args);
	}

}
