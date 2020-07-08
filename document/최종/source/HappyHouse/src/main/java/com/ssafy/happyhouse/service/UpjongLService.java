package com.ssafy.happyhouse.service;

import java.util.List;
import com.ssafy.happyhouse.dto.UpjongL;

public interface UpjongLService {
	public List<UpjongL> searchAll() throws Exception;
	public List<UpjongL> searchAll(UpjongL u) throws Exception;
}
