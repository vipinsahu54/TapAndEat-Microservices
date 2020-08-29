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
import com.tapandeat.price.model.Items;

@RunWith(MockitoJUnitRunner.class)
public class ItemRepositoryServiceTest {
	
	@InjectMocks
	private ItemRepositoryService repositoryService;
	
	@Mock
	private ItemRepository itemRepository;
	
	private static final String CUISINE_NAME="Indian";
	
	@Test
	public void testFindByCuisine() {
		Mockito.when(itemRepository.findAll()).thenReturn(getItems());
		List<Items> cuisine = repositoryService.findByCuisine(CUISINE_NAME);
		Assert.assertEquals("TestItem1", cuisine.get(0).getName());
		Assert.assertEquals("TestItem2", cuisine.get(1).getName());
	}
	
	@Test
	public void testFindAll() {
		Mockito.when(itemRepository.findAll()).thenReturn(getItems());
		List<Items> cuisine = repositoryService.findAll();
		Assert.assertEquals("TestItem1", cuisine.get(0).getName());
		Assert.assertEquals("TestItem2", cuisine.get(1).getName());
	}
	
	@Test
	public void testFindById() {
		Long itemId=100l;
		Mockito.when(itemRepository.findById(itemId)).thenReturn(Optional.of(getItem()));
		Items cuisine = repositoryService.findById(itemId);
		Assert.assertEquals("TestItem1", cuisine.getName());
	}
	
	@Test
	public void testSave() {
		Mockito.when(itemRepository.save(getItem())).thenReturn(getItem());
		repositoryService.saveItem(getItem());
		Mockito.verify(itemRepository).save(getItem());
	}
	
	private List<Items> getItems(){
		List<Items> list=new ArrayList<Items>();
		
		Cuisine cuisine =new Cuisine();
		cuisine.setName(CUISINE_NAME);
		Items i1= new Items();
		i1.setName("TestItem1");
		i1.setDescription("Test Description");
		i1.setCuisine(cuisine);
		Items i2= new Items();
		i2.setName("TestItem2");
		i2.setDescription("Test Description");
		i2.setCuisine(cuisine);
		list.add(i1);
		list.add(i2);
		return list;
	}
	
	private Items getItem() {
		Cuisine cuisine =new Cuisine();
		cuisine.setName(CUISINE_NAME);
		Items items=new Items();
		items.setId(100l);
		items.setName("TestItem1");
		items.setDescription("Test Description");
		items.setCuisine(cuisine);
		return items;
	}
}
