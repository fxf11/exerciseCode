package com.fxf.es;


import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.admin.indices.alias.Alias;
import org.elasticsearch.action.support.ActiveShardCount;
import org.elasticsearch.client.IndicesClient;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest(classes = SearchApplication.class)
@RunWith(SpringRunner.class)
public class TestIndex {

    @Autowired
    RestHighLevelClient client;

    /**
     * 创建索引
     */
    @Test
    public void testCreateIndex() throws IOException {

        //创建请求
        CreateIndexRequest createIndexRequest = new CreateIndexRequest("fxf_index");
        //设置参数
        createIndexRequest.settings(Settings.builder().put("number_of_shards", "1").put("number_of_replicas", "1").build());
        //指定映射1
        createIndexRequest.mapping("{\n" +
                "    \"properties\": {\n" +
                "      \"field1\":{\n" +
                "        \"type\":\"text\"\n" +
                "      },\n" +
                "      \"field2\":{\n" +
                "        \"type\":\"text\"\n" +
                "      }\n" +
                "    }\n" +
                "  }", XContentType.JSON);

//        //指定映射2
//        HashMap<String, Object> map1 = new HashMap<String, Object>();
//        Map<String, Object> field1 = map1;
//        field1.put("type","text");
//        field1.put("analyzer","standard");
//        Map<String, Object> field2 = map1;
//        field2.put("type","text");
//
//        Map<String, Object> map = map1;
//        map.put("field1",field1);
//        map.put("field2",field2);
//
//        map1.put("properties",map);
//
//        createIndexRequest.mapping(map1);
//
//
//        //指定映射3
//        XContentBuilder builder = XContentFactory.jsonBuilder();
//        builder.startObject();
//        {
//            builder.startObject("properties");
//            {
//                builder.startObject("field1");
//                {
//                    builder.field("type","text");
//                }
//                builder.endObject();
//                builder.startObject("field2");
//                {
//                    builder.field("type","text");
//                }
//                builder.endObject();
//            }
//            builder.endObject();
//        }
//        builder.endObject();
//        createIndexRequest.mapping(builder);

        //设置别名
        createIndexRequest.alias(new Alias("prod_index"));

        //设置超时时间
        createIndexRequest.setTimeout(TimeValue.timeValueSeconds(5));
        //设置主节点超时时间
        createIndexRequest.setMasterTimeout(TimeValue.timeValueSeconds(5));

        //设置创建索引api返回响应之前等待活动分片的数量
        createIndexRequest.waitForActiveShards(ActiveShardCount.from(1));
        //执行
//        CreateIndexResponse createIndexResponse = client.indices().create(createIndexRequest, RequestOptions.DEFAULT);


        //获取数据
//        boolean acknowledged = createIndexResponse.isAcknowledged();
//        System.out.println(acknowledged);
//        System.out.println(createIndexResponse.isShardsAcknowledged());
//        System.out.println(createIndexResponse);


//        ==================异步======================
        IndicesClient indices = client.indices();
        ActionListener<CreateIndexResponse> listener = new ActionListener<CreateIndexResponse>() {

            @Override
            public void onResponse(CreateIndexResponse createIndexResponse) {
                boolean acknowledged = createIndexResponse.isAcknowledged();
                System.out.println(createIndexResponse.isShardsAcknowledged());
                System.out.println(acknowledged);
            }

            @Override
            public void onFailure(Exception e) {
                e.printStackTrace();
            }
        };
        indices.createAsync(createIndexRequest,RequestOptions.DEFAULT,listener);
    }
}
