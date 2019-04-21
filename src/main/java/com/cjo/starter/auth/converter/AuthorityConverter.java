package com.cjo.starter.auth.converter;

import com.cjo.starter.auth.domain.AuthorityDomain;
import com.cjo.starter.auth.model.Authority;
import com.cjo.starter.common.converter.IConverter;

/**
 * @author Tomas
 * @date Apr 20, 2019
 *
 */
public class AuthorityConverter implements IConverter<Authority, AuthorityDomain> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cjo.starter.common.converter.IConverter#convert(java.lang.Object)
	 */
	@Override
	public AuthorityDomain convert(Authority authority) {
		AuthorityDomain.Builder builder = new AuthorityDomain.Builder();
		return builder.setId(authority.getId()).setName(authority.getName()).setShortName(authority.getShortName())
				.build();
	}

}
