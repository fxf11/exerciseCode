package com.fxf.es;


import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.admin.indices.alias.Alias;
import org.elasticsearch.action.admin.indices.close.CloseIndexRequest;
import org.elasticsearch.action.admin.indices.open.OpenIndexRequest;
import org.elasticsearch.action.admin.indices.open.OpenIndexResponse;
import org.elasticsearch.action.support.ActiveShardCount;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.IndicesClient;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
//
//        //设置别名
//        createIndexRequest.alias(new Alias("prod_index"));
//
//        //设置超时时间
//        createIndexRequest.setTimeout(TimeValue.timeValueSeconds(5));
//        //设置主节点超时时间
//        createIndexRequest.setMasterTimeout(TimeValue.timeValueSeconds(5));
//
//        //设置创建索引api返回响应之前等待活动分片的数量
//        createIndexRequest.waitForActiveShards(ActiveShardCount.from(1));
        //执行
        CreateIndexResponse createIndexResponse = client.indices().create(createIndexRequest, RequestOptions.DEFAULT);


        //获取数据
//        boolean acknowledged = createIndexResponse.isAcknowledged();
//        System.out.println(acknowledged);
//        System.out.println(createIndexResponse.isShardsAcknowledged());
//        System.out.println(createIndexResponse);


////        ==================异步======================
//        IndicesClient indices = client.indices();
//        ActionListener<CreateIndexResponse> listener = new ActionListener<CreateIndexResponse>() {
//
//            @Override
//            public void onResponse(CreateIndexResponse createIndexResponse) {
//                boolean acknowledged = createIndexResponse.isAcknowledged();
//                System.out.println(createIndexResponse.isShardsAcknowledged());
//                System.out.println(acknowledged);
//            }
//
//            @Override
//            public void onFailure(Exception e) {
//                e.printStackTrace();
//            }
//        };
//        indices.createAsync(createIndexRequest,RequestOptions.DEFAULT,listener);
    }

    @Test
    public void testExistIndex() throws IOException {
        GetIndexRequest request = new GetIndexRequest("itfxf_book");
        request.local();//冲主节点返回本地索引信息状态
        request.humanReadable(true);//以适合人类的格式返回
        request.includeDefaults(false);//是否返回每个索引的所有默认配置

        boolean exists = client.indices().exists(request, RequestOptions.DEFAULT);
        System.out.println(exists);
    }

    //关闭索引
    @Test
    public void testCloseIndex() throws IOException {
        CloseIndexRequest request = new CloseIndexRequest("my_index");
        AcknowledgedResponse close = client.indices().close(request, RequestOptions.DEFAULT);
        boolean ack = close.isAcknowledged();
        System.out.println(ack);

    }

    @Test
    public void testOpenIndex() throws IOException {
        OpenIndexRequest request = new OpenIndexRequest("my_index");
        OpenIndexResponse open = client.indices().open(request, RequestOptions.DEFAULT);
        System.out.println(open.isAcknowledged());
    }

    @Test
    public void test3(){
        ArrayList<String> list1 = new ArrayList();
        list1.add("1");
        list1.add("2");
        list1.add("3");
        list1.add("4");
        ArrayList<String> list2 = new ArrayList();
        list2.add("5");
        list2.add("6");
        list2.add("7");
        list2.add("8");

        System.out.println(list1.get(0));
        list1.add(list2.get(0));
        list2.remove(0);

        System.out.println(String.join(",",list1));
        System.out.println(String.join(",",list2));
    }

}
