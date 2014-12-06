import model.Studentbean;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration configuration=new Configuration().addResource("resources/student.hbm.xml");
		System.out.println("Session:::");
		
		configuration.configure("resources/hibernate.cfg.xml");
		System.out.println("finish:::");
		@SuppressWarnings("deprecation")
		SessionFactory buildSessionFactory=configuration.buildSessionFactory();
		System.out.println("Build session:" +buildSessionFactory);
		Session session=buildSessionFactory.openSession();
		System.out.println("Session:::"+session);
		
		Transaction transaction=session.beginTransaction();
		Studentbean sb=new Studentbean();
		//Studentbean sb=new Studentbean("id","","","","","","","","","","","","","","","","");
		sb.setStudentId("G00760357");
		sb.setAddress("24656 caribou square");
		session.save(sb);
		transaction.commit();
		System.out.println("Success!!!");
		

	}

}
