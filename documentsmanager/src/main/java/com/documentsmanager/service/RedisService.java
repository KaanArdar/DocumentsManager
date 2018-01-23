package com.documentsmanager.service;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.documentsmanager.model.DocumentBody;

@Service
public class RedisService{
	
	@Autowired
	private RedisTemplate<String, DocumentBody> template;

	public void setValue(String key, DocumentBody value) {
		template.opsForValue().set(key, value);	
	}

	public void setValue(String key, DocumentBody value, long expireTime) {
		template.opsForValue().set(key, value, expireTime, TimeUnit.SECONDS);		
	}

	public DocumentBody getValue(String key) {
		return template.opsForValue().get(key);
	}

}
