package com.tupelo.design.math;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {


	public static void main(String[] args) {
		LRUCache lruCache = new LRUCache(2);

		lruCache.put(2,1);
		lruCache.put(1,1);
		lruCache.put(2,3);
		lruCache.put(4,1);
		System.out.println(lruCache.get(1));
		System.out.println(lruCache.get(2));

	}


	private Map<Integer,Node> hashtable;
	private Integer size;
	private Integer capacity;
	private Node head;
	private Node tail;




	public LRUCache(int capacity) {
		this.size = 0;
		this.capacity = capacity;
		this.hashtable = new HashMap();
		head = new Node();
		tail = new Node();
		head.next = tail;
		tail.prev = head;
	}

	public int get(int key) {
		Node node = hashtable.get(key);
		if(null==node){
			return -1;
		}
		// 如果存在 则移动到头部
		removeToHead(node);
		return node.value;
	}

	private void removeToHead(Node node){

		removeNode(node);

		moveToHead(node);
	}

	private void removeNode(Node node){
		Node prev = node.prev;
		Node nextNode = node.next;
		prev.next = nextNode;
		nextNode.prev = prev;
		node.prev = null;
		node.next = null;
	}

	private void moveToHead(Node node){
		Node prev = head.prev;
		Node first = head.next;
		first.prev = node;
		node.next = first;
		head.next = node;
		node.prev = head;
	}


	public void put(int key, int value) {

		Node node = hashtable.get(key);
		if(null==node){
			// 则需要添加一个对象
			Node node1 = new Node();
			node1.key = key;
			node1.value =value;
			moveToHead(node1);
			this.size++;
			hashtable.put(key,node1);
		}else{
			// 更新值
			node.value = value;
			moveToHead(node);
		}

		if(this.size > this.capacity){
			// 移除最末端的值
			Node last = this.tail.prev;
			removeNode(last);
			hashtable.remove(last.key);
			this.size--;
		}

	}

	class Node{
		private Integer key;
		private Integer value;
		private Node prev;
		private Node next;
		public Node(){}
	}

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */