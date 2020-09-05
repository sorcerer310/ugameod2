package com.bsu.ugame.gameparams.service;

import com.bsu.ugame.gameparams.jooq.db.tables.TUser;
import com.bsu.ugame.gameparams.jooq.db.tables.TUserroles;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Result;
import org.jooq.types.UInteger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * 验证用户数据服务
 */
public class GPUserDetailsService implements UserDetailsService {
    @Autowired
    DSLContext dsl;

    @Bean
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        TUser tu = TUser.T_USER;
        TUserroles tur = TUserroles.T_USERROLES;

        Record4<UInteger,String,String,String> tr = dsl.select(tu.ID,tu.NAME,tu.PWD,tu.PWD_SALT).from(tu)
                .where(tu.NAME.eq(s))
                .fetchOne();

        Result<Record1<String>> result = dsl.select(tur.ROLE_NAME).from(tur).where(tur.USERNAME.eq(s)).fetch();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for(Record1<String> record:result)
            authorities.add(new SimpleGrantedAuthority(record.value1()));

        User user = new User(tr.value2(),tr.value3(),authorities);
        return user;

    }
}
