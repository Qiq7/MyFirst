package com.cyexm.cyzhit.Controller;


import com.cyexm.cyzhit.DaoImpl.*;
import com.cyexm.cyzhit.POJO.*;
import com.cyexm.cyzhit.Service.RegistService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Controller
public class Start {


//    @Autowired
//    private UsersMapper m;
        @Resource
        UsersMapperImpl mapper = null;
        @Resource
        ResumeMapperImpl resumeMapper = null;
        @Resource
        ItermImpl iterm = null;
        @Resource
        RegistService registService = null;

//    @RequestMapping("/login")
//    public String login(HttpSession request)
//    {
//        Users user = (Users) request.getAttribute("user");
//        System.out.println(user);
//        System.out.println("ooo");
//        return "login.html";
//    }
    @RequestMapping("/login")
    public String login()
    {
        return "login";
    }
    @RequestMapping("/index")
    public String index()
    {
        return "index";
    }
    @RequestMapping("/logon")
    public String logon(){
        return "logon";
    }
    @RequestMapping("/")
    public String begin() { return "index"; }

    @RequestMapping("/modifyResume")
    public String modifyResume(HttpSession session,Map<String,Object> map)
    {
        Users user = (Users) session.getAttribute("user");
        Resume resume = resumeMapper.findResume(user.getUserId());
        if(resume!=null)
        {
            map.put("resume",resume);
        }else{
            Resume resume1 = new Resume();
            resume1.setPicWay("image/13.jpg");
            resume1.setSex(-1);
            resume1.setSchoolDate(new Date());
            resume1.setSex(Tools.getRandom1or0());
            map.put("resume",resume1);
        }
        map.put("user",user);
        return "modifyResume";
    }
    @RequestMapping("/editProfile")
    public String editProfile(HttpSession session,Map<String,Object> map){
        map.put("t","");
        map.put("p","");
        map.put("tp","");
        Users user = (Users) session.getAttribute("user");
        map.put("user",user);
        return "editProfile";
    }


    @RequestMapping("/publish")
    public String publish(HttpSession session,Map<String,Users> map){
        Users user = (Users) session.getAttribute("user");
        map.put("user",user);
//        System.out.println(user.getPicWay());
        return "publish";}


    @RequestMapping("/toText")
    public String text(Map<String,String> map,HttpServletRequest request, MultipartFile tp) throws IOException {
        if(tp.isEmpty())
        {
            return "redirect:text";
        }
        String path = "E:\\安装包\\后端\\cyzhit\\src\\main\\resources\\CachePicture\\";
        String fileName = tp.getOriginalFilename();
        String[] a = fileName.split("\\.");
        if(!fileName.endsWith(".jpg")&&!fileName.endsWith(".png"))
        {
            map.put("no","请上传图片！");
            return "text";
        }
        File file = new File(path+fileName);
        tp.transferTo(file);
        return "text";
    }


    @RequestMapping("/index0")
    public String index0(Map<String,Users> map,HttpSession session){
        Users user = (Users) session.getAttribute("user");
        map.put("user",user);
        return "index0"; }

    @RequestMapping("/toFail")
    public String toFail(HttpServletRequest request, Map<String,String> map)
    {
        String s = request.getParameter("tel");
        String p = request.getParameter("password");
        if(p=="")
        {
            map.put("no","请输入密码！");
        }else {
            map.put("no", "密码错误!");
        }
        map.put("tel",s);
        return "login";
    }

    @RequestMapping("/toLogin")
    public String toLogin(HttpSession request,HttpSession session)
    {
        Users user = (Users) request.getAttribute("user");
//        System.out.println(user);
//        System.out.println("kkk");
//        System.out.println(session);
        return "redirect:/index0";
//        return "redirect:/chat";
    }


    @RequestMapping("/find")
    @ResponseBody
    public String find(String tel){
//        Users a = m.findUser(username);
        Users a = mapper.user(tel);
//        System.out.println(a);
        if(a==null) return "no";
        return "ok";
    }

    @RequestMapping("/personal")
    public String personal(HttpSession session,Map<String,Object> map)
    {
        Users user = (Users) session.getAttribute("user");
        Resume resume = resumeMapper.findResume(user.getUserId());
        if(resume!=null)
        {
            map.put("resume",resume);
        }else{
            Resume resume1 = new Resume();
            resume1.setPicWay("image/13.jpg");
            resume1.setSex(-1);
            map.put("resume",resume1);
        }
        List<Iterm> iterms = iterm.findIterms(user.getUserId());
        map.put("iterms",iterms);
//        System.out.println(resume);
        map.put("user",user);
//        System.out.println(resume);
//        System.out.println(user.getUserId());
        List<GetResume> getResumes = registService.GetgetResume(user.getUserId());
        map.put("getResume",getResumes);
        List<Participation> lp = registService.getParticipation(user.getUserId());
        map.put("lp",lp);
//        System.out.println(Arrays.asList(lp));
//        System.out.println(getResumes);
        return "personal";
    }


    @RequestMapping("/toLogon")
    public String toLogon(String realName, String username, String tel, String email, String password1, String password2
    , String xieyi, Map<String,String> map) {
        map.put("rn",realName);
        map.put("un",username);
        map.put("t",tel);
        map.put("e",email);
        map.put("p1",password1);
        map.put("xie","");
        if(password1.equals(password2))
        {
            map.put("p2",password2);
            if(xieyi==null)
            {
                map.put("xie","请勾选协议");
                return "logon";
            }
        }else {
            map.put("p2","");
            map.put("no","两次密码输入不相同");
            return "logon";
        }
//        System.out.println(realName);
//        System.out.println(username);
//        System.out.println(tel);
//        System.out.println(email);
//        System.out.println(password1);
//        System.out.println(password2);
//        System.out.println(xieyi);
        registService.CreatUser(realName,username,tel,email,password1);
        Users user = mapper.user(tel);
        System.out.println(user.getPicWay());
        System.out.println(user.getUserId());
        registService.CreatResume(user.getUserId(), user.getPicWay(),user.getRealName(),user.getTel(), user.getEmail());
        return "login";
    }

    @RequestMapping("/save0")
    public String save0(HttpSession session, String name,String username,String phone
    ,String address,String email,String password1,String password2,String date,MultipartFile tp
    ,Map<String,Object> map) throws ParseException, IOException {
        map.put("t","");
        map.put("p","");
        map.put("tp","");
        Users user = (Users) session.getAttribute("user");
        user.setRealName(name);
        user.setUsername(username);user.setAddr(address);user.setEmail(email);
        user.setBirthdate(DataImpl.getData(date));
        Users user1 = mapper.findUser(phone);
        if(!phone.equals(user.getTel())&&user1!=null)
        {
            map.put("t","该手机号已绑定账户");
        }else{
            user.setTel(phone);
            if(!tp.isEmpty()&&!(tp.getOriginalFilename().endsWith(".jpg")||tp.getOriginalFilename().endsWith(".png")))
            {
                map.put("tp","请上传图片");
            }else{
                if (!tp.isEmpty()) {
                    String path = "E:\\安装包\\后端\\cyzhit\\src\\main\\resources\\static\\";
                    user.setPicWay("headSculpture/" + user.getUserId() + user.getTel() + tp.getOriginalFilename());
                    File file = new File(path + user.getPicWay());
                    tp.transferTo(file);
                }
//                System.out.println(user.getPicWay());
                    if (!password1.equals(password2)) {
                        map.put("p", "两次密码不一致");
                    } else {
                        user.setPassword(password1);
                        mapper.UpDateUser(user);
//        System.out.println(user.getTel());
//        System.out.println(user.getPicWay());
//        System.out.println(user.getPassword());
//        System.out.println(name);
//        System.out.println(username);
//        System.out.println(phone);
//        System.out.println(address);
//        System.out.println(email);
//        System.out.println(password1);
//        System.out.println(password2);
//        System.out.println(date);
//        System.out.println(tp.getOriginalFilename());
                    }
            }
        }
        session.setAttribute("user",user);
        map.put("user",user);
//        System.out.println(user.getPicWay());
//        System.out.println(user);
//        System.out.println(name);
//        System.out.println(username);
//        System.out.println(phone);
//        System.out.println(address);
//        System.out.println(email);
//        System.out.println(password1);
//        System.out.println(password2);
//        System.out.println(date);
//        System.out.println(tp.getOriginalFilename());
        return "redirect:editProfile";
    }

    @RequestMapping("/save1")
    public String save1(HttpSession session,Map<String,Object> map,MultipartFile file,String name,String phone,String email,int age,
                        int sex,String address,String time1,String major,String school,String career,int pay,String function
    ,String type,String location,String time2,String company,String post,String description) throws IOException, ParseException {
        Users user = (Users) session.getAttribute("user");
        Resume resume = resumeMapper.findResume(user.getUserId());
        map.put("user",user);
        if (!file.isEmpty()&&(file.getOriginalFilename().endsWith(".jpg")||file.getOriginalFilename().endsWith(".png"))) {
            String path = "E:\\安装包\\后端\\cyzhit\\src\\main\\resources\\static\\";
            resume.setPicWay("resumePic/" + user.getUserId() + user.getTel() + file.getOriginalFilename());
            File file2 = new File(path + resume.getPicWay());
            file.transferTo(file2);
        }

        //System.out.println(file.getOriginalFilename());
        resume.setRealName(name);
        resume.setTel(phone);
        resume.setEmail(email);
        resume.setAge(age);
        resume.setSex(sex);
        resume.setNowAddr(address);
        resume.setSchoolDate(DataImpl.getData(time1));
        resume.setEducation(career);
        resume.setSalary(pay);
        resume.setFunction(function);
        resume.setType(type);
        resume.setAddr(location);
        resume.setWorkDate(time2);
        resume.setCompany(company);
        resume.setWorkContent(description);
        resume.setSchool(school);
        resume.setMajor(major);
        resume.setPost(post);
        map.put("resume",resume);
        resumeMapper.UpDate(resume);

//        System.out.println(name);
//        System.out.println(phone);
//        System.out.println(email);
//        System.out.println(age);
//        System.out.println(sex);
//        System.out.println(address);
//        System.out.println(time1);
//        System.out.println(major);
//        System.out.println(school);
//        System.out.println(career);
//        System.out.println(pay);
//        System.out.println(function);
//        System.out.println(type);
//        System.out.println(location);
//        System.out.println(time2);
//        System.out.println(company);
//        System.out.println(description);



        return "redirect:modifyResume";}
//
//    @RequestMapping("/logon/in")
//    public String logon(HttpServletRequest res)
//    {
//        String username = res.getParameter("username"),
//        password = res.getParameter("password"),
//        password2 = res.getParameter("password2"),
//        sf = res.getParameter("sf");
//        int x = Integer.parseInt(sf);
//        System.out.println(username);
//        System.out.println(password);
//        System.out.println(password2);
//        System.out.println(x);
//        m.creat(username,password,x);
//        return "index.html";
//    }

}
