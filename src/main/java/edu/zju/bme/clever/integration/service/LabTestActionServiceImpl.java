package edu.zju.bme.clever.integration.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.zju.bme.clever.integration.dao.cdr.CdrLabTestActionDao;
import edu.zju.bme.clever.integration.dao.mias.MiasLabTestActionDao;
import edu.zju.bme.clever.integration.entity.LabTestAction;
import edu.zju.bme.clever.integration.entity.LabTestRequest;

@Service("labTestActionService")
@Transactional
public class LabTestActionServiceImpl implements LabTestActionService {

    @Resource(name="miasLabTestActionDao")
    private MiasLabTestActionDao miasLabTestActionDao;
    @Resource(name="cdrLabTestActionDao")    
    private CdrLabTestActionDao cdrLabTestActionDao;
    @Resource(name="labTestRequestService")
    private LabTestRequestService labTestRequestService;

	@Override
	public Boolean integrate(int serialNo) {
		List<LabTestAction> labTestDatas = this.miasLabTestActionDao.get(serialNo);
		Boolean success = false;
		if (labTestDatas.size() == 1) {
			LabTestAction l = labTestDatas.get(0);
			
			LabTestRequest labTestMaster = this.labTestRequestService.cachedOrIntegrate(l.getTestReqId());
			if (labTestMaster != null) {
				l.setIdLabTestRequest(labTestMaster.get_hibernarmId());
			}

			if (this.cdrLabTestActionDao.save(l) == 1) {
				success = true;
			}			
		}
		
		return success;
	}

}
