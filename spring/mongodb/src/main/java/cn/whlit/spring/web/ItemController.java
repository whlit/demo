package cn.whlit.spring.web;

import cn.whlit.spring.domain.Geo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;

/**
 * @author WangHaiLong 2024/12/24 13:17
 */
@RestController
public class ItemController {
    @Autowired
    private MongoTemplate mongoTemplate;
    
    @Autowired
    private ReactiveMongoTemplate reactiveMongoTemplate;

    private final AtomicBoolean flag = new AtomicBoolean(false);

    @GetMapping("test")
    public String test() {

        if (!flag.compareAndSet(false, true)) {
            return "";
        }


//        MongoCollection<Document> itemCollection = mongoTemplate.getCollection("item");
//        FindIterable<Document> documents = itemCollection.find();
//        AggregationResults<Integer> type = mongoTemplate.aggregate(Aggregation.newAggregation(Aggregation.match(Criteria.where("type").is(0))), "", Integer.class);
//
//
//        mongoTemplate.query(Geo.class).inCollection("item").matching(Query.query(Criteria.where("type").is(0)));
//        List<Geo> geos = new ArrayList<>();
//        documents.forEach(document -> {
//            Geo geo = new GeoAdapter(document);
//            geos.add(geo);
//            if (geos.size() >= 100) {
//                // insert into pg
//
//                geos.clear();
//            }
//        });
//        // insert into pg
//
//        Query query = new Query();
//        query.addCriteria(Criteria.where("type").is(0));
//        query.with(Sort.by(Sort.Direction.ASC, "id"));
//        long count = mongoTemplate.count(query, Geo.class, "item");
//        int limit = 100;
//        query.limit(limit);
//        for (int i = 0; (long) (i - 1) * limit < count; i++) {
//            query.skip((long) i * limit);
//            List<Geo> list = mongoTemplate.find(query, Geo.class, "item");
//        }
//

        batchConsume("item", Query.query(Criteria.where("type").is(0)), Geo.class, geos -> {
            // 这里的获取到的是这一批次的数据，
        });
        return "test";
    }

    public <T> void batchConsume(String collection, Query query, Class<T> clazz, Consumer<List<T>> consumer) {
        List<T> list = new ArrayList<>();
        if (query.getMeta().getCursorBatchSize() == null || query.getMeta().getCursorBatchSize() < 1) {
            query.cursorBatchSize(100);
        }
        mongoTemplate.query(clazz).inCollection(collection).matching(query).stream().forEach(item -> {
            list.add(item);
            if (list.size() >= query.getMeta().getCursorBatchSize()) {
                consumer.accept(list);
                list.clear();
            }
        });
        if (!list.isEmpty()) {
            consumer.accept(list);
        }
    }

    public <T> void batchQuery(String collection, Query query, int batchSize, Class<T> clazz, Consumer<List<T>> consumer) {
        query.skip(0);
        query.limit(batchSize);
        List<T> list;
        while (!(list = mongoTemplate.query(clazz).inCollection(collection).matching(query).all()).isEmpty()) {
            consumer.accept(list);
            query.skip(query.getSkip() + batchSize);
        }
    }
}
