package com.tapandeat.price.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.tapandeat.price.model.Cuisine;

@RunWith(MockitoJUnitRunner.class)
public class CuisineRepositoryServiceTest {

	@InjectMocks
	private CuisineRepositoryService repositoryService;
	
	@Mock
	private CuisineRepository cuisineRepository;
	
	@Test
	public void testFindAll() {
		Mockito.when(cuisineRepository.findAll()).thenReturn(getCuisineList());
		List<Cuisine> cuisine = repositoryService.findAll();
		Assert.assertEquals("Indian", cuisine.get(0).getName());
		Assert.assertEquals("Western", cuisine.get(1).getName());
	}
	
	@Test
	public void testFindById() {
		Long itemId=100l;
		Mockito.when(cuisineRepository.findById(itemId)).thenReturn(Optional.of(getCuisine()));
		Cuisine cuisine = repositoryService.findById(itemId);
		Assert.assertEquals("Indian", cuisine.getName());
	}
	
	@Test
	public void testSaveCuisine() {
		Mockito.when(cuisineRepository.save(getCuisine())).thenReturn(getCuisine());
		repositoryService.saveCuisine(getCuisine());
		Mockito.verify(cuisineRepository).save(getCuisine());
	}
	
	private List<Cuisine> getCuisineList(){
		List<Cuisine> cuisineList=new ArrayList<Cuisine>();
		Cuisine cuisine =new Cuisine();
		cuisine.setId(100l);
		cuisine.setName("Indian");
		cuisine.setDescription("authentic indian dishes");
		
		Cuisine cuisine2 =new Cuisine();
		cuisine2.setId(101l);
		cuisine2.setName("Western");
		cuisine2.setDescription("authentic western dishes");
		
		cuisineList.add(cuisine);
		cuisineList.add(cuisine2);
		
		return cuisineList;
	}
	
	private Cuisine getCuisine() {
		Cuisine cuisine =new Cuisine();
		cuisine.setId(100l);
		cuisine.setName("Indian");
		cuisine.setDescription("authentic indian dishes");
		return cuisine;
	}
}
