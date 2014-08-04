package edu.zju.bme.clever.integration.dao.cdr;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.zju.bme.clever.integration.entity.ExamData;
import edu.zju.bme.clever.integration.entity.mapper.cdr.CdrExamDataRowMapper;
import edu.zju.bme.clever.integration.util.CdrCache;
import edu.zju.bme.clever.integration.util.DatabaseUtil;

@Service("cdrExamDataDao")
@Transactional
public class CdrExamDataDaoImpl implements CdrExamDataDao {

    @Resource(name="jdbcTemplate")
    private NamedParameterJdbcTemplate jt;

	@Override
	public List<ExamData> get(int dataNo) {
		String sqlFormat = "SELECT TOP 1 * FROM {0} WHERE {1} = :dataNo";
		String sql = MessageFormat.format(sqlFormat, 
				DatabaseUtil.getCdrDatabaseTableName(CdrExamDataRowMapper.openEHR_EHR_OBSERVATION_exam_data.class.getSimpleName()),
				CdrExamDataRowMapper.openEHR_EHR_OBSERVATION_exam_data.data_no);		
		Map<String, Object> paramters = new HashMap<String, Object>();
		paramters.put("dataNo", dataNo);
		SqlParameterSource source = new MapSqlParameterSource(paramters);
		List<ExamData> examDatas = jt.query(sql, source, new CdrExamDataRowMapper());
		examDatas.forEach(l -> {
			ExamData k = new ExamData();
			k.setDataNo(dataNo);
			CdrCache.INSTANCE.put(ExamData.class, k.hashCode(), l);
		});
		return examDatas;
	}

	@Override
	public int getCount(int dataNo) {
		String sqlFormat = "SELECT COUNT(*) FROM {0} WHERE {1} = :dataNo";
		String sql = MessageFormat.format(sqlFormat, 				
				DatabaseUtil.getCdrDatabaseTableName(CdrExamDataRowMapper.openEHR_EHR_OBSERVATION_exam_data.class.getSimpleName()),
				CdrExamDataRowMapper.openEHR_EHR_OBSERVATION_exam_data.data_no);
		Map<String, Object> paramters = new HashMap<String, Object>();
		paramters.put("dataNo", dataNo);
		SqlParameterSource source = new MapSqlParameterSource(paramters);
		return jt.queryForObject(sql, source, Integer.class);
	}

	@Override
	public int save(ExamData e) {
		if (this.getCount(e.getDataNo()) <= 0) {
			String sqlFormat = "INSERT INTO {0} VALUES("
					+ ":exam_id, "
					+ ":data_no, "
					+ ":data_type, "
					+ ":series_no, "
					+ ":image_no, "
					+ ":image_flag, "
					+ ":first_media_name, "
					+ ":first_path, "
					+ ":second_media_name, "
					+ ":second_path, "
					+ ":_uid_value, "
					+ ":idExamMaster)";		
			String sql = MessageFormat.format(sqlFormat, 				
					DatabaseUtil.getCdrDatabaseTableName(CdrExamDataRowMapper.openEHR_EHR_OBSERVATION_exam_data.class.getSimpleName()));
			SqlParameterSource source = new MapSqlParameterSource(this.putParameters(e));
			return jt.update(sql, source);
		} else {
			String sqlFormat = "UPDATE {0} SET "
					+ "{1} = :exam_id, "
					+ "{2} = :data_type, "
					+ "{3} = :series_no, "
					+ "{4} = :image_no, "
					+ "{5} = :image_flag, "
					+ "{6} = :first_media_name, "
					+ "{7} = :first_path, "
					+ "{8} = :second_media_name, "
					+ "{9} = :second_path, "
					+ "{10} = :_uid_value, "
					+ "{11} = :idExamMaster WHERE {12} = :data_no";	
			String sql = MessageFormat.format(sqlFormat, 				
					DatabaseUtil.getCdrDatabaseTableName(CdrExamDataRowMapper.openEHR_EHR_OBSERVATION_exam_data.class.getSimpleName()),
					CdrExamDataRowMapper.openEHR_EHR_OBSERVATION_exam_data.exam_id.toString(),
					CdrExamDataRowMapper.openEHR_EHR_OBSERVATION_exam_data.data_no.toString(),
					CdrExamDataRowMapper.openEHR_EHR_OBSERVATION_exam_data.data_type.toString(),
					CdrExamDataRowMapper.openEHR_EHR_OBSERVATION_exam_data.series_no.toString(),
					CdrExamDataRowMapper.openEHR_EHR_OBSERVATION_exam_data.image_no.toString(),
					CdrExamDataRowMapper.openEHR_EHR_OBSERVATION_exam_data.image_flag.toString(),
					CdrExamDataRowMapper.openEHR_EHR_OBSERVATION_exam_data.first_media_name.toString(),
					CdrExamDataRowMapper.openEHR_EHR_OBSERVATION_exam_data.first_path.toString(),
					CdrExamDataRowMapper.openEHR_EHR_OBSERVATION_exam_data.second_media_name.toString(),
					CdrExamDataRowMapper.openEHR_EHR_OBSERVATION_exam_data.second_path.toString(),
					CdrExamDataRowMapper.openEHR_EHR_OBSERVATION_exam_data._uid_value.toString(),
					CdrExamDataRowMapper.openEHR_EHR_OBSERVATION_exam_data.idExamMaster.toString());
			SqlParameterSource source = new MapSqlParameterSource(this.putParameters(e));
			return jt.update(sql, source);			
		}
	}
	
	private Map<String, Object> putParameters(ExamData e) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("exam_id", e.getExamId());
		parameters.put("data_no", e.getDataNo());
		parameters.put("data_type", e.getDataType());
		parameters.put("series_no", e.getSeriesNo());
		parameters.put("image_no", e.getImageNo());
		parameters.put("image_flag", e.getImageFlag());
		parameters.put("first_media_name", e.getFirstMediaName());
		parameters.put("first_path", e.getFirstPath());
		parameters.put("second_media_name", e.getSecondMediaName());
		parameters.put("second_path", e.getSecondPath());
		parameters.put("_uid_value", e.get_uid_value());
		parameters.put("idExamMaster", e.getIdExamMaster());
		return parameters;
	}
	
}
