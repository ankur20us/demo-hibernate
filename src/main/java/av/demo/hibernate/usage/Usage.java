package av.demo.hibernate.usage;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import av.demo.hibernate.modal.Users;

public class Usage {

	public static void main(String[] args) {
		
		SessionFactory factory = null;
		Session session = null;
		
		
		try {
			Configuration 	cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			System.out.println("hello");	

			factory = cfg.buildSessionFactory();
			session = factory.openSession();
			
			/***
			 * AV:
			 * 		Inserting the data
			 */
			Transaction tx = session.beginTransaction();
			Users user=new Users();
			 	user.setUserId(101);
				user.setUname("reeta");
				user.setAge(29);
			
				session.save(user);
				System.out.println("Object saved successfully.....!!");
			tx.commit();			
			
			/***
			 * AV:
			 * 		Getting the data
			 */
			user = (Users)session.load(Users.class,new Integer(101));
			System.out.println("Got the data : " + user);
			
			/***
			 * AV:
			 * 		Updating the data
			 */
			tx = session.beginTransaction();
				user = (Users)session.load(Users.class,new Integer(101));
				user.setAge(28);
			tx.commit();
			
			
			/***
			 * AV:
			 * 		Delete the data
			 */
			tx = session.beginTransaction();
				user = (Users)session.load(Users.class,new Integer(101));
				session.delete(user);
			tx.commit();
			
			
		} catch (Exception e) {
			System.out.println("got the exception " + e.getMessage());
		} finally{
			if(session != null){
				session.close();
			}
			if(factory != null){
				factory.close();				
			}
		}
		
	}
}
