package business;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Studentbean;


public class StudentDao {
	private static final String PERSISTENCE_UNIT_NAME = "students";
	//private static EntityManagerFactory factory;
	
	private static final SessionFactory sessionfactory;
	 static {
	        try {
	            sessionfactory = new Configuration().addResource("./resources/student.hbm.xml")
	            		.configure("./resources/hibernate.cfg.xml")
	                    .buildSessionFactory();
	        } catch (Throwable ex) {
	            System.err.println("Initial SessionFactory creation failed." + ex);
	            throw new ExceptionInInitializerError(ex);
	        }
	    }


	public StudentDao() {
		// TODO Auto-generated constructor stub
	}

	
	public static Studentbean Retrieve(final String sID) {
		
		Session session=sessionfactory.openSession();
		Transaction transaction=session.beginTransaction();
		Query query = session.createQuery("from Studentbean");	    
		List<Studentbean> stud = query.list();
		
		List<String> list = new ArrayList<String>();
		if(stud!=null&&stud.size()>0){
			for (int i = 0; i < stud.size(); i++) {
				if(stud.get(i).getStudentId().equals(sID)){
					return stud.get(i);
				}
			}
			
		}
		transaction.commit();
		
		
		// TODO Auto-generated method stub
		return null;
	}

	
	public static boolean IdInuse(final String Id) {
		
		Session session=sessionfactory.openSession();
		Transaction transaction=session.beginTransaction();
		Query query = session.createQuery("from Studentbean");	    
		List<Studentbean> stud = query.list();
		
		List<String> list = new ArrayList<String>();
		if(stud!=null&&stud.size()>0){
			for (int i = 0; i < stud.size(); i++) {
				if(stud.get(i).getStudentId().equals(Id)){
					return true;
				}
			}
			
		}
		transaction.commit();
		// TODO Auto-generated method stub
		return false;
	}
	public static List<String> list_ID(){
		
		Session session=sessionfactory.openSession();
		Transaction transaction=session.beginTransaction();
		Query query = session.createQuery("from Studentbean");	    
		List<Studentbean> stud = query.list();
		
		List<String> list = new ArrayList<String>();
		if(stud!=null&&stud.size()>0){
			for (int i = 0; i < stud.size(); i++) {
				list.add(stud.get(i).getStudentId());
			}
		}
		transaction.commit();
		
		return list;
		
	}
	public static List<Studentbean> List_students(){
		
		
		Session session=sessionfactory.openSession();
		Transaction transaction=session.beginTransaction();
		Query query = session.createQuery("from Studentbean");	    
		List<Studentbean> stud = query.list();
		transaction.commit();
				
		return stud;
	}

	//@Override
	public static  boolean SaveForm(String studentId, String name, String address,
			String city, String state, String zip, String tel, String email,
			String url, String date,String how, String like, 
			String graduationMonth, String year, String recommendation,
			String comment, String data) {
		String seq="emp_sequence";
		int i=1;
		System.out.println("inserting info");			
		Session session=sessionfactory.openSession();	
		Transaction transaction=session.beginTransaction();
		Studentbean sb=new Studentbean(studentId, name, address, city, state, zip, tel, email, url, date,how, like,  graduationMonth, year, recommendation, comment, data);
		//sb.setStudentId(studentId);
		session.save(sb);
		transaction.commit();
		System.out.println("Information successfully inserted!!!");
		
		// TODO Auto-generated method stub
		return true;
	}
	
		
	

}