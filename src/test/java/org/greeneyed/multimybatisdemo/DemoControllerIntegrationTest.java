package org.greeneyed.multimybatisdemo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc(secure = true)
public class DemoControllerIntegrationTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void shouldReturnDifferentDatabases() throws Exception {
		//@formatter:off
		mockMvc
				.perform(get("/test_mappers"))
				.andExpect(status().is2xxSuccessful())
				.andExpect(content().json("{'Mapper':'Database version','anotherMapper':'hsqldbtestdb 2.3.5','oneMapper':'H2TESTDB 1.4.196'}"));
        //@formatter:on
	}

}
