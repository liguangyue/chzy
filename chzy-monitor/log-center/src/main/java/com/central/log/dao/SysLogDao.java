package com.central.log.dao;

import com.central.log.model.SysLog;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

/**
 * @author ligy7
 */
@Component
public interface SysLogDao extends ElasticsearchRepository<SysLog, String> {

}