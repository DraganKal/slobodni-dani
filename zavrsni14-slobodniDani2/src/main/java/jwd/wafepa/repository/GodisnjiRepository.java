package jwd.wafepa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jwd.wafepa.model.Godisnji;

@Repository
public interface GodisnjiRepository extends JpaRepository<Godisnji, Long>{

}
