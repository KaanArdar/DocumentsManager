package com.documentsmanager.service;

import java.io.IOException;

import com.documentsmanager.model.DocumentBody;

public interface ElasticService {
	
	void save(String index, String type, DocumentBody documentBody)throws IOException;
	DocumentBody findId(String index, String type, long id)throws IOException;

}
