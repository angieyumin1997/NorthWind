package Northwind.Workshop21;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.junit.jupiter.api.Assertions.fail;
import org.springframework.mock.web.MockHttpServletResponse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@AutoConfigureMockMvc
@SpringBootTest
class Workshop21ApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Test
	void contextLoads() {
		RequestBuilder req = MockMvcRequestBuilders.get("/api/customers")
                .accept(MediaType.APPLICATION_JSON);

		MvcResult result = null;

		try {
            result = mvc.perform(req).andReturn();
        } catch (Exception ex) {
            fail("cannot perform mvc invocation", ex);
            return;
        }
		
		MockHttpServletResponse resp = result.getResponse();
        try {
            String payload = resp.getContentAsString();
            assertNotNull(payload);
        } catch (Exception ex) {
            fail("cannot retrieve response payload", ex);
            return;
        }
                
	}

	@Test
	void shouldReturn200ForCustomerDetails() {
		RequestBuilder req = MockMvcRequestBuilders.get("/api/customer/1")
                .accept(MediaType.APPLICATION_JSON);

		MvcResult result = null;

		try {
            result = mvc.perform(req).andReturn();
        } catch (Exception ex) {
            fail("cannot perform mvc invocation", ex);
            return;
        }
		
		MockHttpServletResponse resp = result.getResponse();
        try {
            String payload = resp.getContentAsString();
            assertNotNull(payload);
        } catch (Exception ex) {
            fail("cannot retrieve response payload", ex);
            return;
        }
                
	}

	@Test
	void shouldReturn200ForCustomerOrders() {
		RequestBuilder req = MockMvcRequestBuilders.get("/api/customer/1/orders")
                .accept(MediaType.APPLICATION_JSON);

		MvcResult result = null;

		try {
            result = mvc.perform(req).andReturn();
        } catch (Exception ex) {
            fail("cannot perform mvc invocation", ex);
            return;
        }
		
		MockHttpServletResponse resp = result.getResponse();
        try {
            String payload = resp.getContentAsString();
            assertNotNull(payload);
        } catch (Exception ex) {
            fail("cannot retrieve response payload", ex);
            return;
        }
                
	}


}
