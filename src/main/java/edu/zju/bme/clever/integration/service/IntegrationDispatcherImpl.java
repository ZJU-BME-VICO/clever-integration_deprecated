package edu.zju.bme.clever.integration.service;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.zju.bme.clever.integration.entity.IntegrationQueue;
import edu.zju.bme.clever.integration.entity.mapper.mias.MiasDiagnosisRowMapper;
import edu.zju.bme.clever.integration.entity.mapper.mias.MiasExamActionRowMapper;
import edu.zju.bme.clever.integration.entity.mapper.mias.MiasExamDataRowMapper;
import edu.zju.bme.clever.integration.entity.mapper.mias.MiasExamItemRowMapper;
import edu.zju.bme.clever.integration.entity.mapper.mias.MiasExamMasterRowMapper;
import edu.zju.bme.clever.integration.entity.mapper.mias.MiasExamReportRowMapper;
import edu.zju.bme.clever.integration.entity.mapper.mias.MiasExamRequestRowMapper;
import edu.zju.bme.clever.integration.entity.mapper.mias.MiasLabTestActionRowMapper;
import edu.zju.bme.clever.integration.entity.mapper.mias.MiasLabTestDataRowMapper;
import edu.zju.bme.clever.integration.entity.mapper.mias.MiasLabTestMasterRowMapper;
import edu.zju.bme.clever.integration.entity.mapper.mias.MiasLabTestRequestRowMapper;
import edu.zju.bme.clever.integration.entity.mapper.mias.MiasOrderRowMapper;
import edu.zju.bme.clever.integration.entity.mapper.mias.MiasPatientRowMapper;
import edu.zju.bme.clever.integration.entity.mapper.mias.MiasVisitRowMapper;
import edu.zju.bme.clever.integration.entity.mapper.mias.MiasVitalSignRowMapper;


@Service("integrationDispatcher")
@Transactional
public class IntegrationDispatcherImpl implements IntegrationDispatcher {

	private static Logger logger = Logger.getLogger(IntegrationDispatcherImpl.class.getName());

    @Resource(name="integrationService")
    private IntegrationService integrationService;
    @Resource(name="patientService")
    private PatientService patientService;
    @Resource(name="visitService")
    private VisitService visitService;
    @Resource(name="orderService")
    private OrderService orderService;
    @Resource(name="labTestRequestService")
    private LabTestRequestService labTestRequestService;
    @Resource(name="labTestMasterService")
    private LabTestMasterService labTestMasterService;
    @Resource(name="labTestDataService")
    private LabTestDataService labTestDataService;
    @Resource(name="labTestActionService")
    private LabTestActionService labTestActionService;
    @Resource(name="examRequestService")
    private ExamRequestService examRequestService;
    @Resource(name="examMasterService")
    private ExamMasterService examMasterService;
    @Resource(name="examItemService")
    private ExamItemService examItemService;
    @Resource(name="examDataService")
    private ExamDataService examDataService;
    @Resource(name="examReportService")
    private ExamReportService examReportService;
    @Resource(name="examActionService")
    private ExamActionService examActionService;
    @Resource(name="vitalSignService")
    private VitalSignService vitalSignService;
    @Resource(name="diagnosisService")
    private DiagnosisService diagnosisService;

	@Override
	public void dispatch() {
		List<IntegrationQueue> iq = this.integrationService.getTop(1);
		iq.stream().map(i -> Optional.of(i)).forEach(this::dispatchIntegrationQueue);
	}
	
	private void dispatchIntegrationQueue(Optional<IntegrationQueue> iq) {
		try {
			iq.get().setStatus(false);
			if (iq.get().getTableName().compareTo(MiasPatientRowMapper.MASTER_PATIENT_INDEX.class.getSimpleName()) == 0) {
				if (this.patientService.integrate(iq.get().getLogicalKeyValue())) {
					iq.get().setStatus(true);
				}
			} else if (iq.get().getTableName().compareTo(MiasVisitRowMapper.PATIENT_VISIT.class.getSimpleName()) == 0) {
				if (this.visitService.integrate(iq.get().getLogicalKeyValue())) {
					iq.get().setStatus(true);
				}			
			} else if (iq.get().getTableName().compareTo(MiasOrderRowMapper.ORDERS.class.getSimpleName()) == 0) {
				if (this.orderService.integrate(Integer.parseInt(iq.get().getLogicalKeyValue()))) {
					iq.get().setStatus(true);
				}
			} else if (iq.get().getTableName().compareTo(MiasLabTestRequestRowMapper.LAB_TEST_REQUEST.class.getSimpleName()) == 0) {
				if (this.labTestRequestService.integrate(iq.get().getLogicalKeyValue())) {
					iq.get().setStatus(true);
				}
			} else if (iq.get().getTableName().compareTo(MiasLabTestMasterRowMapper.LAB_TEST_MASTER.class.toString()) == 0) {
				if (this.labTestMasterService.integrate(iq.get().getLogicalKeyValue())) {
					iq.get().setStatus(true);
				}
			} else if (iq.get().getTableName().compareTo(MiasLabTestDataRowMapper.LAB_TEST_DATA.class.getSimpleName()) == 0) {
				if (this.labTestDataService.integrate(Integer.parseInt(iq.get().getLogicalKeyValue()))) {
					iq.get().setStatus(true);
				}
			} else if (iq.get().getTableName().compareTo(MiasLabTestActionRowMapper.LAB_TEST_ACTION.class.getSimpleName()) == 0) {
				if (this.labTestActionService.integrate(Integer.parseInt(iq.get().getLogicalKeyValue()))) {
					iq.get().setStatus(true);
				}
			} else if (iq.get().getTableName().compareTo(MiasExamRequestRowMapper.EXAM_REQUEST.class.getSimpleName()) == 0) {
				if (this.examRequestService.integrate(iq.get().getLogicalKeyValue())) {
					iq.get().setStatus(true);
				}
			} else if (iq.get().getTableName().compareTo(MiasExamMasterRowMapper.EXAM_MASTER.class.getSimpleName()) == 0) {
//				if (this.examMasterService.integrate(Integer.parseInt(iq.get().getLogicalKeyValue()))) {
//					iq.get().setStatus(true);
//				}
				if (this.examMasterService.integrate(iq.get().getLogicalKeyValue())) {
					iq.get().setStatus(true);
				}
			} else if (iq.get().getTableName().compareTo(MiasExamItemRowMapper.EXAM_ITEM.class.getSimpleName()) == 0) {
				if (this.examItemService.integrate(Integer.parseInt(iq.get().getLogicalKeyValue()))) {
					iq.get().setStatus(true);
				}
			} else if (iq.get().getTableName().compareTo(MiasExamDataRowMapper.EXAM_DATA.class.getSimpleName()) == 0) {
				if (this.examDataService.integrate(Integer.parseInt(iq.get().getLogicalKeyValue()))) {
					iq.get().setStatus(true);
				}
			} else if (iq.get().getTableName().compareTo(MiasExamReportRowMapper.EXAM_REPORT.class.getSimpleName()) == 0) {
				if (this.examReportService.integrate(Integer.parseInt(iq.get().getLogicalKeyValue()))) {
					iq.get().setStatus(true);
				}
			} else if (iq.get().getTableName().compareTo(MiasExamActionRowMapper.EXAM_ACTION.class.getSimpleName()) == 0) {
				if (this.examActionService.integrate(Integer.parseInt(iq.get().getLogicalKeyValue()))) {
					iq.get().setStatus(true);
				}
			} else if (iq.get().getTableName().compareTo(MiasVitalSignRowMapper.VITAL_SIGNS_RECORD.class.getSimpleName()) == 0) {
				if (this.vitalSignService.integrate(Integer.parseInt(iq.get().getLogicalKeyValue()))) {
					iq.get().setStatus(true);
				}
			} else if (iq.get().getTableName().compareTo(MiasDiagnosisRowMapper.DIAGNOSIS.class.getSimpleName()) == 0) {
				if (this.diagnosisService.integrate(Integer.parseInt(iq.get().getLogicalKeyValue()))) {
					iq.get().setStatus(true);
				}
			}
		} catch (Exception e) {
			logger.error(e);
		}
		
		this.integrationService.save(iq.get());
	}

}
