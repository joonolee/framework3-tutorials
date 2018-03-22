import java.util.List;

import framework.db.DB;
import framework.db.RecordMap;
import framework.db.SqlSessionDaoSupport;

public class SqlSessionDao extends SqlSessionDaoSupport {

	public SqlSessionDao(DB db) {
		super(db);
	}

	public List<RecordMap> listAll() {
		return selectList("Test.listAll");
	}
	
	public RecordMap listOne() {
		return selectOne("Test.listOne");
	}
}
