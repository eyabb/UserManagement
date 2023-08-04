package com.bezkoder.springjwt.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "menu_roles")
public class MenuRole {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "menu_id")
	    private Menu menu;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "role_id")
	    private Role role;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Menu getMenu() {
			return menu;
		}

		public void setMenu(Menu menu) {
			this.menu = menu;
		}

		public Role getRole() {
			return role;
		}

		public void setRole(Role role) {
			this.role = role;
		}

		public MenuRole(Long id, Menu menu, Role role) {
			super();
			this.id = id;
			this.menu = menu;
			this.role = role;
		}
		public MenuRole( Menu menu, Role role) {
			super();
			this.menu = menu;
			this.role = role;
		}
		public MenuRole() {
		}

	    

}
