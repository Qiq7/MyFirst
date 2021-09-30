package com.cyexm.cyzhit.Controller;

import com.cyexm.cyzhit.POJO.Users;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;


@Controller
public class UseController {

    @RequestMapping("/chat")
    public String chat()
    {
        return "chat";
    }

    @RequestMapping("/getUsername")
    @ResponseBody
    public String getUserName(HttpSession session)
    {
        Users users = (Users) session.getAttribute("user");
        return users.getRealName();
    }
}
