package com.mdoc.snakeandladder;


import com.jayway.jsonpath.JsonPath;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import java.util.Objects;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@WebAppConfiguration
public class SnakeAndLadderApplicationTests {


    private final MockMvc mockMvc;

    @Autowired
    public SnakeAndLadderApplicationTests(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Test
    public void startGame() throws Exception{
        String sampleOutput = "Your are at position 1 with Euro 500: Please post the die roll...";
        MvcResult mvcResult = mockMvc.perform(get("/snakeNLadder/play"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON)).andReturn();
        String response = mvcResult.getResponse().getContentAsString();
        String result = JsonPath.parse(response).read("gameResult");
        assert result.equals(sampleOutput);
    }

    @Test
    public void playGame() throws Exception{
        JSONObject inputJson = new JSONObject();
        inputJson.put("diceValue", 4);
        String sampleOutput = "Your are at position 10 with Euro 600: Please post the die roll...";
        MockHttpSession session = assertPost(inputJson,sampleOutput);
        assertGet(session,sampleOutput);
    }

    private MockHttpSession assertPost(JSONObject inputJson, String sampleOutput) throws Exception {
        MvcResult mvcResult = mockMvc.perform(post("/snakeNLadder/play")
                .contentType(MediaType.APPLICATION_JSON)
                .content(inputJson.toString()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON)).andReturn();
        String response = mvcResult.getResponse().getContentAsString();
        assert JsonPath.parse(response).read("gameResult").equals(sampleOutput);
        return (MockHttpSession) mvcResult
                .getRequest().getSession();
    }

    private void assertGet(MockHttpSession session, String sampleOutput) throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/snakeNLadder/play").session(session))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON)).andReturn();
        String response = mvcResult.getResponse().getContentAsString();
        assert JsonPath.parse(response).read("gameResult").equals(sampleOutput);
    }

    @Test
    public void playGameFailure() throws Exception{
        JSONObject inputJson = new JSONObject();
        inputJson.put("diceValue", 24);
        MvcResult mvcResult = mockMvc.perform(post("/snakeNLadder/play")
                .contentType(MediaType.APPLICATION_JSON)
                .content(inputJson.toString()))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON)).andReturn();
        assert Objects.requireNonNull(mvcResult.getResolvedException()).getClass().equals(MethodArgumentNotValidException.class);
    }
}
