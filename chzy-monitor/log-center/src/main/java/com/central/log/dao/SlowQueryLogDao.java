package com.central.log.dao;

import com.central.log.model.SlowQueryLog;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

/**
 * @author ligy7
 */
@Component
public interface SlowQueryLogDao extends ElasticsearchRepository<SlowQueryLog, String> {

}