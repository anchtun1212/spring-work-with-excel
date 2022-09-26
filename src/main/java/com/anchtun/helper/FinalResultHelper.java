package com.anchtun.helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.anchtun.model.FinalResultEntity;

import lombok.NonNull;

public class FinalResultHelper {

	public static List<Map<Integer, String>> fillFinalResulMap(@NonNull List<FinalResultEntity> listFinalResult) {
		List<Map<Integer, String>> result = new ArrayList<Map<Integer,String>>();
		for (int i = 0; i < listFinalResult.size(); i++) {
			Map<Integer, String> map = new HashMap<>();
			int index = i;
			map.put(index++, listFinalResult.get(i).getId());
			map.put(index++, listFinalResult.get(i).getExam());
			map.put(index++, listFinalResult.get(i).getStudentFullName());
			map.put(index, listFinalResult.get(i).getNote().toString());
			result.add(map);
		}
		return result;
	}
}
