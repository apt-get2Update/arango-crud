package com.arango.service;

import com.arango.model.Comment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

@Service
public class CommentService {

    private final JdbcTemplate jdbcTemplate;

    private final DataSource dataSource;

    public CommentService(final JdbcTemplate jdbcTemplate, final DataSource dataSource) {
        this.jdbcTemplate = jdbcTemplate;
        this.dataSource = dataSource;
    }

    public Comment create(final Comment comment) {
        return null;
    }

    private Comment get(final Long id) {
        return null;
    }

    public Comment getComment(final Long id) {
        return get(id);
    }

    public int deleteComment(final Long id) {
        
        return 0;
    }

    public List<Comment> getCommentsByTopic(final String topic) {
        return null;
    }

    public Comment mapRow(final ResultSet rs, final int rowNum) throws SQLException {
        
        return null;
    }

}
