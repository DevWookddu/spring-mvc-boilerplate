package io.devwookddu.dao;

import java.util.List;
import java.util.Map;

import io.devwookddu.model.Test;

public interface TestDao {
	
	public List<Test> select(Map<String, Object> inputMap);
	
	public int insert(Test ct);
	
	public int update(Test ct);
	
	public int delete(Test ct);
}
