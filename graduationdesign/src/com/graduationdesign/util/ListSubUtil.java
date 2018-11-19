package com.graduationdesign.util;

import java.util.ArrayList;
import java.util.List;

public class ListSubUtil {
	/**
	 * 将list按blockSize大小等分，最后多余的单独一份
	 * @param list
	 * @param blockSize
	 * @return
	 */
	public static <T> List<List<T>> subList(List<T> list, int blockSize) {
		List<List<T>> lists = new ArrayList<List<T>>();
		if (list != null && blockSize > 0) {
			int listSize = list.size();
			if (listSize <= blockSize) {
				lists.add(list);
				return lists;
			}
			int batchSize = listSize / blockSize;
			int remain = listSize % blockSize;
			for (int i = 0; i < batchSize; i++) {
				int fromIndex = i * blockSize;
				int toIndex = fromIndex + blockSize;
				System.out.println("fromIndex=" + fromIndex + ", toIndex=" + toIndex);
				//返回原来list的从[fromIndex, toIndex]之间这一部分的视图
				lists.add(list.subList(fromIndex, toIndex));
			}
			if (remain > 0) {
				System.out.println("fromIndex=" + (listSize - remain) + ", toIndex=" + (listSize));
				lists.add(list.subList(listSize - remain, listSize));
			}
		}
		return lists;
	}
}
