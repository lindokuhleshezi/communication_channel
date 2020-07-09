package com.channel.domain;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@Getter
@Setter
public class Users {
	
	@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
	private String id;	
	private String role;
	
	@ManyToMany(mappedBy = "users")
	@JsonIgnore
   	private Set<Patient> patient = new HashSet<>();
}
