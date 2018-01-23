package com.documentsmanager.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.documentsmanager.exception.ExceptionHandler;
import com.documentsmanager.model.DocumentBody;
import com.documentsmanager.response.Response;
import com.documentsmanager.service.ElasticService;
import com.documentsmanager.service.RedisService;
import com.documentsmanager.util.JsonUtil;

@RestController
@RequestMapping(value = "/news")
public class NewsController {
	
	private static final Logger logger = LoggerFactory.getLogger(NewsController.class);
	
	@Autowired
	private RedisService redisService;
	
	@Autowired
	private ElasticService elasticService;
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN, MediaType.APPLICATION_XML })
	public ResponseEntity<String> createDocument(@RequestBody DocumentBody request) {
		Response<DocumentBody> _response = new Response<DocumentBody>();
		ResponseEntity<Response<DocumentBody>> response = new ResponseEntity<Response<DocumentBody>>(_response, HttpStatus.OK);
		try {
			
			
			redisService.setValue("document"+request.getId(), request, 60);
			response.getBody().setResult(redisService.getValue("doc"+request.getId()));
			response.getBody().setSuccess(true);
			
		} catch (Exception e) {
			logger.error("NewsController@createDocument exception : ",e);
			response.getBody().setSuccess(false);
			response.getBody().setError(ExceptionHandler.errorResponse(e));
		}
		return new ResponseEntity<String>(JsonUtil.objectToJson(response.getBody()), HttpStatus.OK);	
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN, MediaType.APPLICATION_XML })
	public ResponseEntity<String> updateDocument(@PathVariable("id") String documentId, @RequestBody DocumentBody request) {
		Response<DocumentBody> _response = new Response<DocumentBody>();
		ResponseEntity<Response<DocumentBody>> response = new ResponseEntity<Response<DocumentBody>>(_response, HttpStatus.OK);
		try {
			response.getBody().setResult(request);
			response.getBody().setSuccess(true);
			
		} catch (Exception e) {
			logger.error("NewsController@createDocument exception : ",e);
			response.getBody().setSuccess(false);
			response.getBody().setError(ExceptionHandler.errorResponse(e));
		}
		return new ResponseEntity<String>(JsonUtil.objectToJson(response.getBody()), HttpStatus.OK);	
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN, MediaType.APPLICATION_XML })
	public ResponseEntity<String> getDocument(@PathVariable("id") String documentId) {
		Response<DocumentBody> _response = new Response<DocumentBody>();
		ResponseEntity<Response<DocumentBody>> response = new ResponseEntity<Response<DocumentBody>>(_response, HttpStatus.OK);
		try {
			System.out.println(documentId);
			
		} catch (Exception e) {
			logger.error("NewsController@getDocument exception : ",e);
			response.getBody().setSuccess(false);
			response.getBody().setError(ExceptionHandler.errorResponse(e));
		}
		return new ResponseEntity<String>(JsonUtil.objectToJson(response.getBody()), HttpStatus.OK);	
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN, MediaType.APPLICATION_XML })
	public ResponseEntity<String> deleteDocument(@PathVariable("id") String documentId) {
		Response<DocumentBody> _response = new Response<DocumentBody>();
		ResponseEntity<Response<DocumentBody>> response = new ResponseEntity<Response<DocumentBody>>(_response, HttpStatus.OK);
		try {
			System.out.println(documentId);
			
		} catch (Exception e) {
			logger.error("NewsController@getDocument exception : ",e);
			response.getBody().setSuccess(false);
			response.getBody().setError(ExceptionHandler.errorResponse(e));
		}
		return new ResponseEntity<String>(JsonUtil.objectToJson(response.getBody()), HttpStatus.OK);	
	}
	
}
