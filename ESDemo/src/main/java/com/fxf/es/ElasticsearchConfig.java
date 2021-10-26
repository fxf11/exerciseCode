package com.fxf.es;


import org.apache.http.HttpHost;
import org.apache.http.client.methods.HttpPost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.rest.action.cat.RestHealthAction;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticsearchConfig {

    @Value("${fxf.elasticsearch.hostlist}")
    private String hostlist;

    @Bean(destroyMethod = "close")
    public RestHighLevelClient restHighLevelClient(){
        String[] split = hostlist.split(",");
        HttpHost[] httpPosts = new HttpHost[split.length];

        for (int i = 0; i < split.length; i++) {

            String item = split[i];
            httpPosts[i] = new HttpHost(item.split(":")[0], Integer.parseInt(item.split(":")[1]), "http");
        }

        return new RestHighLevelClient(RestClient.builder(httpPosts));
    }
}
