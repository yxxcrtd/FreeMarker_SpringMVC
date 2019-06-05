package train.springmvc.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import train.springmvc.dao.TestDao;
import train.springmvc.domain.Test;
import train.springmvc.util.Pager;

/**
 * test Service
 */
@Service
public class TestService {
	
	@Autowired
	private TestDao testDao;

	public Test findById(String testId) {
		return testDao.findById(testId);
	}
	
	public int findCount() {
		return testDao.findCount();
	}

	public List<Test> findAll(Pager pager) {
		return testDao.findAll(pager);
	}

	public List<Map<String, Object>> getSearchList(String k) {
		return testDao.getSearchList(k);
	}

	public void update(Test test) {
		testDao.update(test);
	}

	public void save(Test test) {
		testDao.save(test);
	}

	public void delete(String testId) {
		testDao.delete(testId);
	}

}
