package com.sulcacorp.farmacia.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sulcacorp.farmacia.model.Persona;


@Repository
public interface IPersonaDAO extends JpaRepository<Persona, Long>{
	
	@Query("from Persona a where a.estado = '1' order by a.nombres asc, a.apePaterno asc, a.apeMaterno asc")
	List<Persona> findAllAct();
	
	@Query("From Persona a where a.numeroDoc =:docNumber order by a.nombres asc, a.apePaterno asc, a.apeMaterno asc")			
	Persona findByDocNumber(@Param("docNumber") String docNumber);

	@Query("From Persona a where concat(a.nombres, ' ', a.apePaterno, ' ', a.apePaterno) like %:fullName% order by a.nombres asc, a.apePaterno asc, a.apeMaterno asc")
	List<Persona> findByFullname(@Param("fullName") String fullName);

	@Query("From Persona a where a.tipoDocIdentidad.id =:typeDoc and a.numeroDoc =:docNumber order by a.nombres asc, a.apePaterno asc, a.apeMaterno asc")
	Persona findByTypeAndDocNumber(@Param("typeDoc") Long typeDOc, @Param("docNumber") String docNumber);

}
