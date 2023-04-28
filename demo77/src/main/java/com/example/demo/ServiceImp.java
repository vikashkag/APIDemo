package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ServiceImp {

	public List<UserData> getUserData() {
		try {
			String url = "https://jsonplaceholder.typicode.com/users";
			RestTemplate restTemplate = new RestTemplate();
			UserData[] userData = restTemplate.getForObject(url, UserData[].class);
			List<UserData> userDataList = Arrays.asList(userData);
			return userDataList;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	public List<DataWrapper> getData() {
		try {
			List<UserData> userDataList = getUserData();
			List<UserPost> postDataList = getPostData();
			List<DataWrapper> dataWrappers=new ArrayList<>();
			 userDataList.stream().forEach(x->{
				 Optional<UserPost> postDataOp = postDataList.stream().filter(y-> y.getId().equals(x.getId())).findFirst();
				 if(postDataOp.isPresent()) {
					 UserPost userPost = postDataOp.get();
					 DataWrapper dataWrapper =new DataWrapper();
					 dataWrapper.setId(x.getId());
					 dataWrapper.setLat(x.getAddress().getGeo().getLat());
					 dataWrapper.setLng(x.getAddress().getGeo().getLng());
					 dataWrapper.setTitle(userPost.getTitle());
					 dataWrapper.setBody(userPost.getBody());
					 dataWrappers.add(dataWrapper);
					 
				 }
				 
			 });
			 return dataWrappers;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	private List<UserPost> getPostData() {
		try {
			String url = "https://jsonplaceholder.typicode.com/posts";
			RestTemplate restTemplate = new RestTemplate();
			UserPost[] userData = restTemplate.getForObject(url, UserPost[].class);
			List<UserPost> userPostList = Arrays.asList(userData);
			return userPostList;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

}
