package com.anchtun.helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.anchtun.model.FinalResultEntity;

import lombok.NonNull;

public class FinalResultHelper {

	public static List<Map<Integer, String>> fillFinalResulMap(@NonNull List<FinalResultEntity> listFinalResult) {
		List<Map<Integer, String>> result = new ArrayList<Map<Integer, String>>();
		for (FinalResultEntity student : listFinalResult) {
			Map<Integer, String> map = new HashMap<>();
			int index = 0;
			map.put(index++, student.getId());
			map.put(index++, student.getExam());
			map.put(index++, student.getStudentFullName());
			map.put(index, student.getNote().toString());
			result.add(map);
		}
		return result;
	}
}
