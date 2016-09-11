package com.marcus.jersey.api;

import java.io.IOException;
import java.net.URI;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;

import com.marcus.jersey.entity.User;
import com.marcus.jersey.entity.UserCache;
import com.sun.jersey.api.NotFoundException;

@Path("/users")
public class UserResource {
	@Context
	private UriInfo uriInfo;
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void newUser(
			@FormParam("userId") String userId,
			@FormParam("userName") String userName,
			@FormParam("userAge") int userAge,
			@Context HttpServletResponse servletResponse) throws IOException {
		User user = new User(userId, userName, userAge);	
		System.out.println(user.toString());
		UserCache.getUserCache().put(userId, user);		
		/*URI uri = uriInfo.getAbsolutePathBuilder().path(userId).build();
		System.out.println(uri);
		Response.created(uri).build();*/
	}
	
	@DELETE
	@Path("/{id}")
	public void deleteContact(@PathParam("id") String id) {
		User user = UserCache.getUserCache().remove(id);		
		if (user == null) {
			throw new NotFoundException("No such User");
		}
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_XML)
	public Response putUser(
			JAXBElement<User> jaxbContact,
			@PathParam("id") String id) {
		User user = jaxbContact.getValue();
		System.out.println(user.toString());
		Response res;
		if (UserCache.getUserCache().containsKey(id)) {
			res = Response.noContent().build();
		} else {
			res = Response.created(uriInfo.getAbsolutePath()).build();
		}		
		return res;
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public User getUser(@PathParam("id") String id) {
		User user = UserCache.getUserCache().get(id);
		if (user == null) {
			throw new NotFoundException("Not Found User");
		}
		System.out.println(user.toString());
	    return user;
	}

}
