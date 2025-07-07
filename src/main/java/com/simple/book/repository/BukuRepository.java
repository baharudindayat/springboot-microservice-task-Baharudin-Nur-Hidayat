package com.simple.book.repository;

import com.simple.book.model.entity.Books;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BukuRepository {

    private final JdbcTemplate jdbcTemplate;

    public BukuRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;

    }

    private final RowMapper<Books> bukuRowMapper = (rs, rowNum) -> {
        Books buku = new Books();
        buku.setId(rs.getLong("id"));
        buku.setTitle(rs.getString("title"));
        buku.setAuthor(rs.getString("author"));
        buku.setIsbn(rs.getString("isbn"));
        buku.setPublishedDate(rs.getDate("published_date"));
        return buku;
    };

    public List<Books> findAll() {
        String sql = "SELECT * FROM books";
        return jdbcTemplate.query(sql, bukuRowMapper);
    }

    public Books findById(Long id) {
        String sql = "SELECT * FROM books WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, bukuRowMapper);
    }

    public int count() {
        String sql = "SELECT COUNT(*) FROM books";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }
}
