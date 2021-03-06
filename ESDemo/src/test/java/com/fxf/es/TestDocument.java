package com.fxf.es;


import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.support.replication.ReplicationResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.Strings;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.Index;
import org.elasticsearch.index.VersionType;
import org.elasticsearch.search.fetch.subphase.FetchSourceContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.HashMap;

@SpringBootTest(classes = SearchApplication.class)
@RunWith(SpringRunner.class)
public class TestDocument {

    @Autowired
    private RestHighLevelClient client;

    @Test
    public void testGet() throws IOException {
        GetRequest getRequest = new GetRequest("book","1");

//        String[] includes = new String[]{"name","description"};
//        String[] excludes = Strings.EMPTY_ARRAY;
//        FetchSourceContext fetchSourceContext = new FetchSourceContext(true, includes, excludes);
//        getRequest.fetchSourceContext(fetchSourceContext);
//
//        try {
//            GetResponse getResponse = client.get(getRequest, RequestOptions.DEFAULT);
//            System.out.println(getResponse.getSourceAsString());
//            System.out.println(getResponse.getVersion());
//            System.out.println(getResponse.getId());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //------------------??????????????????-------------------
//        ActionListener<GetResponse> listener = new ActionListener<GetResponse>() {
//            //???????????????
//            @Override
//            public void onResponse(GetResponse getResponse) {
//                System.out.println(getResponse.getId());
//                System.out.println(getResponse.getVersion());
//                System.out.println(getResponse.getSourceAsString());
//            }
//            //???????????????
//            @Override
//            public void onFailure(Exception e) {
//                e.printStackTrace();
//            }
//        };
//        client.getAsync(getRequest,RequestOptions.DEFAULT,listener);
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        //------------------??????????????????-------------------

        //????????????
        GetResponse getResponse = client.get(getRequest, RequestOptions.DEFAULT);
        if (getResponse.isExists()){
            System.out.println(getResponse.getSourceAsString());
            System.out.println(getResponse.getVersion());
            System.out.println(getResponse.getId());
        }
    }

    @Test
    public void testAdd() throws IOException {

        IndexRequest request = new IndexRequest("test_posts");
        request.id("1");

        //        =======================????????????============================
//        ????????????1
        String jsonString="{\n" +
                "  \"user\":\"tomas J\",\n" +
                "  \"postDate\":\"2019-07-18\",\n" +
                "  \"message\":\"trying out es3\"\n" +
                "}";
        request.source(jsonString, XContentType.JSON);
////        ????????????2
//        HashMap<String, Object> map = new HashMap<String, Object>();
//        map.put("user","tomas");
//        map.put("postDate","2019-7-18");
//        map.put("mesage","trying out es1");
//        request.source(map);
//        //????????????3
//        XContentBuilder builder = XContentFactory.jsonBuilder();
//        builder.startObject();
//        {
//            builder.field("user","tomas");
//            builder.field("message","trying out es3");
//            builder.timeField("postDate","2019-7-19");
//        }
//
//        builder.endObject();
//        request.source(builder);
//        //        ????????????4
//        request.source("user","tomas","message","trying out es3","postDate","2019-7-19");


//        ????????????
        request.timeout("1s");
        request.timeout(TimeValue.timeValueSeconds(1));
        //?????????????????????
        request.version(2);
        request.versionType(VersionType.EXTERNAL);

//        ????????????
        final IndexResponse index = client.index(request, RequestOptions.DEFAULT);

        //????????????
//        ActionListener<IndexResponse> actionListener = new ActionListener<IndexResponse>() {
//
//            @Override
//            public void onResponse(IndexResponse indexResponse) {
//                String id = indexResponse.getId();
//                System.out.println(id);
//
//            }
//
//            @Override
//            public void onFailure(Exception e) {
//
//            }
//        };
//
//
//        client.indexAsync(request,RequestOptions.DEFAULT,actionListener);
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

//        ????????????
        String id = index.getId();
        System.out.println(id);

        if (index.getResult() == DocWriteResponse.Result.CREATED){
            DocWriteResponse.Result result = index.getResult();
            System.out.println("CREATE"+result);
        }else if (index.getResult() == DocWriteResponse.Result.UPDATED){
            DocWriteResponse.Result result = index.getResult();
            System.out.println("UPDATE"+result);
        }

        ReplicationResponse.ShardInfo shardInfo = index.getShardInfo();
        if (shardInfo.getTotal() != shardInfo.getSuccessful()){
            System.out.println("??????????????????????????????????????????");
        }
        if (shardInfo.getFailed() > 0){
            for (ReplicationResponse.ShardInfo.Failure failure : shardInfo.getFailures()) {
                String reason = failure.reason();
                System.out.println(reason);//??????????????????
            }
        }

    }

    @Test
    public void testUpdate() throws IOException {
        UpdateRequest request = new UpdateRequest("test_posts","1");
        ////        ????????????2
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("user","tomas lee");
        request.doc(map);
        request.timeout("1s");
        request.retryOnConflict(3);//??????????????????
        UpdateResponse update = client.update(request, RequestOptions.DEFAULT);

        System.out.println(update.getResult().toString());
        System.out.println(update.getIndex());
        if (update.getResult() == DocWriteResponse.Result.CREATED){
            DocWriteResponse.Result result = update.getResult();
            System.out.println("CREATE???"+result);
        }else if (update.getResult() == DocWriteResponse.Result.UPDATED){
            DocWriteResponse.Result result = update.getResult();
            System.out.println("UPDATE???"+result);
        }else if (update.getResult() == DocWriteResponse.Result.DELETED){
            DocWriteResponse.Result result = update.getResult();
            System.out.println("DELETED???"+result);
        }else if (update.getResult() == DocWriteResponse.Result.NOOP){
            DocWriteResponse.Result result = update.getResult();
            System.out.println("NOOP???"+result);
        }
    }

    @Test
    public void testDelete(){

    }

    @Test
    public void testBulk() throws IOException {
        BulkRequest bulkRequest = new BulkRequest();
        bulkRequest.add(new IndexRequest("post").id("1").source(XContentType.JSON,"field","1"));

        //??????
        BulkResponse bulk = client.bulk(bulkRequest, RequestOptions.DEFAULT);
    }


}
