package com.fxf.es;


import org.apache.http.HttpHost;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

public class TestDemo {

    public static void main(String[] args) throws IOException {
        //获取连接客户端
        RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost("localhost", 9200, "http")));

        //构建请求
        GetRequest getRequest = new GetRequest("book","1");
        //执行
        GetResponse getResponse = client.get(getRequest, RequestOptions.DEFAULT);
        //获取结果
        String id = getResponse.getId();
        System.out.println(id);
        System.out.println(getResponse.getVersion());
        System.out.println(getResponse.getSourceAsString());
    }
}
