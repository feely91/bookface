package com.kainos.training.dropwizard.login.frontends.resources;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.junit.Before;
import org.junit.Test;

import com.kainos.training.jersey.client.BaseClient;

public class ViewsResourceTest {

	final private static String CORRECT_USERNAME = "admin";
	final private static String CORRECT_PASSWORD = "password";

	final private static String INCORRECT_USERNAME = "WRONGUSER";
	final private static String INCORRECT_PASSWORD = "WRONGPASS";

	private BaseClient mockedClient;
	private ViewsResource resource;

	@Before
	public void setup() {
		mockedClient = mock(BaseClient.class);
		when(mockedClient.getLogin(CORRECT_USERNAME, CORRECT_PASSWORD))
				.thenReturn(Response.ok().build());
		when(mockedClient.getLogin(INCORRECT_USERNAME, INCORRECT_PASSWORD))
				.thenReturn(Response.status(Status.UNAUTHORIZED).build());
		resource = new ViewsResource(mockedClient);

	}

	@Test
	public void testLoginCallsLoginSuccessfully() throws URISyntaxException {

		Response response = resource.loginDetails(CORRECT_USERNAME,
				CORRECT_PASSWORD);

		verify(mockedClient).getLogin(CORRECT_USERNAME, CORRECT_PASSWORD);
	}

	@Test
	public void testLoginRedirectsToSuccessWhenOkReturned()
			throws URISyntaxException {
		Response actualResponse = resource.loginDetails(CORRECT_USERNAME,
				CORRECT_PASSWORD);
		Response expectedResponse = Response
				.seeOther(new URI("/login-success")).build();

		assertEquals(expectedResponse.getStatus(), actualResponse.getStatus());
		assertEquals(expectedResponse.getLocation(),
				actualResponse.getLocation());
	}

	@Test
	public void testLoginRedirectsToFailedWhenUnauthReturned()
			throws URISyntaxException {
		Response actualResponse = resource.loginDetails(INCORRECT_USERNAME,
				INCORRECT_PASSWORD);
		Response expectedResponse = Response.seeOther(new URI("/login-failure"))
				.build();

		assertEquals(expectedResponse.getStatus(), actualResponse.getStatus());
		assertEquals(expectedResponse.getLocation(),
				actualResponse.getLocation());
	}
}
