package com.tupelo.security.conf;

import com.tupelo.security.auth.CustomAuthenticationEntryPoint;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.server.resource.web.BearerTokenResolver;
import org.springframework.security.oauth2.server.resource.web.DefaultBearerTokenResolver;
import org.springframework.security.web.AuthenticationEntryPoint;

/**
 * @Author: caichuang
 * @Date: 2023/4/6 11:16
 */
@RequiredArgsConstructor
@Configuration(proxyBeanMethods = false)
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableConfigurationProperties(OAuth2ResourceServerProperties.class)
@Import(ResourceServerWebSecurityConfigurerAdapter.class)
public class ResourceServerAutoConfiguration {


	/**
	 * BearTokenResolve 允许使用 url 传参，方便 ws 连接 ps: 使用 url 传参不安全，待改进
	 * @return DefaultBearerTokenResolver
	 */
	@Bean
	@ConditionalOnMissingBean
	public BearerTokenResolver bearerTokenResolver() {
		DefaultBearerTokenResolver defaultBearerTokenResolver = new DefaultBearerTokenResolver();
		defaultBearerTokenResolver.setAllowUriQueryParameter(true);
		return defaultBearerTokenResolver;
	}

	/**
	 * 自定义异常处理
	 * @return AuthenticationEntryPoint
	 */
	@Bean
	@ConditionalOnMissingBean
	public AuthenticationEntryPoint authenticationEntryPoint() {
		return new CustomAuthenticationEntryPoint();
	}
}
