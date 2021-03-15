package nl.aegon.SimpleCalculator.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import nl.aegon.SimpleCalculator.model.Operations;

@Repository
public class OperationsRepositoryImpl {

@PersistenceContext
private EntityManager entityManager;


public List<Operations> getRecentHistory(int limit) {
    return entityManager.createQuery("SELECT o FROM Operations o  ORDER BY id desc",
    		Operations.class).setMaxResults(limit).getResultList();
}

}
