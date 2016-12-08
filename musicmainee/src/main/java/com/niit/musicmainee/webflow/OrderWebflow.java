//package com.niit.musicmainee.webflow;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import com.niit.musicmainee.entity.Corder;
//import com.niit.musicmainee.entity.Shippmentadd;
//
//@Component
//public class OrderWebflow {
//	@Autowired
//	Corder corder;
//
//	@Autowired
//	Shippmentadd shippmentadd;
//
//	public Corder initFlow() {
//		corder = new Corder();
//		System.out.println("Starting of method initFlow");
//		
//		System.out.println("End of  method  initFlow");
//		return corder;
//	}
//
//	public String addShippmentAddress(Corder corder, String shippmentadd) {
//		corder.setS_address(shippmentadd);
//		return "success";
//	}
//
//	
//}
