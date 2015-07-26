package com.cee.sjm.framework.domain;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

public class BaseDomain {

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}
