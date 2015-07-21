/**
 * 
 */
package com.dgstack.dev.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dgstack.dev.models.City;
/**
 * @author digvijay.bhakuni
 *
 */
@Repository
public interface CityRepo extends CrudRepository<City,Long>{
	
	Iterable<City> findByName(String name);
	
	Iterable<City> findByCountry(String country);
	
	Iterable<City> findByCountryAndState(String country,String state);
}
