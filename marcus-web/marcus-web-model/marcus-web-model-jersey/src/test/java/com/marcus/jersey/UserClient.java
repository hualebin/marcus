package com.marcus.jersey;

import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBElement;

import org.junit.Test;

import com.marcus.jersey.entity.User;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.representation.Form;

public class UserClient {
	
	private WebResource resource = null;
	
	private final static String baseUri = "http://localhost:8080/jersey/api/users";
	
	@Test
	public void insertUser() {
		resource = Client.create().resource(baseUri);
		Form form = new Form();
		form.add("userId", "002");
		form.add("userName", "ZhaoHongYan");
		form.add("userAge", 22);
		ClientResponse response = resource.type(MediaType.APPLICATION_FORM_URLENCODED).post(ClientResponse.class, form);
		System.out.println(response.getStatus());
	}
	
	@Test
	public void findUser() {
		resource = Client.create().resource(baseUri + "/002");
		String xmlRes = resource.accept(MediaType.APPLICATION_XML).get(String.class);
		System.out.println(xmlRes);
	}
	
	//@Test
	public void updateUser() {
		resource = Client.create().resource(baseUri);
		User user = new User("002", "ZhaoXiaoXuan", 24);
		ClientResponse response = resource.path(user.getUserId()).accept(MediaType.APPLICATION_XML).put(ClientResponse.class, user);
		System.out.println(response.getStatus());
	}
	
	//@Test
	public void deleteUser() {
		resource = Client.create().resource(baseUri);
		/*GenericType<JAXBElement<User>> generic = new GenericType<JAXBElement<User>>(){};
		JAXBElement<User> jaxbContact = resource.path("002").type(MediaType.APPLICATION_XML).get(generic);
		
		User user = jaxbContact.getValue();
		
		System.out.println(user.toString());*/
		
		ClientResponse response = resource.path("002").delete(ClientResponse.class);
		System.out.println(response.getStatus());
	}

}
