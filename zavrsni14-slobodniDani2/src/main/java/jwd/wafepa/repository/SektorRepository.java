package jwd.wafepa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jwd.wafepa.model.Sektor;

@Repository
public interface SektorRepository extends JpaRepository<Sektor, Long>{

}
