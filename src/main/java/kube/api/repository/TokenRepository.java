package kube.api.repository;

import org.springframework.data.repository.CrudRepository;

import ch.qos.logback.core.subst.Token;

public interface TokenRepository extends CrudRepository<Token, Long>{
    
}
