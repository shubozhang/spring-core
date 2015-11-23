package spring.core.jdbcTemplate;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
	
	private ApplicationContext ctx = null;
	private JdbcTemplate jdbcTemplate;
	private EmployeesDao employeesDao;
	private DepartmentsDao departmentsDao;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;{
		ctx = new ClassPathXmlApplicationContext("jdbc.xml");
		jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
		employeesDao = ctx.getBean(EmployeesDao.class);
		departmentsDao = ctx.getBean(DepartmentsDao.class);
		namedParameterJdbcTemplate = ctx.getBean(NamedParameterJdbcTemplate.class);
	}
	

	@Test
	public void testNamedParameterJdbcTemplate2(){
		String sql = "INSERT INTO employees(last_name, email, dept_id) "
				+ "VALUES(:lastName,:email,:dpetId)";
		
		Employees employee = new Employees();
		employee.setLastName("XYZ");
		employee.setEmail("xyz@sina.com");
		employee.setDpetId(3);
		
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(employee);
		namedParameterJdbcTemplate.update(sql, paramSource);
	}
	

	@Test
	public void testNamedParameterJdbcTemplate(){
		String sql = "INSERT INTO employees(last_name, email, dept_id) VALUES(:ln,:email,:deptid)";
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("ln", "FF");
		paramMap.put("email", "ff@atguigu.com");
		paramMap.put("deptid", 2);
		
		namedParameterJdbcTemplate.update(sql, paramMap);
	}
	
	@Test
	public void testDepartmentDao(){
		System.out.println(departmentsDao.get(1));
	}
	
	@Test
	public void testEmployeeDao(){
		System.out.println(employeesDao.get(1));
	}
	

	@Test
	public void testQueryForObject2(){
		String sql = "SELECT count(id) FROM employees";
		long count = jdbcTemplate.queryForObject(sql, Long.class);
		
		System.out.println(count);
	}
	

	@Test
	public void testQueryForList(){
		String sql = "SELECT id, last_name lastName, email FROM employees WHERE id > ?";
		RowMapper<Employees> rowMapper = new BeanPropertyRowMapper<Employees>(Employees.class);
		List<Employees> employees = jdbcTemplate.query(sql, rowMapper,5);
		
		System.out.println(employees);
	}

	@Test
	public void testQueryForObject(){
		String sql = "SELECT id, last_name lastName, email, dept_id as \"department.id\" FROM employees WHERE id = ?";
		RowMapper<Employees> rowMapper = new BeanPropertyRowMapper<Employees>(Employees.class);
		Employees employee = jdbcTemplate.queryForObject(sql, rowMapper, 1);
		
		System.out.println(employee);
	}
	

	@Test
	public void testBatchUpdate(){
		String sql = "INSERT INTO employees(last_name, email, dept_id) VALUES(?,?,?)";
		
		List<Object[]> batchArgs = new ArrayList<Object[]>();
		
		batchArgs.add(new Object[]{"AA", "aa@atguigu.com", 1});
		batchArgs.add(new Object[]{"BB", "bb@atguigu.com", 2});
		batchArgs.add(new Object[]{"CC", "cc@atguigu.com", 3});
		batchArgs.add(new Object[]{"DD", "dd@atguigu.com", 3});
		batchArgs.add(new Object[]{"EE", "ee@atguigu.com", 2});
		
		jdbcTemplate.batchUpdate(sql, batchArgs);
	}
	

	@Test
	public void testUpdate(){
		String sql = "UPDATE employees SET last_name = ? WHERE id = ?";
		jdbcTemplate.update(sql, "Jack", 5);
	}
	
	@Test
	public void testDataSource() throws SQLException {
		DataSource dataSource = ctx.getBean(DataSource.class);
		System.out.println(dataSource.getConnection());
	}

}
