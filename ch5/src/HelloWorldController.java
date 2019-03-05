
import com.vo.TEST2DAO;
import com.vo.TEST2VO;
import com.vo.TESTDAO;
import com.vo.TESTVO;

import framework.action.Controller;
import framework.db.RecordSet;
import framework.db.ValueObjectArray;
import framework.util.XmlUtil;

public class HelloWorldController extends Controller {

	// http://localhost:8080/ch5/create.do
	public void create() {
		// 빈 ValueObject 를 생성하여 값을 셋팅한다.
		// 테이블의 ENTERDATE 의 경우 daogen 내에서 sysdate 가 입력되도록 특수처리 되어있기 때문에
		// 값을 셋팅하지 않아도 되며, 셋팅한 경우라도 무시되고 sysdate 가 입력된다.
		TESTVO vo = new TESTVO();
		vo.setPK(Long.valueOf(11));
		vo.setCOL1("홍길동11");
		vo.setCOL2(Long.valueOf(21));

		// 값을 셋팅한 VO 를 DAO 를 만들어서 Insert 한다.
		TESTDAO dao = new TESTDAO(getDB());
		int cnt = dao.insert(vo);

		// 커밋을 반드시 해야 DML 작업이 반영된다.
		getDB().commit();

		// 결과를 브라우저에 출력해 봄
		setContentType("text/html; charset=utf-8");
		out.println("<h1>인서트 건수 = " + cnt + "</h1>");
	}

	// http://localhost:8080/ch5/list.do
	public void list() {
		TESTDAO dao = new TESTDAO(getDB());
		RecordSet rs = dao.select("");

		// 결과를 보기 위해 XML로 브라우저에 출력해 봄
		setContentType("text/xml; charset=utf-8");
		XmlUtil.render(response, rs, "utf-8");
	}

	// http://localhost:8080/ch5/info.do
	public void info() {
		// PK 로 1건 조회하기 위해 vo는 PK 만 셋팅해도 된다. 다른 값을 셋팅할 경우 무시된다.
		TESTVO vo = new TESTVO();
		vo.setPK(Long.valueOf(1));

		// PK가 셋팅된 VO 를 select 인자로 넘겨 1건만 조회 한다.
		TESTDAO dao = new TESTDAO(getDB());
		RecordSet rs = dao.select(vo);

		// 결과를 보기 위해 XML로 브라우저에 출력해 봄
		setContentType("text/xml; charset=utf-8");
		XmlUtil.render(response, rs, "utf-8");
	}

	// http://localhost:8080/ch5/update.do
	public void update() {
		// PK가 1번인 COL1이 홍길동1인 값을 홍길동101로 변경하기 위해 PK와 변경할 COL1값을 VO에 셋팅한다.
		TESTVO vo = new TESTVO();
		vo.setPK(Long.valueOf(1));
		vo.setCOL1("홍길동101");

		// 업데이트의 경우, COL1만 변경하고 다른 컬럼은 변경되지 않는다.
		// dao.update 메소드의 경우 vo 값을 참조하여 모든 컬럼이 갱신되므로 실무에서는 사용할 일이 없다.
		// 실무에서는 아래 예제와 같이 dao.updateOnlyFields 로 변경할 필드를 지정하는 방식으로만 사용한다.
		TESTDAO dao = new TESTDAO(getDB());
		int cnt = dao.updateOnlyFields(vo, new String[] { "col1" });

		// 커밋을 반드시 해야 DML 작업이 반영된다.
		getDB().commit();

		// 결과를 보기 위해 브라우저에 출력해 봄
		setContentType("text/html; charset=utf-8");
		out.println("<h1>업데이트 건수 = " + cnt + "</h1>");
	}

	// http://localhost:8080/ch5/delete.do
	public void delete() {
		// 삭제할 데이터의 PK 만 VO 에 셋팅한다. 삭제할 때는 PK 만 필요하므로...
		TESTVO vo = new TESTVO();
		vo.setPK(Long.valueOf(10));

		// PK 가 설정된 vo 를 dao.delete 메소드에 인자로 전달하면 해당 레코드가 삭제된다.
		TESTDAO dao = new TESTDAO(getDB());
		int cnt = dao.delete(vo);

		// 커밋을 반드시 해야 DML 작업이 반영된다.
		getDB().commit();

		// 결과를 보기 위해 브라우저에 출력해 봄
		setContentType("text/html; charset=utf-8");
		out.println("<h1>삭제 건수 = " + cnt + "</h1>");
	}

	// http://localhost:8080/ch5/multi_insert.do
	public void multiInsert() {
		// 배치 방식이 아닌 한건한건 insert 문을 전송하는 방식으로 대량 입력 시 비효율
		TESTDAO dao = new TESTDAO(getDB());

		// 10만건 입력
		long start = System.currentTimeMillis();
		for (int i = 100000; i < 200000; i++) {
			TESTVO vo = new TESTVO();
			vo.setPK(Long.valueOf(i));
			vo.setCOL1("홍길동" + i);
			vo.setCOL2(Long.valueOf(i));
			dao.insert(vo);
		}
		// 커밋을 반드시 해야 DML 작업이 반영된다.
		getDB().commit();
		long end = System.currentTimeMillis();

		// 결과를 보기 위해 브라우저에 출력해 봄
		setContentType("text/html; charset=utf-8");
		out.println("<h1>걸린시간(밀리초) = " + (end - start) + "</h1>");
	}

	// http://localhost:8080/ch5/multi_batch_insert.do
	public void multiBatchInsert() {
		// 배치 방식으로 한번에  insert 문을 전송하는 방식으로 대량 입력 시 효율적임
		TEST2DAO dao = new TEST2DAO(getDB());
		ValueObjectArray voArray = new ValueObjectArray();

		// 10만건 입력
		long start = System.currentTimeMillis();
		for (int i = 100000; i < 200000; i++) {
			TEST2VO vo = new TEST2VO();
			vo.setPK(Long.valueOf(i));
			vo.setCOL1("홍길동" + i);
			vo.setCOL2(Long.valueOf(i));
			voArray.add(ValueObjectArray.INSERT, vo);
		}
		// 커밋을 반드시 해야 DML 작업이 반영된다.
		dao.save(voArray);

		getDB().commit();
		long end = System.currentTimeMillis();

		// 결과를 보기 위해 브라우저에 출력해 봄
		setContentType("text/html; charset=utf-8");
		out.println("<h1>걸린시간(밀리초) = " + (end - start) + "</h1>");
	}
}
