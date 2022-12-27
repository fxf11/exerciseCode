package com.fxf.es;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.*;
import org.elasticsearch.index.search.MatchQuery;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.elasticsearch.search.suggest.SuggestBuilder;
import org.elasticsearch.search.suggest.SuggestBuilders;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @Classname TestSearch
 * @Description TODO
 * @Version 1.0.0
 * @Date 2021/10/31 15:12
 * @Created by 饭小范
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestSearch {

    @Autowired
    RestHighLevelClient client;

    //搜索全部记录
    @Test
    public void testSearchAll() throws IOException {

        //构建搜索请求
        SearchRequest book = new SearchRequest("book");

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchAllQuery());

        //获取某些字段
        searchSourceBuilder.fetchSource(new String[]{"name"},new String[]{});


        SearchResponse search = client.search(book, RequestOptions.DEFAULT);

        SearchHits hits = search.getHits();
        SearchHit[] hits1 = hits.getHits();
        for (SearchHit documentFields : hits1) {
            String id = documentFields.getId();
            float score = documentFields.getScore();
            Map<String, Object> sourceAsMap = documentFields.getSourceAsMap();
            String name = (String) sourceAsMap.get("name");
            String description = (String) sourceAsMap.get("description");
            Double price = (Double) sourceAsMap.get("price");
            System.out.println(name);
            System.out.println(description);
            System.out.println(price);
        }
    }

    //搜索分页
    @Test
    public void testSearchPage() throws IOException {

        //构建搜索请求
        SearchRequest book = new SearchRequest("book");

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
//        searchSourceBuilder.query(QueryBuilders.matchAllQuery());

        searchSourceBuilder.query(QueryBuilders.idsQuery().addIds("1","4","100"));

        //获取某些字段
        searchSourceBuilder.fetchSource(new String[]{"name"},new String[]{});


        searchSourceBuilder.from(0);
        searchSourceBuilder.size(2);
        book.source(searchSourceBuilder);

        SearchResponse search = client.search(book, RequestOptions.DEFAULT);

        SearchHits hits = search.getHits();
        SearchHit[] hits1 = hits.getHits();
        for (SearchHit documentFields : hits1) {
            String id = documentFields.getId();
            float score = documentFields.getScore();
            Map<String, Object> sourceAsMap = documentFields.getSourceAsMap();
            String name = (String) sourceAsMap.get("name");
            String description = (String) sourceAsMap.get("description");
            Double price = (Double) sourceAsMap.get("price");
            System.out.println(name);
            System.out.println(description);
            System.out.println(price);
        }
    }

    //muti_match搜索
    @Test
    public void testSearchMultiMatch() throws IOException {

        //构建搜索请求
        SearchRequest book = new SearchRequest("book");

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
//        searchSourceBuilder.query(QueryBuilders.matchAllQuery());

//        searchSourceBuilder.query(QueryBuilders.idsQuery().addIds("1","4","100"));

        searchSourceBuilder.query(QueryBuilders.multiMatchQuery("java程序员","name","description"));
        //获取某些字段
//        searchSourceBuilder.fetchSource(new String[]{"name"},new String[]{});


        searchSourceBuilder.from(0);
        searchSourceBuilder.size(2);
        book.source(searchSourceBuilder);

        SearchResponse search = client.search(book, RequestOptions.DEFAULT);

        SearchHits hits = search.getHits();
        SearchHit[] hits1 = hits.getHits();
        for (SearchHit documentFields : hits1) {
            String id = documentFields.getId();
            float score = documentFields.getScore();
            Map<String, Object> sourceAsMap = documentFields.getSourceAsMap();
            String name = (String) sourceAsMap.get("name");
            String description = (String) sourceAsMap.get("description");
            Double price = (Double) sourceAsMap.get("price");
            System.out.println(name);
            System.out.println(description);
            System.out.println(price);
        }
    }

    @Test
    public void test112() throws IOException {
//        double diamonSalary = 12.00 + new BigDecimal(1499.00).divide(new BigDecimal(1500), BigDecimal.ROUND_DOWN).doubleValue();
//        System.out.println(diamonSalary);

        //准备request
        SearchRequest request = new SearchRequest("hotel");
        //DSL
//        request.source().suggest(new SuggestBuilder().addSuggestion("suggestions", SuggestBuilders.completionSuggestion("suggestion").prefix("h").skipDuplicates(true).size(10)));

        request.source().size(0);
        //聚合
        request.source().aggregation(AggregationBuilders.terms("brandAgg").field("brand").size(10));
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        //解析聚合结果
        Aggregations aggregations = response.getAggregations();
        //根据名称获取聚合结果
        Terms brandAgg = aggregations.get("brandAgg");
        //获取桶
        List<? extends Terms.Bucket> buckets = brandAgg.getBuckets();
        //遍历
        for (Terms.Bucket bucket : buckets) {
            System.out.println(bucket.getKeyAsString());
        }


    }
    //bool搜索
    @Test
    public void testSearchBool() throws IOException {


        //构建搜索请求
        SearchRequest book = new SearchRequest("book");

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        MultiMatchQueryBuilder multiMatchQueryBuilder = QueryBuilders.multiMatchQuery("java程序员", "name", "description");
        MatchQueryBuilder matchQuery = QueryBuilders.matchQuery("studymodel", "201001");
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        boolQueryBuilder.must(multiMatchQueryBuilder);
        boolQueryBuilder.should(matchQuery);

        //
        boolQueryBuilder.filter(QueryBuilders.rangeQuery("price").gte(50).lte(90));
        searchSourceBuilder.query(boolQueryBuilder);
        //排序
        searchSourceBuilder.sort("price", SortOrder.DESC);
        //获取某些字段
//        searchSourceBuilder.fetchSource(new String[]{"name"},new String[]{});


        searchSourceBuilder.from(0);
        searchSourceBuilder.size(2);
        book.source(searchSourceBuilder);

        SearchResponse search = client.search(book, RequestOptions.DEFAULT);

        //获取结果
        SearchHits hits = search.getHits();
        SearchHit[] hits1 = hits.getHits();
        for (SearchHit documentFields : hits1) {
            String id = documentFields.getId();
            float score = documentFields.getScore();
            Map<String, Object> sourceAsMap = documentFields.getSourceAsMap();
            String name = (String) sourceAsMap.get("name");
            String description = (String) sourceAsMap.get("description");
            Double price = (Double) sourceAsMap.get("price");
            System.out.println(name);
            System.out.println(description);
            System.out.println(price);
        }
    }
}



