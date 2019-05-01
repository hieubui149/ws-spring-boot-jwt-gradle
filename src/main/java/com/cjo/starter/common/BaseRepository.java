package com.cjo.starter.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/**
 * @author hieubui
 * @since 2019-05-01
 */
public abstract class BaseRepository {

    @Autowired
    protected NamedParameterJdbcTemplate jdbcTemplate;

}
