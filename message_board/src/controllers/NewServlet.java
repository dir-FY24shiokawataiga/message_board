package controllers;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Message;
import net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.ResubmissionScheduler.AtFixedRate;
import utils.DBUtil;
import java.sql.Timestamp;
import javax.persistence.EntityManager;

/**
 * Servlet implementation class NewServlet
 */
@WebServlet("/new")
public class NewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException  
	        {
	            // CSRF対策
	            request.setAttribute("_token", request.getSession().getId());

	            // おまじないとしてのインスタンスを生成
	            request.setAttribute("message", new Message());

	            var rd = request.getRequestDispatcher("/WEB-INF/views/messages/new.jsp");
	            rd.forward(request, response);

	         }
}
	


