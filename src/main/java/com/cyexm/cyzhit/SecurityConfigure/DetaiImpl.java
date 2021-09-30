package com.cyexm.cyzhit.SecurityConfigure;
import com.cyexm.cyzhit.DaoImpl.UsersMapperImpl;
import com.cyexm.cyzhit.Mapper.UsersMapper;
import com.cyexm.cyzhit.POJO.Users;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Service
public class DetaiImpl implements UserDetailsService {
//    @Resource
//    UsersMapper m = null;


    @Resource
    UsersMapperImpl mapper;


    @Resource
    HttpSession session;

    @Resource
    private PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String tel) throws UsernameNotFoundException {
        Users users = mapper.user(tel);
//        System.out.println(users);
//        System.out.println("ok");
        if (users==null) throw new UsernameNotFoundException(" no f");
        String password = passwordEncoder.encode(users.getPassword());
        session.setAttribute("user",users);
        return new User(users.getTel(),password,users.getAuthorities());
//        Users users = m.find(username);
//        if(users==null) throw new UsernameNotFoundException("no f");
//        String password = passwordEncoder.encode(users.getPassword());
//        return new User(username,password, AuthorityUtils.commaSeparatedStringToAuthorityList("user"));
    }
}
