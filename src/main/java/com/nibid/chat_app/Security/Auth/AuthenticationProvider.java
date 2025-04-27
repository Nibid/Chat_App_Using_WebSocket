package com.nibid.chat_app.Security.Auth;

import com.nibid.chat_app.Security.Model.JwtAuthenticationToken;
import com.nibid.chat_app.Security.Model.JwtUser;
import com.nibid.chat_app.Security.Model.JwtUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    @Autowired
    private JwtValidator validator;

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {

    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken) authentication;
        String token = jwtAuthenticationToken.getToken();

        JwtUser jwtUser = validator.validate(token);
        if (jwtUser == null) {
            throw new NotFound("JWT Token is incorrect.");
        }

        List<GrantedAuthority> grantedAuthorityList = AuthorityUtils
                .createAuthorityList(jwtUser.getRole());

        return new JwtUserDetails(jwtUser.getUserName(),
                token,
                jwtUser.getId(),
                grantedAuthorityList);
    }
}
