package com.search.api.config;
import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.springframework.context.annotation.*;
@Configuration
public class ElasticConfig {
 @Bean
 public ElasticsearchClient client(){
  RestClient rc=RestClient.builder(new HttpHost("localhost",9200)).build();
  return new ElasticsearchClient(new RestClientTransport(rc,new JacksonJsonpMapper()));
 }
}