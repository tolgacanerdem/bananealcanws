package com.bananealcanws.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.bananealcanws.dao.GiftDao;
import com.bananealcanws.model.Gift;

@Path("/GiftService")
public class GiftService {

	@GET
	@Path("/Gifts")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Gift> getAllGifts() throws ClassNotFoundException {
		GiftDao dao = new GiftDao();
		return dao.getAllGifts();
	}

}
