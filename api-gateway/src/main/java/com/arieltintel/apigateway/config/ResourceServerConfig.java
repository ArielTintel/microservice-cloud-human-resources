package com.arieltintel.apigateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@EnableResourceServer
@Configuration
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	@Autowired
	private JwtTokenStore tokenStore;

	private static final String[] PUBLIC_PATH = { "/api-oauth/oauth/token" };
	private static final String[] OPERATOR_PATH = { "/api-worker/**" };
	private static final String[] ADMIN_PATH = { "/api-payroll/**", "/api-user/**" };

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.tokenStore(tokenStore);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers(PUBLIC_PATH).permitAll()
		.antMatchers(HttpMethod.GET, OPERATOR_PATH).hasAnyRole("OPERATOR", "ADMIN")
		.antMatchers(ADMIN_PATH).hasRole("ADMIN")
		.anyRequest().authenticated();
	}
}