
/*
 * @(#)TESTDAO.java
 * TEST Table DAO INFO
 */
package com.vo;

import java.util.HashMap;
import java.util.Map;

import framework.db.AbstractOrmDao;
import framework.db.DB;
import framework.db.RecordSet;
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
public class TESTDAO extends AbstractOrmDao {
	// Update Only Map
	private static Map<String, String> updateOnlyMap = new HashMap<String, String>();

	static {
		updateOnlyMap.put("PK", "?");
		updateOnlyMap.put("COL1", "?");
		updateOnlyMap.put("COL2", "?");
	}

	public TESTDAO(DB db) {
		super(db);
	}

	public String getInsertSql() {
		StringBuilder query = new StringBuilder();
		query.append("INSERT INTO TEST (");
		query.append("	PK,COL1,COL2,ENTERDATE");
		query.append(") ");
		query.append("VALUES (");
		query.append("	?,?,?,sysdate");
		query.append(")");
		return query.toString();
	}

	public String getUpdateSql() {

		StringBuilder query = new StringBuilder();
		query.append("UPDATE TEST SET ");
		query.append("	COL1 = ?");
		query.append("	,COL2 = ?");
		query.append("WHERE 1 = 1 ");
		query.append("	AND PK = ?");

		return query.toString();
	}

	public String getDeleteSql() {
		StringBuilder query = new StringBuilder();
		query.append("DELETE FROM TEST WHERE 1 = 1 ");
		query.append("	AND PK = ?");

		return query.toString();
	}

	public RecordSet select(ValueObject obj) {
		TESTVO vo = (TESTVO) obj;
		StringBuilder query = new StringBuilder();
		query.append("SELECT PK,COL1,COL2,ENTERDATE ");
		query.append("FROM TEST ");
		query.append("WHERE 1 = 1 ");
		query.append("	AND PK = ?");

		return executeQuery(query.toString(), vo.getPrimaryKeysValue());
	}

	public RecordSet select(String where) {
		StringBuilder query = new StringBuilder();
		query.append("SELECT PK,COL1,COL2,ENTERDATE ");
		query.append("FROM TEST ");
		query.append(where);
		return executeQuery(query.toString());
	}

	public String getUpdateOnlySql(String[] fields) {
		if (fields == null) {
			logger.error("fields Error!");
			return null;
		}
		StringBuilder query = new StringBuilder();
		query.append("UPDATE TEST SET ");
		for (String field : fields) {
			if (field == null) {
				logger.error("getUpdateOnlySql field is null!");
				return null;
			}
			if (!updateOnlyMap.containsKey(field.toUpperCase())) {
				continue;
			}
			query.append(field + " = " + updateOnlyMap.get(field.toUpperCase()));
			query.append(" ,");
		}
		query.delete(query.length() - 1, query.length());
		query.append("WHERE 1 = 1 ");
		query.append("	and PK = ?");

		return query.toString();
	}

	public String getUserUpdateOnlySql(String[] fields, String[] keys) {
		if (fields == null) {
			logger.error("fields Error!");
			return null;
		}
		if (keys == null) {
			logger.error("keys Error!");
			return null;
		}
		StringBuilder query = new StringBuilder();
		query.append("UPDATE TEST SET ");
		for (String field : fields) {
			if (field == null) {
				logger.error("field is null!");
				return null;
			}
			if (!updateOnlyMap.containsKey(field.toUpperCase())) {
				continue;
			}
			query.append(field + " = " + updateOnlyMap.get(field.toUpperCase()));
			query.append(" ,");
		}
		query.delete(query.length() - 1, query.length());
		query.append("WHERE 1 = 1 ");
		for (String key : keys) {
			query.append("	and " + key + " = ?");
		}
		return query.toString();
	}

	public String getUserDeleteSql(String[] keys) {
		if (keys == null) {
			logger.error("keys Error!");
			return null;
		}
		StringBuilder query = new StringBuilder();
		query.append("DELETE FROM TEST ");
		query.append("WHERE 1 = 1 ");
		for (String key : keys) {
			query.append("	AND " + key + " = ?");
		}
		return query.toString();
	}
}
