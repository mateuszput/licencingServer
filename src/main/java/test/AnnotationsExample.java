////TODO: usunac calosc
//package test;
//
//import java.util.List;
//
//import org.hibernate.Query;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.AnnotationConfiguration;
//
//import com.mateuszput.licencingserver.entity.Application;
//import com.mateuszput.licencingserver.entity.Licence;
//import com.mateuszput.licencingserver.entity.Owner;
//
//public class AnnotationsExample {
//
//	private static SessionFactory factory = new AnnotationConfiguration()
//			.configure().buildSessionFactory();
//	
//	public static void main(String... args) {
//		Session session = factory.openSession();
//		try {
//			session.beginTransaction();
//			System.out.println("Creating data...");
////			createData(session);
//			System.out.println("Displaying data...");
//			displayData(session);
//			session.getTransaction().commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//			session.getTransaction().rollback();
//		} finally {
//			if (session.isOpen())
//				session.close();
//		}
//	}
//	
//	
//    public static void createData(Session session) {
//    	Owner owner = new Owner("Mateusz");
//    	Application application = new Application("Aplikacja 1");
//    	Licence licence = new Licence("Licencja 1");
//    	
//    	//Dodaje wlasciciela w Encji Applikacja
//    	licence.setApplication(application);
//    	application.getLicence().add(licence);
//    	licence = new Licence("Licencja 2");
//    	licence.setApplication(application);
//    	application.getLicence().add(licence);
//    	
//    	application.setOwner(owner);
//    	owner.getApplications().add(application);
//    	
//    	application = new Application("Aplikacja 2");
//    	licence = new Licence("Licencja 3");
//    	licence.setApplication(application);
//    	application.getLicence().add(licence);
//    	
//    	application.setOwner(owner);
//    	owner.getApplications().add(application);
//    	
//    	session.save(owner);
//    }
//    
//    @SuppressWarnings("unchecked")
//    public static void displayData(Session session) {
//        Query pubQuery = session.createQuery("from Owner");
//
//        List<Owner> owners = (List<Owner>) pubQuery.list();
//        System.out.println("Identified " + owners.size() + " owners");
//        System.out.println();
//
//        for (Owner owner : owners) {
//            System.out.println("Owner: " + owner.getName());
//            
//            for(Application app : owner.getApplications()){
//            	System.out.println("App: " + app.getName());
//            	
//            	for(Licence lic : app.getLicence()){
//            		System.out.println(" Lic: " + lic.getName());
//            	}
//            }
//        }
//    }
//}
