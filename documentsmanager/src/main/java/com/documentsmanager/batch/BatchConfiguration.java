package com.documentsmanager.batch;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.documentsmanager.model.DocumentBody;
import com.documentsmanager.service.RedisService;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {
	
	private static final Logger logger = LoggerFactory.getLogger(BatchConfiguration.class);
	
	@Autowired
	private RedisService redisService;
	
//	@Autowired
//	private ElasticService elasticService;

	@Bean
	public List<DocumentBody> reader() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(Feature.AUTO_CLOSE_SOURCE, true);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		TypeReference<List<DocumentBody>> typeReference = new TypeReference<List<DocumentBody>>(){};
		List<DocumentBody> documentBodys = null;
		try {
			documentBodys= mapper.readValue(new File("./json/DocumentBody.json"),typeReference);
			for (DocumentBody documentBody : documentBodys) {
//				elasticService.save("documets", "content", documentBody);
				redisService.setValue("document_"+documentBody.getId(), documentBody, 60*60);
			}
		} catch (IOException e){
			logger.error("BatchConfiguration@reader Exception : ",e);
		}
		return documentBodys;
    }

}
