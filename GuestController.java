package ch11;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GuestController
 */
@WebServlet(urlPatterns = "/Guestbook.nhn")
public class GuestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	private guestbookDAO dao;
	private ServletContext ctx;
	
	
	private final String START_PAGE = "webapp/guestbook1.jsp" ;
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		dao=new guestbookDAO();
		ctx=getServletContext();
		
		}
	protected void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		
		dao = new guestbookDAO();
		
		Method m ;
		String view = null;
		
		if(action == null) {
			action = "guestbook1";
		}
	
	try {
		m = this.getClass().getMethod(action, HttpServletRequest.class);
		
		view = (String)m.invoke(this, request);
		
	} catch (NoSuchMethodException e) {
		e.printStackTrace();
		ctx.log("요청 action이 없음 !!");
		request.setAttribute("error", "action 파라미터가 잘못되었습니다!");
		view = START_PAGE;
		
	} catch (Exception e) {
		e.printStackTrace() ;
		
	}
	public String guestbook(HttpServletRequest request) {
		List<guestbook> list;
		try {
			list = dao.getAll();
			request.setAttribute("guestbook1", list);
		} catch (Exception e) {
			e.printStackTrace();
			ctx.log("방명록 목록 생성 과정에서 문제 발생!!");
			request.setAttribute("error", "방명록 목록이 정상적으로 처리되지 않았습니다");
		}
		return "webapp/guestbook1.jsp";
	}
	
	public String deleteguestbook(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		try {
			dao.delGuestbook(id);
			
		} catch (SQLException e) {
			e.printStackTrace();
			ctx.log("방명록 목록 생성 과정에서 문제 발생!!");
			request.setAttribute("error", "방명록 목록이 정상적으로 처리되지 않았습니다");
			return guestbook(request);
			
		}
		
	}
	public String addguestbook(HttpServletRequest request) {
		guestbook n = new guestbook();
		try {
			BeanUtils.populate(n, request.getParameterMap());
			
		} catch (Exception e) {
			e.printStackTrace();
			ctx.log("방명록 목록 생성 과정에서 문제 발생!!");
			request.setAttribute("error", "방명록 목록이 정상적으로 처리되지 않았습니다");
			return guestbook(request);
			
		}
	}
	public guestbookDAO getDao() {
		return dao;
	}
	public void setDao(guestbookDAO dao) {
		this.dao = dao;
	}
	public ServletContext getCtx() {
		return ctx;
	}
	public void setCtx(ServletContext ctx) {
		this.ctx = ctx;
	}
	public String getSTART_PAGE() {
		return START_PAGE;
	}
			
}
	
	
	
	
       
