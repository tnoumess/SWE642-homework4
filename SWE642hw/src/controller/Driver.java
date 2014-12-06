package controller;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import business.DataProcessing;
import business.StudentDao;
import model.Databean;
import model.Studentbean;

/**
 * Servlet implementation class Driver
 */
@WebServlet({ "/driver", "/process" })
public class Driver extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static List<Studentbean> lists=null;
	private Studentbean studentbean;
	private Databean databean;
	/*private static final String PERSISTENCE_UNIT_NAME = "studentbeans";
	private static EntityManagerFactory factory;*/
	
	
	private static String STUDENT_JSP = "StudentJSP.jsp";
	private static String NOSUCHSTUDENT_JSP = " NoSuchStudentJSP.jsp";
	private static String WINNER_JSP = "WinnerAcknowledgement.jsp";
	private static String SIMPLE_JSP = "SimpleAcknowledgement.jsp";
	private static String SURVEY_JSP = "Survey.jsp";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Driver() {
        super();
        System.out.println("initialization");
        
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id =request.getParameter("studentid");
		String address;
		lists=StudentDao.List_students();
		
		if(request.getParameter("act") == null){// attempt to save data
			
		if(validId(id, request)){// inserting info
			studentbean =filldata(request);
			StudentDao.SaveForm(filldata(request).getStudentId(),filldata(request).getName(),
					filldata(request).getAddress(),filldata(request).getCity(),filldata(request).getState(),
					filldata(request).getZip(),filldata(request).getTel(),filldata(request).getEmail(),
					filldata(request).getUrl(),filldata(request).getDates(),filldata(request).getHow(),
					filldata(request).getLike(),filldata(request).getGraduationMonth(),
					filldata(request).getYear(),filldata(request).getRecommendation(),
					filldata(request).getComment(),filldata(request).getData());
			
			
			databean= DataProcessing.compute(studentbean.getData());
			
			if(databean.getMean()>=90)
				{address=WINNER_JSP;}else{
			   address=SIMPLE_JSP;}
			
			request.setAttribute("name", studentbean.getName());
			request.setAttribute("idList", StudentDao.list_ID());
			request.setAttribute("compMean", databean.getMean());
			request.setAttribute("compStdv", databean.getDeviation());
			
			System.out.println("mean:"+databean.getMean()+"deviation"+databean.getDeviation());
			System.out.println(address);
			lists=StudentDao.List_students();
			System.out.println(lists);
			System.out.println(StudentDao.list_ID());
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(address);
			dispatcher.forward(request, response);
			
			
			
		}else{//not valid Id
			String Message="THE STUDENT ID:"+id+" ALREADY EXIST!!";
			request.setAttribute("message", Message);
			lists=StudentDao.List_students();
			 address=SURVEY_JSP; //Id exists already
			 RequestDispatcher dispatcher = request.getRequestDispatcher(address);
				dispatcher.forward(request, response);
			 
		}
		}
		else{
			lists=StudentDao.List_students();
			// info student requested
			List<String> IDs = StudentDao.list_ID();
			request.setAttribute("idList", IDs);
			
			Studentbean student = get_student(request.getParameter("act"));
			System.out.println("Selected Student: " + student);
			
			if (student == null) {
				System.out.println("[ERROR] :=: Going to the error student page.");
				address = NOSUCHSTUDENT_JSP;
				} else {
				request.setAttribute("st", student);
				address = STUDENT_JSP;
				}
			RequestDispatcher dispatcher = request.getRequestDispatcher(address);
			dispatcher.forward(request, response);
			
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	protected boolean validId(String id, HttpServletRequest request){
		Studentbean sb=filldata(request);		
		return !StudentDao.IdInuse(sb.getStudentId());		
	}
	
	public Studentbean get_student(String id){
		
		if (id != null) {
			if (getLists().size() > 0) {
			        int index = -1;
			      for (int i = 0; i < getLists().size(); i++) {
			      if (lists.get(i).getStudentId().equalsIgnoreCase(id)) {
			            index = i;
			         }
			          }
			           if (index > -1) {
			return lists.get(index);
			} else {
			
			return null;
			}
			} else {
			
			return null;
			}
			} else {
			return null;
			}
	}

	public static List<Studentbean> getLists() {
		return lists;
	}

	/*public static void setLists(List<Studentbean> lists) {
		Driver.lists = lists;
	}*/
	
	public Studentbean filldata(HttpServletRequest request){
		String Name = request.getParameter("name");
		String Street = request.getParameter("street");
		String City = request.getParameter("city");
		String State = request.getParameter("state");
		String Zip = request.getParameter("zip");
		String Telephone = request.getParameter("telephone");
		System.out.println(Telephone);
		String Email = request.getParameter("email");
		String Date = request.getParameter("date");System.out.println(Email);
		String[] Liked = request.getParameterValues("liked");
		String lbc = "";
		if (Liked == null) {
		lbc = "n/a";
		} else {
		for (int i = 0; i < Liked.length; i++) {
		lbc += Liked[i];
		}
		}
		String Interest = request.getParameter("how");
		String Url = request.getParameter("url");
		String Recommend = request.getParameter("recommend");
		String Month = request.getParameter("month"); 
		String Year = request.getParameter("year");
		String Data = request.getParameter("data");
		String Comment = request.getParameter("comment");
		String StudentID = request.getParameter("studentid");
		//int i=1;
		studentbean = new Studentbean(StudentID,Name, Street, City, State,
				Zip, Telephone, Email,Url, Date,lbc, Interest,
				 Month, Year,Recommend, Comment,Data);System.out.println(studentbean);
		//boolean save=StudentDao.SaveForm(StudentID, Name, Street, City, State, Zip, Telephone, Email, Url, Date,Interest,  lbc, Month, Year, Recommend, Comment, Data);
		return studentbean;
	}

}
