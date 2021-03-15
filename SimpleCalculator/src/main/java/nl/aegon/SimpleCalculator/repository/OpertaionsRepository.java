package nl.aegon.SimpleCalculator.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import nl.aegon.SimpleCalculator.model.Operations;
@Repository
public interface OpertaionsRepository  extends JpaRepository<Operations,Long> {

}
