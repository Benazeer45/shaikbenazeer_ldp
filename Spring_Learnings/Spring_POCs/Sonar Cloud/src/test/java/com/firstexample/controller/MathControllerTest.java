//package com.firstexample.controller;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest(classes = MathController.class) // Add this line
//class MathControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Test
//    void testAdd() throws Exception {
//        mockMvc.perform(get("/math/add?a=5&b=3"))
//                .andExpect(status().isOk())
//                .andExpect(content().string("8"));
//    }
//
//    @Test
//    void testSubtract() throws Exception {
//        mockMvc.perform(get("/math/subtract?a=5&b=3"))
//                .andExpect(status().isOk())
//                .andExpect(content().string("2"));
//    }
//}
