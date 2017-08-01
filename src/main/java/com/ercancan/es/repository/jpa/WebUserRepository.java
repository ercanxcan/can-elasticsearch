package com.ercancan.es.repository.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.ercancan.es.model.WebUser;

@Repository
public interface WebUserRepository extends CrudRepository<WebUser, Long> {

}
