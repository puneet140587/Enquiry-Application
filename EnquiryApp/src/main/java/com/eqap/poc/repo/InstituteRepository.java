package com.eqap.poc.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.eqap.poc.dto.InstituteDTO;
import com.eqap.poc.entity.Institute;

public interface InstituteRepository extends JpaRepository<Institute, Long> {

	@Query(" SELECT i.instituteId AS instituteId, i.name AS name, i.contact.phone AS phone, i.contact.email AS email, i.contact.permanentAddress.city AS city FROM Institute AS i")
	public List<InstituteDTO> getInstList();

	@Query("SELECT new com.eqap.poc.entity.Institute(i.instituteId, i.name)  FROM Institute AS i")
	public List<Institute> getCustomInstituteList();

}