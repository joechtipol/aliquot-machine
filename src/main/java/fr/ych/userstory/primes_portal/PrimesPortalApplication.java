package fr.ych.userstory.primes_portal;

import java.sql.DriverManager;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableCaching
public class PrimesPortalApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(PrimesPortalApplication.class, args);
	}
	/*
	@Bean		
	public DataSource dataSource() {
		
		// no need shutdown, EmbeddedDatabaseFactoryBean will take care of this
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase db = builder
			.setType(EmbeddedDatabaseType.HSQL) //.H2 or .DERBY
			.addScript("db/sql/create-db.sql")
			.addScript("db/sql/insert-data.sql")
			.build();
		return db;
	}
	*/
	
	@Bean		
	public DataSource dataSource() {
		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
	    dataSourceBuilder.driverClassName("org.mariadb.jdbc.Driver");
	    //connection = DriverManager.getConnection("jdbc:mariadb://mariadbinstance.cg6f7elz5lj1.eu-west-1.rds.amazonaws.com:3306/aliquot_db?user=joe&password=chtipolpwd");
	    dataSourceBuilder.url("jdbc:mariadb://mariadbinstance.cg6f7elz5lj1.eu-west-1.rds.amazonaws.com:3306/aliquot_1");
	    dataSourceBuilder.username("joe");
	    dataSourceBuilder.password("chtipolpwd");
	   // dataSourceBuilder.url("jdbc:mariadb://ns331184.ip-37-187-121.eu:3306/aliquot_1");
	    //dataSourceBuilder.username("root");
	    //dataSourceBuilder.password("");
	    return dataSourceBuilder.build();
	}
	
}