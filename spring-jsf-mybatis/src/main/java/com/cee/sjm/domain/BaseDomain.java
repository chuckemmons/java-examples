package com.cee.sjm.domain;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

public class BaseDomain {

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}
