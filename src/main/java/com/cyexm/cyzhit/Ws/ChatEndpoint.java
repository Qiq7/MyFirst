package com.cyexm.cyzhit.Ws;


import com.cyexm.cyzhit.DaoImpl.ChatUtils;
import com.cyexm.cyzhit.Iterceptor.UserInterceptor;
import com.cyexm.cyzhit.POJO.Message;
import com.cyexm.cyzhit.POJO.Users;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpSession;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Component
@ServerEndpoint(value ="/chat" , configurator = GetHttpSessionConfigurator.class)
public class ChatEndpoint {
    private static Map<String,ChatEndpoint> onlineUsers = new ConcurrentHashMap<>();

    private Session session;

    private HttpSession httpSession;

    private Set<String> getNames(){
        return onlineUsers.keySet();
    }

    @OnOpen
    public void onOpen(Session session, EndpointConfig config) throws JsonProcessingException {
        this.session = session;
        HttpSession httpSession = (HttpSession) config.getUserProperties().get(HttpSession.class.getName());
        this.httpSession = httpSession;
        Users username = (Users) httpSession.getAttribute("user");
        onlineUsers.put(username.getRealName(),this);
        String message = ChatUtils.getMassage(true,null,getNames());
        broadcastAllUsers(message);
    }
    private void broadcastAllUsers(String message){
        try{
            Set<String> names = onlineUsers.keySet();
            for(String name : names){
                ChatEndpoint chatEndPoint = onlineUsers.get(name);
                chatEndPoint.session.getBasicRemote().sendText(message);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @OnMessage
    public void onMessage(String message,Session session){
        try{
            ObjectMapper mapper = new ObjectMapper();
            Message mess = mapper.readValue(message,Message.class);
            String toName = mess.getToName();
            String data = mess.getMessage();
            Users username = (Users) httpSession.getAttribute("user");
            String resultMessage = ChatUtils.getMassage(false,username.getRealName(),data);
            if(StringUtils.hasLength(toName)) {
                onlineUsers.get(toName).session.getBasicRemote().sendText(resultMessage);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


//    用户断开连接的断后操作
    @OnClose
    public void onClose(Session session) throws JsonProcessingException {
        Users username = (Users) httpSession.getAttribute("user");
        if (username != null){
            onlineUsers.remove(username.getRealName());
            //UserInterceptor.onLineUsers.remove(username);
        }
        System.out.println(getNames()+"hhhh");
        //httpSession.removeAttribute("user");
        String message = ChatUtils.getMassage(true,null,getNames());
        broadcastAllUsers(message);
    }

}
