package echo;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.xml.ws.WebServiceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.mateuszput.licencingserver.dao.OwnerDAOImpl;

//TODO: przeniesc do odpowiedniej klasy, stworzyc dla niej interface, usunac calosc
@javax.jws.WebService(serviceName="EchoService")
public class Echo extends SpringBeanAutowiringSupport{
	@Resource
	private WebServiceContext wsCtxt;

//TODO: sprawdzic    
//    @PersistenceContext(unitName = "ownerDao")
//    private OwnerDAOImpl em;
    
//	@Autowired
//	private BlockedIPDAO blockedIPDao;
	@Autowired
	private OwnerDAOImpl ownerDao;
	
	@WebMethod
	public String echo(String input) {
//		MessageContext msgCtxt = wsCtxt.getMessageContext();
//		HttpServletRequest req = (HttpServletRequest) msgCtxt
//				.get(MessageContext.SERVLET_REQUEST);
//		String clientIP = req.getRemoteAddr();
//		System.out.println("----> IP: " + clientIP);
		
//		BlockedIPDAO blockedIPDAO = (BlockedIPDAO) applicationContext.getBean("blockedIPDao");
//		Boolean isBlocked = blockedIPDAO.isBlocked(clientIP);
//		System.out.println("----> IP blocked: " + isBlocked.toString());
//		if(blockedIPDao == null){
//			System.out.println("----> blockedIPDao Jest null'em");
//		} else{
//			System.out.println("----> blockedIPDao Nie jest null'em");
//		}
		
		
		if (ownerDao == null) {
			System.out.println("----> ownerDao Jest null'em");
		} else {
			System.out.println("----> ownerDao Nie jest null'em");
			System.out.println("----> ownerDao: " + ownerDao);
		}
		
//		Boolean isBlocked = blockedIPDao.isBlocked(clientIP);
//		System.out.println("----> IP blocked: " + isBlocked.toString());
		
		
		
		
		//TODO: ponizsze dziala:
//		HttpServletRequest servRequest = (HttpServletRequest) wsCtxt.getMessageContext().
//		get(MessageContext.SERVLET_REQUEST);
//
//		HttpSession session = (HttpSession) servRequest.getSession();
//		ServletContext servletContext = session.getServletContext();
//		WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
//		
//		OwnerDAOImpl ownerDao = (OwnerDAOImpl) wac.getBean("ownerDao");
//		System.out.println("----> ownerDao:" + ownerDao);
		
		return input;
	}


}
