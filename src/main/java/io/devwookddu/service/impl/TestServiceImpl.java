package io.devwookddu.service.impl;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.devwookddu.dao.TestDao;
import io.devwookddu.exception.NumberOfQueryExecutionResultZeroException;
import io.devwookddu.model.Test;
import io.devwookddu.service.TestService;

@Service
public class TestServiceImpl implements TestService{

	private static Logger log = Logger.getLogger(TestServiceImpl.class);
	
	@Inject
	TestDao ctDao;
	
	@Override
	public List<Test> select(Map<String, Object> inputMap) {
		return ctDao.select(inputMap);
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public int insert(List<Test> ctList) throws Exception {
		int count = 0;
		
		for(Test ct : ctList){
			count += ctDao.insert(ct);
			log.info("생성 된 Auto Increment Id : " + ct.getId());
		}
		
		if( count == 0 ) throw new NumberOfQueryExecutionResultZeroException();
		
		return count;
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public int update(List<Test> ctList) throws Exception {
		int count = 0;
		
		for(Test ct : ctList){
			count += ctDao.update(ct);
		}
		
		if( count == 0 ) throw new NumberOfQueryExecutionResultZeroException();

		return count;
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public int delete(List<Test> ctList) throws Exception {
		int count = 0;
		
		for(Test ct : ctList){
			count += ctDao.delete(ct);
		}
		
		if( count == 0 ) throw new NumberOfQueryExecutionResultZeroException();

		return count;
	}

}
