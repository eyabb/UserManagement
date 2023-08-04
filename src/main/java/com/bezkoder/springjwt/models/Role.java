package com.bezkoder.springjwt.models;


import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column
  private String name;
  

  @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<UserRole> userRoles = new HashSet<>();
  
  @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<MenuRole> menuRoles = new HashSet<>();
  
  
  
  public Set<MenuRole> getMenuRoles() {
	return menuRoles;
}




public void setMenuRoles(Set<MenuRole> menuRoles) {
	this.menuRoles = menuRoles;
}




public Role() {

  }
  

  

  public Set<UserRole> getUserRoles() {
	return userRoles;
}

public void setUserRoles(Set<UserRole> userRoles) {
	this.userRoles = userRoles;
}

public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }
  
  public void setName(String name)
  {
	  this.name=name;
  }
  
  
  public void addUser(User user) {
      UserRole userRole = new UserRole();
      userRole.setRole(this);
      userRole.setUser(user);
      userRoles.add(userRole);
      user.getUserRoles().add(userRole);
  }
  public void removeUser(User user) {
      UserRole userRole = new UserRole();
      userRole.setRole(null);
      userRole.setUser(null);
      userRoles.remove(userRole);
      user.getUserRoles().remove(userRole);
  }
  
}