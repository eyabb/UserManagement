package com.bezkoder.springjwt.models;



import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Menu {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    @Column
	    private String name;
	    
	    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL, orphanRemoval = true)
	    private Set<MenuRole> menuRoles = new HashSet<>();
	    
	   
	  

		public Set<MenuRole> getMenuRoles() {
			return menuRoles;
		}

		public void setMenuRoles(Set<MenuRole> menuRoles) {
			this.menuRoles = menuRoles;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			
			this.name = name;
			
		}

		public Menu(Long id, String name) {
			super();
			this.id = id;
			this.name = name;
		}
		public Menu( String name) {
			this.name = name;
		}
		public Menu() {

		}

}
