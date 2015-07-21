/**
 * 
 */
package com.dgstack.dev.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 * @author digvijay.bhakuni
 *
 */


@Entity
public class City implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = true)
	private String state;

	@Column(nullable = false)
	private String country;

	@Column(nullable = true)
	private String map;

	public City() {
	}

	public City(String name, String country) {
		super();
		this.name = name;
		this.country = country;
	}
	
	public City(String name, String state,String country) {
		this(name,country);
		this.state = state;
	}

	public String getName() {
		return this.name;
	}

	public String getState() {
		return this.state;
	}

	public String getCountry() {
		return this.country;
	}

	public String getMap() {
		return this.map;
	}

	@Override
	public String toString() {
		return getName() + "," + getState() + "," + getCountry();
	}
}