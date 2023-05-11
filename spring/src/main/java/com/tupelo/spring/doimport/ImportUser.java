package com.tupelo.spring.doimport;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: caichuang
 * @Date: 2023/4/14 11:42
 */
public class ImportUser implements ImportBeanDefinitionRegistrar {


	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

		System.out.println("ImportUser1111");

	}

	public static void main(String[] args) {

//		String prices = "dsafnaskfjnkdfnsdfksf";
//		System.out.println(merge(prices));


	}

	public ListNode reverseBetween(ListNode head, int left, int right) {

		int index = 0;
		ListNode beginNode = null;
		ListNode headNode = null;

		while (null!=head.next){

			if(left-1==index){
				headNode = head;
			}

			if(left==index){
				beginNode = head;
				ListNode next = head.next;
				if(null!=headNode){
					headNode.next = next;
				}
				next.next = beginNode;
			}
			head = head.next;
			index++;
		}


		return null;


	}

	public static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}


	
}
