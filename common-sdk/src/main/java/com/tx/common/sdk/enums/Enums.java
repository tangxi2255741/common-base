package com.tx.common.sdk.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description：枚举转换，具体使用案例可参考StatusEnum
 * @Author：T.X
 * @CreateTime：2019/4/17-16:01
*/
public abstract class Enums {

	public static <T extends IntegerType> Map<Integer, T> toMap(T[] values) {

		if (values == null) {
			throw new IllegalArgumentException("入参不能为空!");
		}

		HashMap<Integer, T> typeMap = new HashMap<Integer, T>();
		for (T t : values) {
			if(typeMap.containsKey(t.getType())){
				throw new IllegalArgumentException("具有重复的key[" + t.getType() + "]值, 不能进行Map转换!");
			}
			typeMap.put(t.getType(), t);
		}

		return typeMap;//ImmutableMap.<Integer, T> copyOf(typeMap);
	}

	public static <T extends DescType> Map<String, T> toStrMap(T[] values) {
		if (values == null) {
			throw new IllegalArgumentException("入参不能为空!");
		}
		HashMap<String, T> typeMap = new HashMap<String, T>();
		for (T t : values) {
			if(typeMap.containsKey(t.getDesc())){
				throw new IllegalArgumentException("具有重复的key[" + t.getDesc() + "]值, 不能进行Map转换!");
			}
			typeMap.put(t.getDesc(), t);
		}

		return typeMap;//ImmutableMap.<String, T> copyOf(typeMap);
	}



	public static <T extends StringType> Map<String, T> toMap(T[] values) {

		if (values == null) {
			throw new IllegalArgumentException("入参不能为空!");
		}

		HashMap<String, T> typeMap = new HashMap<String, T>();
		for (T t : values) {
			if(typeMap.containsKey(t.getType())){
				throw new IllegalArgumentException("具有重复的key[" + t.getType() + "]值, 不能进行Map转换!");
			}
			typeMap.put(t.getType(), t);
		}

		return typeMap;//ImmutableMap.<String, T> copyOf(typeMap);
	}
}
