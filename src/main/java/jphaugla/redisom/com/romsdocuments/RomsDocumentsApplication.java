package jphaugla.redisom.com.romsdocuments;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.geo.Point;

import jphaugla.redisom.com.romsdocuments.domain.Company;
import jphaugla.redisom.com.romsdocuments.repositories.CompanyRepository;
import com.redis.om.spring.annotations.EnableRedisDocumentRepositories;

@SpringBootApplication
@Configuration
@EnableRedisDocumentRepositories(basePackages = "jphaugla.redisom.com.romsdocuments.*")
public class RomsDocumentsApplication {

	@Autowired
	CompanyRepository companyRepo;

	@Bean
	CommandLineRunner loadTestData() {
		return args -> {
			companyRepo.deleteAll();
			Company redis = Company.of("https://redis.com", new Point(-122.066540, 37.377690), 526,
					2011, "Redis", "Salavatore Sanfilippo");
			redis.setTags(Set.of("fast", "scalable", "reliable"));

			Company microsoft = Company.of("https://microsoft.com", new Point(-122.124500, 47.640160),
					182268, 1975, "Microsoft", "Bill Gates");
			microsoft.setTags(Set.of("innovative", "reliable"));

			companyRepo.save(redis);
			companyRepo.save(microsoft);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(RomsDocumentsApplication.class, args);
	}

}
