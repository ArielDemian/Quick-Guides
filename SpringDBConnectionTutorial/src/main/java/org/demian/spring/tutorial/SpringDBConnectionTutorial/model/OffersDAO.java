package org.demian.spring.tutorial.SpringDBConnectionTutorial.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.PreDestroy;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class OffersDAO {
	private NamedParameterJdbcTemplate jdbc;
	RowMapper<Offer> rowMapper = new RowMapper<Offer>() {
		public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
			Offer offer = new Offer();
			offer.setId(rs.getInt("id"));
			offer.setName(rs.getString("name"));
			offer.setEmail(rs.getString("email"));
			offer.setText(rs.getString("text"));
			return offer;
		}
	};

	public List<Offer> getOffers() {
		return jdbc.query("SELECT * FROM offer", rowMapper);
	}

	public Offer getOffer(int id) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);
		return jdbc.queryForObject("SELECT * FROM offer WHERE id = :id", params, rowMapper);
	}

	public boolean delete(int id) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);
		return jdbc.update("DELETE from offer WHERE id = :id", params) == 1;
	}

	public boolean insert(Offer offer) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);
		KeyHolder keyHolder = new GeneratedKeyHolder();
		if (jdbc.update("INSERT INTO offer(name,email,text) VALUES(:name,:email,:text)", params, keyHolder) == 1) {
			offer.setId(keyHolder.getKey().intValue());
			return true;
		} else
			return false;
	}

	@Transactional
	public int[] insert(List<Offer> offers) {
		String query = "INSERT INTO offer(name,email,text) VALUES(:name,:email,:text)";
		SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(offers.toArray());
		return jdbc.batchUpdate(query, params);
	}

	public boolean update(Offer offer) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);
		String query = "UPDATE offer SET name = :name, text = :text, email = :email WHERE id = :id";
		return jdbc.update(query, params) == 1;
	}

	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	@PreDestroy
	public void destroy() {
		System.out.println("OffersDAO is being destroyed!");
	}
}