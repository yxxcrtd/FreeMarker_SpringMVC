package train.springmvc.dao;

import java.sql.Types;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import train.springmvc.domain.Test;
import train.springmvc.util.Pager;

/**
 * Test DAO
 */
@Repository
public class TestDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Test findById(String testId) {
		String sql = "SELECT * FROM \"T_Test\" WHERE \"TestId\" = ?";
		List<Test> list = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Test.class), Integer.valueOf(testId));
		return null == list ? null : list.get(0);
	}
	
	public int findCount() {
		String sql = "SELECT * FROM \"T_Test\"";
		List<Test> list = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Test.class));
		return list.size();
	}
		
	public List<Test> findAll(Pager pager) {
		String sql = "SELECT * FROM \"T_Test\" ORDER BY \"TestId\" DESC limit " + pager.getPageSize() + " offset " + pager.getOffset();
		List<Test> list = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Test.class));
		return list;
	}
	
	public List<Map<String, Object>> getSearchList(final String k) {
		String FIND_BY_NAME = "SELECT * FROM \"T_Test\" WHERE \"TestName\" LIKE \'%" + k + "%\' ORDER BY \"TestId\" DESC";
		return jdbcTemplate.queryForList(FIND_BY_NAME);
	}
	
	public void update(Test test) {
		String sql = "UPDATE \"T_Test\" SET \"TestName\" = ?, \"TestStatus\" = ?, \"TestDate\" = ? WHERE \"TestId\" = ?";
		Object[] args = { test.getTestName(), test.getTestStatus(), test.getTestDate(), test.getTestId() };
		int[] argTypes = { Types.VARCHAR, Types.BOOLEAN, Types.TIMESTAMP, Types.INTEGER };
		jdbcTemplate.update(sql, args, argTypes);
	}
	
	public void save(Test test) {
		String sql = "INSERT INTO \"T_Test\" (\"TestName\", \"TestStatus\", \"TestDate\") VALUES (?, ?, ?)";
		Object[] args = { test.getTestName(), test.getTestStatus(), test.getTestDate() };
		int[] argTypes = { Types.VARCHAR, Types.BOOLEAN, Types.TIMESTAMP };
		jdbcTemplate.update(sql, args, argTypes);
	}
	
	public void delete(String testId) {
		String sql = "DELETE FROM \"T_Test\" WHERE \"TestId\" = ?";
		Object[] args = { Integer.valueOf(testId) };
		int[] argTypes = { Types.INTEGER };
		jdbcTemplate.update(sql, args, argTypes);
	}
	
}
