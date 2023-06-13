package com.tupelo.vote.service;

import com.alibaba.fastjson.JSONObject;
import com.tupelo.vote.dto.BaseResp;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: caichuang
 * @Date: 2023/5/25 15:13
 */
@Service
@Slf4j
public class LoginService {


	public volatile static Map<String,String> memberMap = new HashMap<>();


	@Resource
	private RestTemplate restTemplate;

	/**
	 * 登录
	 * @param mobile
	 * @return
	 */
	public void login(String code,String mobile){
		String memberId = memberMap.get(mobile);
		if(StringUtils.isNotEmpty(memberId)){
			return;
		}
		log.info("开始尝试验证码 {} {}",mobile,code);
		memberId = getMember(code, mobile);
		if(StringUtils.isNotEmpty(memberId)){
			memberMap.put(mobile,code);
			// 发起投票
			doVote(memberId);
		}
	}


	private String getMember(String code,String mobile){

		// 尝试登录

		String url = "https://www.zhibozx.cn/public/index.php/mobile/ajax/mobile_login.html?mobile="+mobile+"&store_id=133&invite_id=&code="+code+"&type=1";
		ResponseEntity<String> entity = restTemplate.getForEntity(url, String.class);

		JSONObject jsonObject = JSONObject.parseObject(entity.getBody());

		JSONObject result = jsonObject.getJSONObject("result");

		if(null==result){
			return null;
		}
		log.info("尝试返回结果 {} ",result.toJSONString());

		return result.getString("member_wxopenid");

	}

	private void doVote(String memberId){

		// 发起投票
		System.out.println("最终获取到memberId " + memberId);


		// 进行下一轮


	}


}
