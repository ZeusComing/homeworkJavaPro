import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@SuppressWarnings("serial")
@WebServlet(name = "Login", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
	
	static final String TEMPLATE = "<html>" +
			"<head><title>My site</title></head>" +
			"<body><h1>%s</h1></body></html>";
	
	static final Map<String, String> cred = new HashMap<>();
	
	static {
		// hardcode login credentials
		cred.put("admin", "admin");
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String login = req.getParameter("login");
		String pass = req.getParameter("password");
		String msg = "";
		String temp = cred.get(login);
		if (pass.equals(temp)) {
            msg = "Succes  <a href=\"/form.html\">Form</a>";
        } else {
            msg = "Denied";
        }
        resp.getWriter().println(String.format(TEMPLATE, msg));
	}

}
