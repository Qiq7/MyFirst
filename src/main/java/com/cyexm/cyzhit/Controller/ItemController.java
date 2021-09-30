package com.cyexm.cyzhit.Controller;


import com.cyexm.cyzhit.DaoImpl.*;
import com.cyexm.cyzhit.POJO.*;
import com.cyexm.cyzhit.Service.RegistService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

@Controller
public class ItemController {

    @Resource
    ItermsImpl iterms;

    @Resource
    ResumeMapperImpl resumeMapper;

    @Resource
    ManageImpl manage;

    @Resource
    RegistService registService;

    @Resource
    ItermImpl iterm;


    @RequestMapping("/editIterm")
    public String edit_item(HttpSession session, Map<String,Object> map,int ItermId){
        Users user = (Users) session.getAttribute("user");
        Iterm iterm0 = iterm.findIterm(ItermId);
        map.put("user",user);
        map.put("iterm",iterm0);
        map.put("iterId",ItermId);
//        System.out.println(ItermId);
        return "edit-item";
    }


    @RequestMapping("/itermsave0")
    public String itermsave0(HttpSession session, Map<String,Object> map,int ItermId, String title, String type, int secrecy, String technology, String time
            , int schedule, int number, String city, int budget, String description, MultipartFile file) throws ParseException, IOException {
        Users user = (Users) session.getAttribute("user");
        Iterm iterm0 = iterm.findIterm(ItermId);
//        map.put("user",user);
//        map.put("iterm",iterm0);
        if (!file.isEmpty()&&(file.getOriginalFilename().endsWith(".jpg")||file.getOriginalFilename().endsWith(".png"))) {
            String path = "E:\\安装包\\后端\\cyzhit\\src\\main\\resources\\static\\itermPic\\";
            path = path + user.getTel() + file.getOriginalFilename();
            File file2 = new File(path);
            file.transferTo(file2);
            iterm0.setPicWay(""+user.getTel() + file.getOriginalFilename());
        }
//        System.out.println(ItermId);
        iterm0.setItermName(title);
        iterm0.setType(type);
//        System.out.println(secrecy);
        iterm0.setAuthority(secrecy);
        iterm0.setTechnical(technology);
        iterm0.setStartDate(DataImpl.getData(time));
        iterm0.setStatus(schedule);
        iterm0.setMemberNum(number);
        iterm0.setItermAddr(city);
        iterm0.setBudget(budget);
        iterm0.setItermContent(description);
        iterm.UpIterm(iterm0);
//        System.out.println(ItermId);
        map.put("user",user);
        map.put("iterm",iterm0);
        return "edit-item";
    }

    @RequestMapping("/deny")
    public String deny(int itermsId){
        //Iterms iterm = iterms.ItermsOne(itermsId);
        //iterm.setStatus(-1);
        iterms.ItermsDel(itermsId);
//        System.out.println(iterm);
//        System.out.println(itermsId);
        return "redirect:/personal";
    }

    @RequestMapping("/ok")
    public String ok(int itermsId){
        Iterms iterm = iterms.ItermsOne(itermsId);
        iterm.setStatus(1);
        iterms.ItermsUpdate(iterm);
        registService.ManageCreat(iterm);
//        System.out.println(iterm);
//        System.out.println(itermsId);
        return "redirect:/personal";
    }

    @RequestMapping("/deliver")
    public String deliver(HttpSession session, Map<String,Object> map, int itermId, int userId)
    {

        Users user = (Users) session.getAttribute("user");//当前user
        Iterm iterm1 = iterm.findIterm(itermId);
        Users user1 = registService.findUser1(userId);      //boos
        Iterms iterm3 = iterms.ItermsFind(user.getUserId(),itermId);
        if(iterm3==null)
        {
            registService.CreatIterms(itermId,user.getUserId(),user1.getUserId());
            Iterms iterm2 = iterms.ItermsFind(user.getUserId(),itermId);
            map.put("iterm2",iterm2);
        }else {
            map.put("iterm2",iterm3);
        }
        map.put("user",user);
        map.put("iterm",iterm1);
        map.put("user1",user1);
//        System.out.println(itermId);
//        System.out.println(userId);
        return "item-show";
    }

    @RequestMapping("/itermShow")
    public String itermShow(HttpSession session, Map<String,Object> map, int itermId,int userId)
    {

        Users user = (Users) session.getAttribute("user");  //当前user
        Iterm iterm1 = iterm.findIterm(itermId);               //当前项目
        Users user1 = registService.findUser1(userId);         //boos
        Iterms iterm2 = iterms.ItermsFind(user.getUserId(),itermId);     //关系
        map.put("iterm2",new Iterms());
        if(iterm2!=null)
        {
            map.put("iterm2",iterm2);
        }
//        System.out.println(iterm2);
        map.put("user",user);
        map.put("iterm",iterm1);
        map.put("user1",user1);
//        System.out.println(iterm2);
//        System.out.println(itermId);
//        System.out.println(userId);
        return "item-show";
    }

    @RequestMapping("/resumeShow")
    public String resumeShow(HttpSession session,int resumeId,Map<String,Object> map)
    {
        Users user = (Users) session.getAttribute("user");
        Resume resume = resumeMapper.findResume1(resumeId);
        map.put("user",user);
        map.put("resume",resume);
        return "resume-show";
    }
    @RequestMapping("/save3")
    public String save3(HttpSession session,Map<String,Object> map,int manageId,int itermId,int type)
    {
        Users user = (Users) session.getAttribute("user");
        Manage manage0 = manage.findManage(manageId);
        Iterms its = iterms.ItermsFind(manage0.getUserId(),manage0.getItermId());
        its.setLimit1(type);
        iterms.ItermsUpdate(its);
        manage0.setAuthority(type);
        manage.ManageUpDate(manage0);
//        System.out.println(manage0);
        map.put("user",user);
        List<Manage> manages = manage.FindAll(itermId);
        map.put("manages",manages);
        return "manage";
    }

    @RequestMapping("/save4")
    public String save4(HttpSession session,Map<String,Object> map,int manageId)
    {
        Manage mana = manage.findManage(manageId);
        Iterms its = iterms.ItermsFind(mana.getUserId(),mana.getItermId());
        iterms.ItermsDel(its.getItermsId());
        manage.manageDel(manageId);
        int itermId = (int) session.getAttribute("itermId");
        List<Manage> manages = manage.FindAll(itermId);
        Users user = (Users) session.getAttribute("user");
        map.put("user",user);
        map.put("manages",manages);
        return "manage";
    }

    @RequestMapping("/manage")
    public String manage(HttpSession session,Map<String,Object> map,int itermId)
    {
        session.setAttribute("itermId",itermId);
        List<Manage> manages = manage.FindAll(itermId);
        Users user = (Users) session.getAttribute("user");
        map.put("user",user);
        map.put("manages",manages);
        System.out.println(itermId);
        return "manage";
    }
    @RequestMapping("/searchIterm")
    public String searchIterm(HttpSession session,Map<String,Object> map){
        Users user = (Users) session.getAttribute("user");
        List<Iterm> list = iterm.fidAll();
        map.put("user",user);
        map.put("list",list);
        return "search-item";}
    @RequestMapping("/searchResume")
    public String searchResume(HttpSession session,Map<String,Object> map){
        Users user = (Users) session.getAttribute("user");
        List<Resume> list = resumeMapper.findAll();
        map.put("list",list);
        map.put("user",user);

        return "search-resume";
    }

    @RequestMapping("/delIterm")
    public String delIterm(int itermId){
//        System.out.println(itermId);
        iterm.delIterm(itermId);
        return "redirect:/personal";
    }

    @RequestMapping("/toPublish")
    public String toPublish(HttpSession session, String title, String type, int secrecy, String technology, String time
    , int schedule, int number, String city, int budget, String description, MultipartFile file) throws IOException, ParseException {

        Users user = (Users) session.getAttribute("user");
        String path = "E:\\安装包\\后端\\cyzhit\\src\\main\\resources\\static\\";
        String mr = "itermPic\\";
        String path1 =mr + "0.jpg";
        if (!file.isEmpty()&&(file.getOriginalFilename().endsWith(".jpg")||file.getOriginalFilename().endsWith(".png"))) {
            path1 = mr + user.getTel() + file.getOriginalFilename();
            File file2 = new File(path+path1);
            file.transferTo(file2);
        }
         int x = registService.CreatIterm(title,type,secrecy,technology,time,schedule,number,city,budget,description,path1,user.getUserId());
//        System.out.println(path1);
//        System.out.println(title);
//        System.out.println(type);
//        System.out.println(secrecy);
//        System.out.println(technology);
//        System.out.println(time);
//        System.out.println(schedule);
//        System.out.println(number);
//        System.out.println(city);
//        System.out.println(budget);
//        System.out.println(description);
//        System.out.println(user);
        registService.CreatItermsAdmin(x,user.getUserId(), user.getUserId());
        return "redirect:/personal";
    }
}
