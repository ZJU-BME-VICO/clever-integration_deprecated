package edu.zju.bme.clever.integration.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.zju.bme.clever.integration.dao.IntegrationQueueDao;
import edu.zju.bme.clever.integration.entity.IntegrationQueue;

@Service("integrationService")
@Transactional
public class IntegrationServiceImpl implements IntegrationService {
	
    @Resource(name="integrationQueueDao")
    private IntegrationQueueDao integrationQueueDao;

	@Override
	public List<IntegrationQueue> getTop(int n) {
		return this.integrationQueueDao.getTop(n);
	}

}
