package com.ercancan.es.repository.elasticsearch;

import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;
import com.ercancan.es.model.WebUser;

import java.util.List;

@Repository
public interface WebUserElasticRepository extends ElasticsearchRepository<WebUser, Long> {

    @Query("{\"query\": {\"multi_match\":{\"fields\":[\"*\"],\"lenient\":\"true\",\"query\":\"?0\",\"type\":\"phrase_prefix\"}}}")
    List<WebUser> findByQuery(String name);

}
