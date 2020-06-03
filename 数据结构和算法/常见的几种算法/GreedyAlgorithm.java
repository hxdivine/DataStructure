package com.Algorithen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * 贪心算法处理集合覆盖
 * 电台地区覆盖
 * @author 骄傲的大树
 *
 */
public class GreedyAlgorithm {

	public static void main(String[] args) {
		//创建广播电台，放入Map中
		HashMap<String, HashSet<String>> broadcasts = new HashMap<String,HashSet<String>>();
		//将电台放入broadcasts
		HashSet<String> hashSet1 = new HashSet<String>();
		hashSet1.add("北京");
		hashSet1.add("上海");
		hashSet1.add("天津");
		
		HashSet<String> hashSet2 = new HashSet<String>();
		hashSet2.add("广州");
		hashSet2.add("北京");
		hashSet2.add("深圳");
		
		HashSet<String> hashSet3 = new HashSet<String>();
		hashSet3.add("成都");
		hashSet3.add("上海");
		hashSet3.add("杭州");
		
		HashSet<String> hashSet4 = new HashSet<String>();
		hashSet4.add("上海");
		hashSet4.add("天津");
		
		HashSet<String> hashSet5 = new HashSet<String>();
		hashSet5.add("杭州");
		hashSet5.add("大连");
		
		broadcasts.put("K1", hashSet1);
		broadcasts.put("K2", hashSet2);
		broadcasts.put("K3", hashSet3);
		broadcasts.put("K4", hashSet4);
		broadcasts.put("K5", hashSet5);
		//存放所有地区
		HashSet<String> allAreas = new HashSet<String>();
		allAreas.addAll(hashSet1);
		allAreas.addAll(hashSet2);
		allAreas.addAll(hashSet3);
		allAreas.addAll(hashSet4);
		allAreas.addAll(hashSet5);
		System.out.println(allAreas.toString());
		//存放选择的电台
		ArrayList<String> selects = new ArrayList<String>();
		//存放临时获取电台信息集合
		HashSet<String> tempSet = new HashSet<String>();
		String maxKey = null;
		while(allAreas.size() != 0){//allAreas.size() != 0表示没有覆盖到所有地区
			for(String key : broadcasts.keySet()){
				tempSet.clear();
				HashSet<String> areas = broadcasts.get(key);
				tempSet.addAll(areas);
				//求出tempSet和allAreas的交集
				tempSet.retainAll(allAreas);
				//体现贪心算法的特点，每次选择最优
				if(tempSet.size() > 0 && 
						(maxKey == null || tempSet.size() > broadcasts.get(maxKey).size())){
					maxKey = key;
				}
			}
			if(maxKey != null){
				selects.add(maxKey);
				//清除allAreas中maxKeyde地区
				allAreas.removeAll(broadcasts.get(maxKey));
				maxKey = null;
			}
		}
		
		System.out.println(selects.toString());
	}

}
