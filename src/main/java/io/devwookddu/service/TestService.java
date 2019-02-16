package io.devwookddu.service;

import java.util.List;
import java.util.Map;

import io.devwookddu.model.Test;

public interface TestService {
	
	public List<Test> select(Map<String, Object> inputMap);
	
	public int insert(List<Test> ctList) throws Exception;
	
	public int update(List<Test> ctList) throws Exception;
	
	public int delete(List<Test> ctList) throws Exception;
}
