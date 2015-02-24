//package com.mateuszput.licencingserver.web.controller;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.springframework.beans.BeansException;
//import org.springframework.context.ApplicationContext;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//
////TODO: do wyrzucenia
//@Controller
//public class Test {
//protected final Log logger = LogFactory.getLog(getClass());
//	
//	private ApplicationContext applicationContext;
//	
//	@RequestMapping("/test")
//	public ModelAndView welcome(){
//		logger.info("-- Request controller");
//		
//		return new ModelAndView("test");
//	}
//	
//	public void setApplicationContext(ApplicationContext applicationContext)
//	throws BeansException {
//		this.applicationContext = applicationContext;
//	}
//}



//    public ModelAndView onSubmit(HttpServletRequest request,
//                                 HttpServletResponse response, Object cmd,
//                                 BindException errors) throws Exception {
//        logger.debug(
//                "Entering PostProfileFormController handleRequest method ....");
//        PostProfiles postProfiles = (PostProfiles) cmd;
//				
//        if (null != request.getParameter("delete")) {
//            System.out.println("[Delete] button pressed ... ");
//            pps.removePostProfiles(postProfiles);
//			return new ModelAndView(new RedirectView(getSuccessView()));			
//        } else if (null != request.getParameter("update")) {
//            pps.updatePostProfiles(postProfiles);
//            System.out.println("[Update] button pressed ... ");
//			return new ModelAndView(new RedirectView(getSuccessView()));
//        } else if (null != request.getParameter("add")) {
//            pps.insertPostProfiles(postProfiles);
//            System.out.println("[Add] button pressed ... ");
//			return new ModelAndView(new RedirectView(getSuccessView()));
//        }
//		
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("postprofiles", postProfiles);
//		
//		return mav;
//    }