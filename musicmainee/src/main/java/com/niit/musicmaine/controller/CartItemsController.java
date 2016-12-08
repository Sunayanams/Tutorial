package com.niit.musicmaine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.niit.musicmainee.Dao.CartItemsDao;
import com.niit.musicmainee.entity.CartItems;

@Controller
public class CartItemsController 
{
 @Autowired
 CartItems cartitems;
 
 @Autowired
 CartItemsDao cartitemsDao;
	
}
