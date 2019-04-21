package com.cjo.starter.common.converter;

/**
 * @author Tomas
 * @date Apr 20, 2019
 *
 */
public interface IConverter<U, V> {

	V convert(U u);
	
}
