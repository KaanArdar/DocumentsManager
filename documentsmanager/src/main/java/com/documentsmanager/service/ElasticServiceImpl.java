package com.documentsmanager.service;

import java.io.IOException;
import java.util.Collections;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig.Builder;
import org.apache.http.entity.ContentType;
import org.apache.http.nio.entity.NStringEntity;
import org.apache.http.util.EntityUtils;

import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.documentsmanager.model.Document;
import com.documentsmanager.model.DocumentBody;
import com.documentsmanager.util.JsonUtil;

@Service
public class ElasticServiceImpl implements ElasticService{
	
	@Value("${elasticsearch.host}")
	private String elasticSearchHost;
	
	@Value("${elasticsearch.port}")
	private int elasticSearchPort;
	
	private static Logger logger = LoggerFactory.getLogger(ElasticServiceImpl.class);
	
	private RestClient restClient;
	
	@Bean
	public RestClient restClientBuilder() {					
			return this.restClient = RestClient.builder(new HttpHost(elasticSearchHost, elasticSearchPort, "http")).setRequestConfigCallback(new RestClientBuilder.RequestConfigCallback() {
				
				public Builder customizeRequestConfig(Builder requestConfigBuilder) {
					 return requestConfigBuilder.setConnectTimeout(5000)
		                        .setSocketTimeout(60000);
				}
			}).setMaxRetryTimeoutMillis(60000)
	        .build();
	}

	public void save(String index, String type, DocumentBody documentBody) throws IOException {
		HttpEntity entity = new NStringEntity(JsonUtil.objectToJson(documentBody), ContentType.APPLICATION_JSON);
		try {
			restClient.performRequest("POST","/"+index+"/"+type+"/"+documentBody.getId(),Collections.<String, String>emptyMap(),entity);
			logger.info("ElasticServiceImpl@save successful..");
		} catch (IOException e) {
			throw new IOException(e.getMessage());
		}	
	}

	public DocumentBody findId(String index, String type, long id) throws IOException {
		Document doc = null;
		try {
			Response resp = restClient.performRequest("GET","/"+index+"/"+type+"/"+id,Collections.<String, String>emptyMap());
			doc = (Document) JsonUtil.jsonToObject(EntityUtils.toString(resp.getEntity()),Document.class);
			
			logger.info("ElasticServiceImpl@findId successful..");
		} catch (IOException e) {
			throw new IOException(e.getMessage());
		}	
		return (doc.get_source() != null ? doc.get_source() : null);
	}

}
