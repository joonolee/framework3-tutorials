import framework.action.Controller;

public class HelloWorldController extends Controller {

	public void index() {
		// 웹브라우저로 HTML 출력
		setContentType("text/html; charset=utf-8");
		out.println("<h1>Hello World!</h1>");
	}
}
