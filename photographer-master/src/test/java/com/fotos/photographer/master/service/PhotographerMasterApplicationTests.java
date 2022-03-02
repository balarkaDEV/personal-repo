package com.fotos.photographer.master.service;

import com.fotos.photographer.master.service.business.PhotoGMasterBusiness;
import com.fotos.photographer.master.service.model.PhotographerMaster;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("dev")
class PhotographerMasterApplicationTests {

	@Autowired
	private PhotoGMasterBusiness photoGMasterBusiness;

	@Test
	void contextLoads() {
	}

	@Test
	void testFindAllRecords() {
		List<PhotographerMaster> list = photoGMasterBusiness.findAllRecords();
		assertThat(list.size()).isGreaterThan(0);
	}

	@Test
	void testFindRecordById() {
		long id = 1;
		Optional<PhotographerMaster> item = photoGMasterBusiness.findRecordById(id);
		if (item.isPresent())
			assertThat(item.get().getId()).isEqualTo(id);
	}

	/*@Test
	void testFindRecordsByName(){
		String name = "Balarka Brahma";
		List<PhotographerMaster> list = photoGMasterBusiness.findRecordsByName(name);
		assertThat(list.size()).isGreaterThan(0);
	}*/
}
