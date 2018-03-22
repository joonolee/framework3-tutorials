import framework.action.Controller;

public class HelloWorldController extends Controller {
	
	public void index() {
		// 웹브라우저로 HTML 출력
		out.println("<h1>Hello World!</h1>");
	}

}
