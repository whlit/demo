package cn.whlit.es.repository;

import cn.whlit.spring.es.models.Doc;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @author WangHaiLong 2023/12/16 0:05
 */
@Repository
public interface DocRepository extends ElasticsearchRepository<Doc, Long> {
}
