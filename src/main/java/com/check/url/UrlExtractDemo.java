package com.check.url;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.LinkedHashMap;
import java.util.Map;

public class UrlExtractDemo {

	public static void main(String[] args) {
		 try {
	         URL url = new URL("http://ajay.maurya.localhost.run/home?iv=dvAwNBO5i%2F4eoTl3&payload=K5OGloGy3nEgJiJGUhHwh46d33tIhhm0T5TlH6EIQhD6e%2FlEwyo9mbNawb4MmbutZGPmnXQDIzRP7iU1obI33JPC3MZRiAW%2BSyFSFAU9F6xA0QYMZekRFho%2BRtKyTLxQX6m8kvZ9nnAIn%2FxSgDfWW3bv1iehIuHQd66jN3rF%2F9NiKx2ryDOyRzu8Bg3R3jet4qv0lYGQcj1MxUv5Ydl9BpJNoJofMdtK50mPSJsL1ixpfJSdgpDwl4mAUr1dHj%2FFgGzj7pZRKXNvzqk%2FI8TKaMtCEJIEyVef6nSxQ%2Ftf7kM0kCmL%2FbLCCpF7zBEo1n%2BcXutKCuR76IIZYQiVK0F6%2FqZ5RNmL8hsN4gA08HXEBHE9WqEu8Yy133CjeSjsm8s4WA3eF97Q8gC7Wly5vi2CzDgpeH9EQkLYxxPpn4c6dUdfZm7UnckqqTC8JnRDjzV7%2FqmF0PwqEFP%2B71mW0Q%3D%3D&redirectUrl=https%3A%2F%2Fpp34secure.payu.in%2FCommonPgResponseHandler&key=JHawPgpcsgFMo4gEMSsgZMsP8R0u4RZUhCk3TwptVolDblpd5eLvN2XJIv60oYJbAroas1g7GEv96vJGe%2BJbBHBR1ddM8blFswDEe1WgC6r0e4sYj0kak121HsslhP7myiUXJxNIgm1iqIs2oVKp0Bzl2ujRB1255n8K29Y5SWjqy7rz0TASZGK5cacvF4eFhLAaZBuM%2F7sjK6sZ6r0w%2F7Y8mcMsBU4PRQGjbiQct2VqzAOp%2BGW5T43kBnKO%2B6fWPkSKTqB1sMlAf0IRIFYELq3EVEFDvdtIxkjixMt7qT02pw9Ll5nnIL0X5rbjtPXUxBt6dwovIdVjhMspzlRXlg%3D%3D");
	         Map<String, String> queryMap = splitQuery(url);
	         System.out.println(queryMap.get("redirectUrl"));

		 } catch (IOException e) {
	         e.printStackTrace();
	      }
	}
	
	 public static Map<String, String> splitQuery(URL url) {
		 Map<String, String> queryPairs = new LinkedHashMap<String, String>();
		 String query = url.getQuery();
		 
		 String[] pairs = query.split("&");
		 for (String pair: pairs) {
			 int index = pair.indexOf("=");
			 try {
				queryPairs.put(URLDecoder.decode(pair.substring(0, index), "UTF-8"), URLDecoder.decode(pair.substring(index + 1), "UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		 }
			 
		return queryPairs;
	 }
}
