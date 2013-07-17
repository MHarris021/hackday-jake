package com.sf.jake.model;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;

public enum Gender {
	Male,
	Female;
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer(WordUtils.capitalizeFully(this.name()));
		return buffer.toString();
	}
	
	public String abbreviate() {
		StringBuffer buffer = new StringBuffer(StringUtils.abbreviate(this.name(), 1));
		buffer.substring(0, 1);
		return buffer.toString();
	}
}
