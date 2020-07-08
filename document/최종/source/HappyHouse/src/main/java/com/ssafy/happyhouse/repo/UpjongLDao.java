package com.ssafy.happyhouse.repo;

import java.sql.SQLException;
import java.util.List;
import com.ssafy.happyhouse.dto.UpjongL;

public interface UpjongLDao {
	public List<UpjongL> searchAll() throws SQLException;
	public List<UpjongL> searchAll(UpjongL u) throws SQLException;
}
