import java.io.IOException;

import framework.action.After;
import framework.action.Before;
import framework.action.Catch;
import framework.action.Controller;
import framework.action.Finally;

public class HelloWorldController extends Controller {

	// http://localhost:8080/ch3/params.do?str=<h1>world</h1>&num1=10&num2=20&num3=30&raw=<h1>world</h1>
	public void paramsEx() {
		// 1. params 객체
		// request.getParameter("") 단점
		//  - null 리턴가능 : NullpointerException의 주요원인
		//  - String 을 리턴하기 때문에 타입 변환 필요
		//  - 파라미터가 넘어오지 않았을 때 디폴트 값 지정 불가
		// 1)
		String str = params.getString("str");
		Integer num1 = params.getInteger("num1");
		Double num2 = params.getDouble("num2");
		Long num3 = params.getLong("num3");
		String raw = params.getRawString("raw");
		
		logger.debug("str=" + str);
		logger.debug("num1=" + num1);
		logger.debug("num2=" + num2);
		logger.debug("num3=" + num3);
		logger.debug("raw=" + raw);
	}
	
	// http://localhost:8080/ch3/request.do?name=Hello
	public void requestEx() {
		// 2. request 객체
		// JSP의 request 와 동일
		// 가급적 직접 사용할 일 없음.
		// 파라미터 처리 외에 request 객체 기능 사용
		String name = request.getParameter("name");
		
		logger.debug("name=" + name);
	}
	
	// http://localhost:8080/ch3/response.do
	public void responseEx() throws IOException {
		// 3. response 객체
		// JSP의 response 와 동일
		// 가급적 사용할 일 없음
		// Http 상태 코드
		response.setStatus(200);
		
		// 리다이렉트 : redirect 메소드를 사용하므로 아래와 같이 사용할 일 없음
		response.sendRedirect("http://www.redcross.or.kr");
	}
	
	// http://localhost:8080/ch3/render.do
	public void renderEx() {
		// 4. render 메소드
		// views.properties 파일에 정의된 키를 사용하여 JSP 파일 위치를 찾아 렌더링
		render("/hello-jsp");
	}
	
	// http://localhost:8080/ch3/redirect.do
	public void redirectEx() {
		// 5. redirect 메소드
		// URL 주소로 리다이렉트
		redirect("http://www.bloodinfo.net");
	}
	
	// http://localhost:8080/ch3/set_content_type.do
	public void setContentTypeEx() {
		// 6. setContentType 메소드
		//setContentType("text/plain; charset=utf-8");
		setContentType("text/xml; charset=utf-8");
		out.println("<items><item><name>Hello</name></item></items>");
	}
	
	// http://localhost:8080/ch3/set_attribute.do
	public void setAttributeEx() {
		// 7. setAttribute 메소드
		setAttribute("msg", "setAttribute 메소드에서 보냅니다.");
		render("/hello-jsp");
	}
	
	// http://localhost:8080/ch3/error.do
	public void errorEx() {
		throw new RuntimeException("errorEx 메소드에서 예외발생!");
	}
	
	@Before
	public void beforeFilter() {
		logger.debug("=== Before Filter ===");
	}
	
	@After
	public void afterFilter() {
		logger.debug("=== After Filter ===");
	}
	
	@Catch(Exception.class)
	public void catchFilter(Throwable e) {
		logger.debug("=== Catch Filter ===" + e.getMessage());
		stop();
	}
	
	@Finally
	public void finallyFilter() {
		logger.debug("=== Finally Filter ===");
	}
}
