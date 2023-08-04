package com.bezkoder.springjwt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bezkoder.springjwt.models.MenuRole;
import com.bezkoder.springjwt.models.Role;


@Repository
public interface MenuRoleRepository extends JpaRepository<MenuRole, Long> {

	List<MenuRole> findByRole(Role role);
}
