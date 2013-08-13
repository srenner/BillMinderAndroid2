package com.srenner.billminderandroid2;

import org.apache.http.impl.client.DefaultHttpClient;

public class PostClient {

	private DefaultHttpClient mClient;
	private String mCSRFTokenValue;
	
	public DefaultHttpClient getClient() {
		return mClient;
	}
	
	public String getCSRFTokenValue() {
		return mCSRFTokenValue;
	}
	
	public PostClient(DefaultHttpClient client, String csrfTokenValue) {
		mClient = client;
		mCSRFTokenValue = csrfTokenValue;
	}
}