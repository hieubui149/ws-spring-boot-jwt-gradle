package com.cjo.starter.auth.domain;

/**
 * @author Tomas
 * @date Apr 20, 2019
 *
 */
public class AuthorityDomain {

	private int id;
	private String name;
	private String shortName;
	
	private AuthorityDomain() {
		
	}
	
	private AuthorityDomain(Builder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.shortName = builder.shortName;
	}

	public static class Builder {

		private int id;
		private String name;
		private String shortName;
		
		public Builder() {

		}

		public Builder setId(int id) {
			this.id = id;
			return this;
		}
		
		public Builder setName(String name) {
			this.name = name;
			return this;
		}
		
		public Builder setShortName(String shortName) {
			this.shortName = shortName;
			return this;
		}
		
		public AuthorityDomain build() {
			return new AuthorityDomain(this);
		}

	}
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getShortName() {
		return shortName;
	}

}
