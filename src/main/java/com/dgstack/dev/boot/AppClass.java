/**
 * 
 */
package com.dgstack.dev.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.dgstack.dev.models.City;
import com.dgstack.dev.repo.CityRepo;

/**
 * @author digvijay.bhakuni
 *
 */
@Configuration
@SpringBootApplication
@EnableJpaRepositories("com.dgstack.dev.repo")
@EntityScan(basePackages="com.dgstack.dev.models")
public class AppClass implements CommandLineRunner {

	@Autowired
    CityRepo repo;
	
	
	/**
	 * 
	 */
	public AppClass() {
			
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if(args.length==0){
			args = new String[]{"Diggu"};
		}
		SpringApplication.run(AppClass.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {

		for(String s : arg0)
			System.out.println(s);
		
		repo.save(new City("Haldwani", "UKND","India"));
		repo.save(new City("Gurgoan", "India"));
		repo.save(new City("Noida", "India"));
		repo.save(new City("Delhi", "India"));
		repo.save(new City("DD", "UKND","India"));
		repo.save(new City("HW", "UKND","India"));
		
		//Iterable<City> list = repo.findAll();
		//Iterable<City> list = repo.findByName("Haldwani");
		//Iterable<City> list = repo.findByCountry("UK");
		Iterable<City> list = repo.findByCountryAndState("India", "UKND");
		for(City c : list){
			System.out.println(c);
		}
		
	}

}
