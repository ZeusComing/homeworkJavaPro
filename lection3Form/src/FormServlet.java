import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "FormServlet", urlPatterns = "/form")
public class FormServlet extends HttpServlet {
    private static final Map<String, Integer> stats = new HashMap<>();

    static final String TEMPLATE = "<html>" +
            "<head><title>My site</title></head>" +
            "<body>" +
            "<h1>%s</h1>" +
            "</body></html>";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String parameter1 = req.getParameter("question1");
        String parameter2 = req.getParameter("question2");
        String[] params = new String[]{parameter1, parameter2};
        for (String parameter : params) {
            Integer count = stats.get(parameter);
            if (count == null) {
                stats.put(parameter, 1);
            } else {
                stats.put(parameter, count + 1);
            }
        }
        resp.getWriter().println(String.format(TEMPLATE, statsString(resp)));

    }

    private String statsString(HttpServletResponse response) throws IOException {
        String[] params = new String[] {"Coffee", "Tea", "yes", "no"};
        StringBuilder stringBuilder = new StringBuilder();
        for (String s: params) {
            stringBuilder.append(s + " " + stats.get(s) + "<br>");
        }
        stringBuilder.append("<a href=\"/form.html\">fill out the form one more time</a>");
        return stringBuilder.toString();
    }
}
