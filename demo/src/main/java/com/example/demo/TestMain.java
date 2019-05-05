package com.example.demo;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class TestMain {

	public static void main(String[] args) throws NoSuchFieldException, SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		
		Map<String, String> map = new HashMap<String, String>(2);
		map.put("a", "a");
		map.put("d", "d");
		map.put("b", "b");
		map.put("c", "c");
		map.put("f", "f");
		map.put("e", "e");
		
		
		System.out.println(map);
		
		Field threshold = map.getClass().getDeclaredField("threshold");
		Field size = map.getClass().getDeclaredField("size");
		Method capacity = map.getClass().getDeclaredMethod("capacity");

		threshold.setAccessible(true);
		size.setAccessible(true);
		capacity.setAccessible(true);

		// 未存放对象时，各项值测试
		System.out.println("临界值：" + threshold.get(map));
		System.out.println("size：" + size.get(map));
		System.out.println("容量：" + capacity.invoke(map));
		
		
		
	}

}
