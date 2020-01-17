package jwd.wafepa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jwd.wafepa.model.Radnik;

@Repository
public interface RadnikRepository extends JpaRepository<Radnik, Long>{
	
	
	@Query("SELECT r FROM Radnik r WHERE "
			+ "(:idBroj IS NULL OR r.idBroj like :idBroj) AND "
			+ "(:imeIPrezime IS NULL OR r.imeIPrezime like :imeIPrezime) AND "
			+ "(:sektorId IS NULL OR r.sektor.id = :sektorId) "
			)
	Page<Radnik> search(
			@Param("idBroj") String idBroj, 
			@Param("imeIPrezime") String imeIPrezime, 
			@Param("sektorId") Long sektorId, 
			Pageable pageRequest);
	
	

}
