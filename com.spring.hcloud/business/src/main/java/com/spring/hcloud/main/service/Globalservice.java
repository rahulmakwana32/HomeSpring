package com.spring.hcloud.main.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@Service
public class Globalservice {
	public static Map<String, SseEmitter> sseEmitters = new ConcurrentHashMap<>();

	public   SseEmitter get(String username) {
		return sseEmitters.get(username);
	}

	// Put data in global cache variable
	public void putCache(String key, SseEmitter value) {
		sseEmitters.put(key, value);
	}

	// Put data in global cache variable
	public   void removeCache(String key) {
		sseEmitters.remove(key);
	}
}
