package com.example;

import io.micronaut.http.annotation.*;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.MediaType;
import io.micronaut.serde.annotation.Serdeable;

@Controller("/issue")
public class IssueController {

    @Produces(MediaType.TEXT_PLAIN)
    @Get
    public String index() {
        return "Example Response";
    }

    @Post
    public SampleReturnMessage postMethod(@Body SampleInputMessage inputMessage){
      SampleReturnMessage retMessage = new SampleReturnMessage();
      retMessage.setReturnMessage("Hello " + inputMessage.getName() + ", thank you for sending the message");
      return retMessage;
    }
}

@Serdeable
class SampleInputMessage{
    private String name;

    public SampleInputMessage() {
    }

    public SampleInputMessage(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}

@Serdeable
class SampleReturnMessage{
    private String returnMessage;
    public String getReturnMessage() {
        return returnMessage;
    }
    public void setReturnMessage(String returnMessage) {
        this.returnMessage = returnMessage;
    }
}
