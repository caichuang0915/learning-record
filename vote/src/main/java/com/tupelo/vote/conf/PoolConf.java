package com.tupelo.vote.conf;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.task.TaskExecutor;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author: caichuang
 * @Date: 2023/5/25 15:17
 */
@Configuration
public class PoolConf {


	@Bean
	public TaskExecutor voteExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(1);
		executor.setMaxPoolSize(50);
		executor.setQueueCapacity(10000);
		executor.setKeepAliveSeconds(60);
		executor.setThreadNamePrefix("vote-sub");
		// 设置拒绝策略,抛出异常
		executor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
		// 等待所有任务结束后再关闭线程池
		executor.setWaitForTasksToCompleteOnShutdown(false);
		return executor;
	}

	@Bean(name = "okHttp3ClientHttpRequestFactory")
	public OkHttp3ClientHttpRequestFactory clientHttpRequestFactory() {
		OkHttp3ClientHttpRequestFactory okHttp3ClientHttpRequestFactory = new OkHttp3ClientHttpRequestFactory();
		okHttp3ClientHttpRequestFactory.setConnectTimeout(30 * 1000);
		okHttp3ClientHttpRequestFactory.setReadTimeout(30 * 1000);
		return okHttp3ClientHttpRequestFactory;
	}

	/**
	 * 初始化RestTemplate,并加入spring的Bean工厂，由spring统一管理
	 *
	 * @param factory http客户端请求工厂
	 * @return RestTemplate
	 */
	@Bean(name = "restTemplate")
	public RestTemplate restTemplate(@Qualifier("okHttp3ClientHttpRequestFactory") OkHttp3ClientHttpRequestFactory factory) {
		RestTemplate restTemplate = new RestTemplate(factory);
		restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
		return restTemplate;
	}
}
