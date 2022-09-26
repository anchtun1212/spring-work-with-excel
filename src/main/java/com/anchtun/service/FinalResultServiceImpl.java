package com.anchtun.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.anchtun.constant.Constants;
import com.anchtun.helper.FinalResultHelper;
import com.anchtun.model.FinalResultEntity;
import com.anchtun.repository.FinalResultRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Service
public class FinalResultServiceImpl implements FinalResultService {

	private final FinalResultRepository finalResultRepository;

	@Override
	public void generateAllExcel(HttpServletResponse response) {
		log.info("Start genarate All Final Results Excel");
		try {
			List<FinalResultEntity> listFinalResult = finalResultRepository.findAll();
			ExcelService generator = new ExcelService();
			List<Map<Integer, String>> fullData = FinalResultHelper.fillFinalResulMap(listFinalResult);
			generator.generate(response, Constants.FINAL_RESULT_ALL_NAME, fullData, Constants.FINAL_RESULT_HEADERS);
		} catch (IOException e) {
			log.error("Error Occured when generating EXCEL!!!");
		}

		log.info("End genarate All Final Results Excel");
	}

}
