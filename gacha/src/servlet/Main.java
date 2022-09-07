package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Gacha;
import model.PostGachaLogic;
import model.User;

/**
 * Servlet implementation class Main
 */
@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Main() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		ServletContext application = this.getServletContext();
		List<Gacha> gachaList = (List<Gacha>) application.getAttribute("gachaList");

		if(gachaList == null) {
			gachaList = new ArrayList<Gacha>();
			application.setAttribute("gachaList", gachaList);
		}

		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginUser");

		if(loginUser == null) {
			response.sendRedirect("/gacha/");
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");

		String gacharu = "";
		int cost = 0;
		if(request.getParameter("gacharu") != null){
			String rea = "";
			Random random = new Random();

			for(int i=0; i<10; i++){
				int a = random.nextInt(1000);
				if(a < 3){
					gacharu +="SSR";
				}else if(a < 100){
					gacharu +="SR";
				}else {
					gacharu +="R";
				}
				if(i<9){
					gacharu +=", ";
				}else {
					gacharu +="が出ました。";
				}
			}

		}else if(request.getParameter("derumade") != null){

			String rea = "";
			Random random = new Random();
			int count = 0;
			int a = 0;
			do{
				a = random.nextInt(1000);
					cost +=150;
					++count;
			}while(a>3);
			gacharu =""+ cost+"円でSSRが出ました" + count+"回ガチャを回しました";
		}


		if(gacharu != null) {
			ServletContext application = this.getServletContext();

			List<Gacha> gachaList = (List<Gacha>) application.getAttribute("gachaList");

			HttpSession session = request.getSession();
			User loginUser = (User) session.getAttribute("loginUser");

			Gacha gacha = new Gacha(loginUser.getName(), gacharu);
			PostGachaLogic postGachaLogic = new PostGachaLogic();
			postGachaLogic.execute(gacha, gachaList);

			application.setAttribute("gachaList", gachaList);
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
		dispatcher.forward(request, response);
	}

}
