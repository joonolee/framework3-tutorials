
/*
 * @(#)TESTVO.java
 * TEST Table VO INFO
 */
package com.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import framework.db.ValueObject;

/**
	Table : TEST
	Primary Key : 
	Table Fields
		PK:number(38):\n
		COL1:varchar2(100):\n
		COL2:number(10):\n
		ENTERDATE:date:\n
		
*/
public class TESTVO extends ValueObject {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6303908647249242189L;
	public static final String TABLE = "TEST";
	public static final String TABLE_DESC = "";
	public static final String PRIMARYKEY_LIST[] = { "PK" };
	public static final String FIELD_LIST[] = { "PK", "COL1", "COL2", "ENTERDATE" };

	// column name
	private static Map<String, Integer> columnMap = new HashMap<String, Integer>();
	// column type
	private static Map<String, String> typeMap = new HashMap<String, String>();
	// no update list
	private static List<String> noUpdateList = new ArrayList<String>();

	public Map<String, Integer> getColumnMap() {
		return Collections.unmodifiableMap(columnMap);
	}

	public Map<String, String> getTypeMap() {
		return Collections.unmodifiableMap(typeMap);
	}

	static {
		columnMap.put("PK", Integer.valueOf(1));
		columnMap.put("COL1", Integer.valueOf(2));
		columnMap.put("COL2", Integer.valueOf(3));
		columnMap.put("ENTERDATE", Integer.valueOf(4));
		typeMap.put("PK", "Long");
		typeMap.put("COL1", "String");
		typeMap.put("COL2", "Long");
		typeMap.put("ENTERDATE", "Date");
		noUpdateList.add("ENTERDATE");
	}

	private Long _PK;
	private String _COL1;
	private Long _COL2;
	private Date _ENTERDATE;

	public TESTVO() {
	}

	public Long getPK() {
		return _PK;
	}

	public void setPK(Long newPK) {
		_PK = newPK;
	}

	public String getCOL1() {
		return _COL1;
	}

	public void setCOL1(String newCOL1) {
		_COL1 = newCOL1;
	}

	public Long getCOL2() {
		return _COL2;
	}

	public void setCOL2(Long newCOL2) {
		_COL2 = newCOL2;
	}

	public Date getENTERDATE() {
		return _ENTERDATE;
	}

	public void setENTERDATE(Date newENTERDATE) {
		_ENTERDATE = newENTERDATE;
	}

	public Object getByName(String key) {
		Integer idx = (Integer) columnMap.get(key.toUpperCase());
		if (idx != null) {
			switch (idx.intValue()) {
			case 1:
				return getPK();
			case 2:
				return getCOL1();
			case 3:
				return getCOL2();
			case 4:
				return getENTERDATE();
			}
		}
		return null;
	}

	public void setByName(String key, Object value) {
		Integer idx = (Integer) columnMap.get(key.toUpperCase());
		if (idx != null) {
			switch (idx.intValue()) {
			case 1:
				setPK((Long) value);
				return;
			case 2:
				setCOL1((String) value);
				return;
			case 3:
				setCOL2((Long) value);
				return;
			case 4:
				setENTERDATE((Date) value);
				return;
			}
		}
	}

	public String getType(String key) {
		return (String) typeMap.get(key.toUpperCase());
	}

	public String[] getPrimaryKeysName() {
		return PRIMARYKEY_LIST;
	}

	public String[] getFieldsName() {
		return FIELD_LIST;
	}

	public Object[] getPrimaryKeysValue() {
		return new Object[] { getPK() };
	}

	public Object[] getFieldsValue() {
		return new Object[] { getPK(), getCOL1(), getCOL2(), getENTERDATE() };
	}

	public String toString() {
		StringBuilder buf = new StringBuilder();
		buf.append("PK:" + getPK() + "\n");
		buf.append("COL1:" + getCOL1() + "\n");
		buf.append("COL2:" + getCOL2() + "\n");
		buf.append("ENTERDATE:" + getENTERDATE() + "\n");

		return buf.toString();
	}

	public Object[] getUpdateValue() {
		return new Object[] { getCOL1(), getCOL2(), getPK() };
	}

	public Object[] getInsertValue() {
		return new Object[] { getPK(), getCOL1(), getCOL2() };
	}

	public Object[] getUpdateOnlyValue(String[] fields) {
		if (fields == null) {
			logger.error("fields Error!");
			return null;
		}
		List<Object> list = new ArrayList<Object>();
		for (String field : fields) {
			if (field == null) {
				logger.error("field is null!");
				return null;
			}
			if (!noUpdateList.contains(field.toUpperCase())) {
				list.add(getByName(field));
			}
		}
		for (Object key : getPrimaryKeysValue()) {
			list.add(key);
		}
		return list.toArray();
	}

	public Object[] getUserUpdateOnlyValue(String[] fields, String[] keys) {
		if (fields == null) {
			logger.error("fields Error!");
			return null;
		}
		if (keys == null) {
			logger.error("keys Error!");
			return null;
		}
		List<Object> list = new ArrayList<Object>();
		for (String field : fields) {
			if (field == null) {
				logger.error("field is null!");
				return null;
			}
			if (!noUpdateList.contains(field.toUpperCase())) {
				list.add(getByName(field));
			}
		}
		for (String key : keys) {
			list.add(getByName(key));
		}
		return list.toArray();
	}

	public Object[] getUserDeleteValue(String[] keys) {
		if (keys == null) {
			logger.error("keys Error!");
			return null;
		}
		List<Object> list = new ArrayList<Object>();
		for (String key : keys) {
			list.add(getByName(key));
		}
		return list.toArray();
	}
}
