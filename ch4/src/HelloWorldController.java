import java.util.List;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;

import framework.action.Controller;
import framework.db.RecordMap;
import framework.db.RecordSet;
import framework.util.CsvUtil;
import framework.util.XmlUtil;

public class HelloWorldController extends Controller {
	// Select 를 위한 Dao는 JdbcDaoSupport(자바객체 내에 SQL문자열 사용), SqlSessionDaoSupport(마이바티스) 클래스를 상속받아서 생성한다.
	// 단순 테이블 CRUD 의 경우는 자동생성 DAO(daogen)을 이용함을 원칙으로 한다.

	// Dao 객체 선언
	private JdbcDao jdbcDao = null;
	private SeqDao seqDao = null;
	private SqlSessionDao sqlSessionDao = null;

	// Dao 객체 생성
	// DAO 객체가 필요할 때 까지 생성을 뒤로 미룬다. Lazy 생성
	private JdbcDao getJdbcDao() {
		if (jdbcDao == null) {
			jdbcDao = new JdbcDao(getDB());
		}
		return jdbcDao;
	}

	private SeqDao getSeqDao() {
		if (seqDao == null) {
			seqDao = new SeqDao(getDB());
		}
		return seqDao;
	}

	private SqlSessionDao getSqlSessionDao() {
		if (sqlSessionDao == null) {
			sqlSessionDao = new SqlSessionDao(getDB());
		}
		return sqlSessionDao;
	}

	// http://localhost:8080/ch4/jdbc_dao1.do
	public void jdbcDao1Ex() {
		// Dao 클래스 내에 Select 쿼리 문자열 사용 => 실행후에는 RecordSet으로 리턴
		RecordSet rs = getJdbcDao().listAll();

		// 결과를 보기 위해 XML로 브라우저에 출력해 봄
		setContentType("text/xml; charset=utf-8");
		XmlUtil.render(response, rs, "utf-8");
	}

	// http://localhost:8080/ch4/jdbc_dao2.do
	public void jdbcDao2Ex() {
		// Select 쿼리에 파라미터를 전달하여 1건만 조회 한다. => 1건이지만 RecordSet으로 리턴
		RecordSet rs = getJdbcDao().listOne();

		// 결과를 보기 위해 XML로 브라우저에 출력해 봄
		setContentType("text/xml; charset=utf-8");
		XmlUtil.render(response, rs, "utf-8");
	}

	// http://localhost:8080/ch4/seq_dao.do
	public void seqDaoEx() {
		// 시퀀스 값을 구해오기 위해 Dao 를 만들어서 값을 리턴, SeqDao 내에 쿼리문으로 자바 메소드를 자동으로 만든다.(노가다 금지)
		Long seqAuditlog = getSeqDao().getSeqAuditlog();

		// DB에서 가져온 시퀀스를 화면에 출력해 본다.
		setContentType("text/html; charset=utf-8");
		out.println("<h1>Audit log Sequence=" + seqAuditlog + "</h1>");
	}

	// http://localhost:8080/ch4/sql_session_dao1.do
	public void sqlSessionDao1Ex() {
		// 마이바티스 쿼리를 이용하여 List 를 반환
		// List에 닮긴 객체는 Map 객체의 일종인 RecordMap(키 값을 소문자로 관리하는 맵 객체)
		// 1건도 조회되지 않을 경우는 null 리턴
		List<RecordMap> listAll = getSqlSessionDao().listAll();

		// 결과를 보기 위해 XML로 브라우저에 출력해 봄
		setContentType("text/xml; charset=utf-8");
		XmlUtil.render(response, listAll, "utf-8");
	}

	// http://localhost:8080/ch4/sql_session_dao2.do
	public void sqlSessionDao2Ex() {
		// 마이바티스 쿼리를 이용하여 1건만 반환
		// 1건도 조회되지 않을 경우는 null 리턴
		RecordMap listOne = getSqlSessionDao().listOne();

		// 결과를 보기 위해 XML로 브라우저에 출력해 봄
		setContentType("text/xml; charset=utf-8");
		XmlUtil.render(response, listOne, "utf-8");
	}

	// http://localhost:8080/ch4/sql_session_dao3.do
	public void sqlSessionDao3Ex() {
		// 마이바티스 쿼리를 이용하여 대량의 목록을 조회할 경우 List객체를 사용하면 OOM 발생 가능
		// 따라서 ResultHandler 를 이용해 WAS 메모리에 저장하지 않고 웹브라우저에 CSV 형식으로 바로 전송

		// 자바 1.8에서는 람다식으로 작성 가능
		ResultHandler csvResultHandler = new ResultHandler() {
			@Override
			public void handleResult(ResultContext resultContext) {
				// 한줄 씩 읽어 CSV 형식으로 웹브라우저에 전송
				out.println(CsvUtil.render((RecordMap) resultContext.getResultObject(), "|"));
			}
		};
		// 결과를 보기 위해 CSV로 브라우저에 출력해 봄
		setContentType("text/plain; charset=utf-8");
		getSqlSessionDao().listAll2(csvResultHandler);
	}
}
