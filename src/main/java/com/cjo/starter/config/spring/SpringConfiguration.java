package com.cjo.starter.config.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

/**
 * @author Tomas
 * @date Apr 21, 2019
 *
 */
@Configuration
public class SpringConfiguration {

	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource source = new ResourceBundleMessageSource();
		source.setBasenames("messages/messages");
		source.setUseCodeAsDefaultMessage(true);
		return source;
	}

}
