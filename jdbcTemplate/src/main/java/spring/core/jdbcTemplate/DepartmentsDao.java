package spring.core.jdbcTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;


@Repository
public class DepartmentsDao extends JdbcDaoSupport{

	@Autowired
	public void setDataSource2(DataSource dataSource){
		setDataSource(dataSource);
	}

	public Departments get(Integer id){
		String sql = "SELECT id, dept_name name FROM departments WHERE id = ?";
		RowMapper<Departments> rowMapper = new BeanPropertyRowMapper<Departments>(Departments.class);
		return getJdbcTemplate().queryForObject(sql, rowMapper, id);
	}
	
}
