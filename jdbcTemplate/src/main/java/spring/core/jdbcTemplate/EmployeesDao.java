package spring.core.jdbcTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeesDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Employees get(Integer id){
		String sql = "SELECT id, last_name lastName, email FROM employees WHERE id = ?";
		RowMapper<Employees> rowMapper = new BeanPropertyRowMapper<Employees>(Employees.class);
		Employees employee = jdbcTemplate.queryForObject(sql, rowMapper, id);
		
		return employee;
	}
}
