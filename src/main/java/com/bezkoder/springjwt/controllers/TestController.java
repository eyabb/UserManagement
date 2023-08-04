package com.bezkoder.springjwt.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.springjwt.models.Menu;
import com.bezkoder.springjwt.models.MenuRole;
import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.repository.UserRepository;
import com.bezkoder.springjwt.repository.MenuRoleRepository;


//@CrossOrigin(origins = "*", maxAge = 3600)
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RestController
@RequestMapping("/api/test")
public class TestController {
	
	@Autowired
	  UserRepository userRepository;
	@Autowired
	  MenuRoleRepository MenuRoleRepository;
	
  @GetMapping("/all")
  public String allAccess() {
    return "Public Content for all employees of ST2I.";
  }

  @GetMapping("/dev")
  @PreAuthorize("hasRole('DEVELOPPER')")
  public String userAccess() {
    return "DEVELOPPER Content.";
  }

  @GetMapping("/rh")
 @PreAuthorize("hasRole('ROLE_RH')")
  public String moderatorAccess() {
    return "RH Board.";
  }

  @GetMapping("/admin")

 @PreAuthorize("hasRole('ROLE_ADMIN')")
  public String adminAccess() {
	  
    return "Admin Board.";
  }
  
  
  
  @GetMapping("/usermenu/{id}")
  public Set<String> userMenu(@PathVariable Long id) {
	  Set<String> menus = new HashSet<>();
	  Optional<User> optionalUser = userRepository.findById(id);
      
      if (optionalUser.isPresent()) {
          User user = optionalUser.get();
          user.getUserRoles().forEach(userRole -> {
        	  MenuRoleRepository.findByRole(userRole.getRole()).forEach(
        			  menuRole -> {
        	        	  menus.add(menuRole.getMenu().getName());
        	          });
          });
      } 
	  
    return menus;
  }
}
