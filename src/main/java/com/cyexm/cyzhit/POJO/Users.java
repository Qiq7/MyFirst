package com.cyexm.cyzhit.POJO;

import com.cyexm.cyzhit.DaoImpl.DataImpl;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.Objects;


@Data
@Getter
@Setter
public class Users implements UserDetails {
    private String username;
    private String password;
    private int userId;
    private int roles;
    private String tel;
    private String email;
    private String addr;
    private Date birthdate;
    private String realName;
    private String picWay;



    public String getAuthority()
    {
        if (roles == 1) return "admin";
        else if(roles == 0) return "user";
        else return "unknown";
    }

    public boolean isPic()
    {
        return this.picWay==null;
    }
    public boolean isRName(){return this.realName==null;}
    public boolean isAdr(){return this.addr==null;}
    public boolean isBdate(){return  this.birthdate==null;}
    public boolean isEml(){return this.email==null;}
    public String getShowDate(){return DataImpl.getYMd(this.birthdate); }
    public int getShowAge()
    {
        return DataImpl.getAge(this.birthdate);
    }


    public Users() {
    }

    public Users(String username, String password, int roles, String tel, String email, String realName, String picWay) {
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.tel = tel;
        this.email = email;
        this.realName = realName;
        this.picWay = picWay;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return AuthorityUtils.commaSeparatedStringToAuthorityList(this.getAuthority());
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }


//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Users users = (Users) o;
//        return userId == users.userId &&
//                password.equals(users.password) &&
//                tel.equals(users.tel);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(password, userId, tel);
//    }
}
