package com.cjo.starter.module.websocketdemo;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * @author hieubui
 * @since 2019-05-01
 */
@Controller
@MessageMapping("${url.prefix}/websocket")
public class WebSocketTestController {

    @MessageMapping("test")
    @SendTo("/topic/test")
    public String sendToTopic() throws Exception {
        return "test topic message";
    }

}
