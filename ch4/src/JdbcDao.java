import framework.db.DB;
import framework.db.JdbcDaoSupport;
import framework.db.RecordSet;
import framework.db.SelectConditionObject;

public class JdbcDao extends JdbcDaoSupport {

	public JdbcDao(DB db) {
		super(db);
	}

	public RecordSet listAll() {
		StringBuilder query = new StringBuilder();
		query.append("select  ");
		query.append("    pk ");
		query.append("    ,col1 ");
		query.append("    ,col2 ");
		query.append("    ,to_char(enterdate, 'yyyy-mm-dd hh24:mi:ss') enterdate ");
		query.append("from test ");
		return select(query.toString());
	}

	public RecordSet listOne() {
		StringBuilder query = new StringBuilder();
		SelectConditionObject cond = new SelectConditionObject();
		query.append("select  ");
		query.append("    pk ");
		query.append("    ,col1 ");
		query.append("    ,col2 ");
		query.append("    ,to_char(enterdate, 'yyyy-mm-dd hh24:mi:ss') enterdate ");
		query.append("from test ");
		query.append("where pk = ? ");
		cond.setObject(1);
		return select(query.toString(), cond.getParameter());
	}
}
