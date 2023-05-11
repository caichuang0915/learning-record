package com.tupelo.security.conf;

import org.springframework.security.config.annotation.web.HttpSecurityBuilder;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

/**
 * OAuth2资源服务器的扩展配置
 *
 * 
 */
public abstract class OAuth2ResourceServerExtensionConfigurer<H extends HttpSecurityBuilder<H>>
		extends AbstractHttpConfigurer<OAuth2ResourceServerExtensionConfigurer<H>, H> {

}
