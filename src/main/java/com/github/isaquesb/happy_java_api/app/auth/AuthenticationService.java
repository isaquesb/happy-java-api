package com.github.isaquesb.happy_java_api.app.auth;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationService {
    @Value("${auth.api.header-name}")
    private String headerName;

    @Value("${auth.api.secret}")
    private String secret;

    public Authentication getAuthentication(HttpServletRequest request) {
        String apiKey = request.getHeader(headerName);
        if (apiKey == null || !apiKey.equals(secret)) {
            throw new BadCredentialsException("Invalid API Key");
        }

        return new ApiKeyAuthentication(apiKey, AuthorityUtils.NO_AUTHORITIES);
    }
}
