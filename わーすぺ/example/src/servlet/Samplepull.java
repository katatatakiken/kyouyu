package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/testenq")
public class Samplepull  extends HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,HttpServletResponse response)
	throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String type =request.getParameter("type");
		String text =request.getParameter("text");

		String errorMsg = "";

		if(type == null || type.length() == 0) {
			errorMsg += "お問い合わせ内容を選択してください<br>";
		}else if(type.equals("company")){
			type = "会社";

		}else if(type.equals("product")){
			type = "製品";
		}else if(type.equals("support")) {
			type = "アフターサポート";
		}

		String msg = type + "について受け付けます。";
		if(errorMsg.length() != 0) {
			type = errorMsg;
		}
		response.setContentType("text/html;charset=UTF-8");

		//↓でsystem.out.printlnと同じように使用できる。
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>お問い合わせ内容</title>");
		out.println("</head>");
		out.println("<body>");
		if(errorMsg.length() != 0){
			out.println(type);
			out.println("<br>");
		out.println("<a href=\"/example/Samplepull.jsp\">戻る</a>");
		}else{
		out.println(msg);
		out.println("<p>"+"内容:"+text+"</p>");
		out.println("<a href=\"/example/Samplepull.jsp\">戻る</a>");
		}
		out.println("</body>");
		out.println("</html>");

	}

}
