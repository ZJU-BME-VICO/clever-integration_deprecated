package edu.zju.bme.clever.integration.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.zju.bme.clever.integration.dao.cdr.CdrExamReportDao;
import edu.zju.bme.clever.integration.dao.mias.MiasExamReportDao;
import edu.zju.bme.clever.integration.entity.ExamMaster;
import edu.zju.bme.clever.integration.entity.ExamReport;
import edu.zju.bme.clever.integration.util.CdrCache;

@Service("examReportService")
@Transactional
public class ExamReportServiceImpl implements ExamReportService {

    @Resource(name="miasExamReportDao")
    private MiasExamReportDao miasExamReportDao;
    @Resource(name="cdrExamReportDao")    
    private CdrExamReportDao cdrExamReportDao;
    @Resource(name="examMasterService")
    private ExamMasterService examMasterService;

	@Override
	public Boolean integrate(int reportNo) {
		List<ExamReport> examDatas = this.miasExamReportDao.get(reportNo);
		Boolean success = false;
		if (examDatas.size() == 1) {
			ExamReport e = examDatas.get(0);
			
			ExamMaster examMaster = this.examMasterService.cachedOrIntegrate(e.getExamId());
			if (examMaster != null) {
				e.setIdExamMaster(examMaster.get_hibernarmId());
			}

			if (this.cdrExamReportDao.save(e) == 1) {
				success = true;
			}			
		}
		
		return success;
	}

	@Override
	public ExamReport cachedOrIntegrate(int key) {
		ExamReport cachedKey = new ExamReport();
		cachedKey.setReportNo(key);
		ExamReport cachedObject = (ExamReport) CdrCache.INSTANCE.get(ExamReport.class, cachedKey.hashCode());
		if (cachedObject != null) {
			return cachedObject;
		} else {
			List<ExamReport> cdrObjects = this.cdrExamReportDao.get(key);
			if (!cdrObjects.isEmpty()) {
				return cdrObjects.get(0);
			} else {
				if (this.integrate(key)) {
					cdrObjects = this.cdrExamReportDao.get(key);
					if (!cdrObjects.isEmpty()) {
						return cdrObjects.get(0);
					}
				}
			}					
		}
		return null;
	}

}
