import framework.action.Controller;

public class HelloWorldController extends Controller {

	public void index() {
		// views.properties 파일에 있는 키를 지정
		// JSP 파일로 라우팅
		render("/hello-jsp");
	}
}
