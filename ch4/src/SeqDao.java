import framework.db.DB;
import framework.db.JdbcDaoSupport;
import framework.db.RecordSet;

public class SeqDao extends JdbcDaoSupport {

	/*
	
	select
	'public Long getSeq' || tbl.s1 || '() {RecordSet rs = select("select ' || lower(tbl.s2) || '.nextval from dual"); rs.nextRow(); return rs.getLong(0);}' 
	from (
	select
	    replace(initcap(replace(replace(sequence_name,'SEQ_T_','')
	    ,'SEQ_', '')),'_','') s1, sequence_name s2
	from user_sequences
	order by sequence_name
	) tbl;
	
	 */
	public SeqDao(DB db) {
		super(db);
	}

	public Long getSeqTblSubmitQueue() {
		RecordSet rs = select("select seq_tbl_submit_queue.nextval from dual");
		rs.nextRow();
		return rs.getLong(0);
	}

	public Long getSeqAuditlog() {
		RecordSet rs = select("select seq_t_auditlog.nextval from dual");
		rs.nextRow();
		return rs.getLong(0);
	}

	public Long getSeqBenefit() {
		RecordSet rs = select("select seq_t_benefit.nextval from dual");
		rs.nextRow();
		return rs.getLong(0);
	}

	public Long getSeqBrd() {
		RecordSet rs = select("select seq_t_brd.nextval from dual");
		rs.nextRow();
		return rs.getLong(0);
	}

	public Long getSeqBrdcts() {
		RecordSet rs = select("select seq_t_brdcts.nextval from dual");
		rs.nextRow();
		return rs.getLong(0);
	}

	public Long getSeqBrdctscomment() {
		RecordSet rs = select("select seq_t_brdctscomment.nextval from dual");
		rs.nextRow();
		return rs.getLong(0);
	}

	public Long getSeqBrdctslog() {
		RecordSet rs = select("select seq_t_brdctslog.nextval from dual");
		rs.nextRow();
		return rs.getLong(0);
	}

	public Long getSeqCheckup() {
		RecordSet rs = select("select seq_t_checkup.nextval from dual");
		rs.nextRow();
		return rs.getLong(0);
	}

	public Long getSeqCheckupcandidate() {
		RecordSet rs = select("select seq_t_checkupcandidate.nextval from dual");
		rs.nextRow();
		return rs.getLong(0);
	}

	public Long getSeqCounsel() {
		RecordSet rs = select("select seq_t_counsel.nextval from dual");
		rs.nextRow();
		return rs.getLong(0);
	}

	public Long getSeqErrorlog() {
		RecordSet rs = select("select seq_t_errorlog.nextval from dual");
		rs.nextRow();
		return rs.getLong(0);
	}

	public Long getSeqFiledownlog() {
		RecordSet rs = select("select seq_t_filedownlog.nextval from dual");
		rs.nextRow();
		return rs.getLong(0);
	}

	public Long getSeqFileitem() {
		RecordSet rs = select("select seq_t_fileitem.nextval from dual");
		rs.nextRow();
		return rs.getLong(0);
	}

	public Long getSeqFuneral() {
		RecordSet rs = select("select seq_t_funeral.nextval from dual");
		rs.nextRow();
		return rs.getLong(0);
	}

	public Long getSeqFuneralexpense() {
		RecordSet rs = select("select seq_t_funeralexpense.nextval from dual");
		rs.nextRow();
		return rs.getLong(0);
	}

	public Long getSeqFuneralextarget() {
		RecordSet rs = select("select seq_t_funeralextarget.nextval from dual");
		rs.nextRow();
		return rs.getLong(0);
	}

	public Long getSeqInvite() {
		RecordSet rs = select("select seq_t_invite.nextval from dual");
		rs.nextRow();
		return rs.getLong(0);
	}

	public Long getSeqInviteApply() {
		RecordSet rs = select("select seq_t_invite_apply.nextval from dual");
		rs.nextRow();
		return rs.getLong(0);
	}

	public Long getSeqJptherapy() {
		RecordSet rs = select("select seq_t_jptherapy.nextval from dual");
		rs.nextRow();
		return rs.getLong(0);
	}

	public Long getSeqLoginlog() {
		RecordSet rs = select("select seq_t_loginlog.nextval from dual");
		rs.nextRow();
		return rs.getLong(0);
	}

	public Long getSeqMedicalover() {
		RecordSet rs = select("select seq_t_medicalover.nextval from dual");
		rs.nextRow();
		return rs.getLong(0);
	}

	public Long getSeqMedicaloverApply() {
		RecordSet rs = select("select seq_t_medicalover_apply.nextval from dual");
		rs.nextRow();
		return rs.getLong(0);
	}

	public Long getSeqMedicalreceipt() {
		RecordSet rs = select("select seq_t_medicalreceipt.nextval from dual");
		rs.nextRow();
		return rs.getLong(0);
	}

	public Long getSeqMedicalsub() {
		RecordSet rs = select("select seq_t_medicalsub.nextval from dual");
		rs.nextRow();
		return rs.getLong(0);
	}

	public Long getSeqMemberchangehis() {
		RecordSet rs = select("select seq_t_memberchangehis.nextval from dual");
		rs.nextRow();
		return rs.getLong(0);
	}

	public Long getSeqMemberchangehisGroup() {
		RecordSet rs = select("select seq_t_memberchangehis_group.nextval from dual");
		rs.nextRow();
		return rs.getLong(0);
	}

	public Long getSeqMembercontact() {
		RecordSet rs = select("select seq_t_membercontact.nextval from dual");
		rs.nextRow();
		return rs.getLong(0);
	}

	public Long getSeqMenulog() {
		RecordSet rs = select("select seq_t_menulog.nextval from dual");
		rs.nextRow();
		return rs.getLong(0);
	}

	public Long getSeqMinus() {
		RecordSet rs = select("select seq_t_minus.nextval from dual");
		rs.nextRow();
		return rs.getLong(0);
	}

	public Long getSeqPrivacylog() {
		RecordSet rs = select("select seq_t_privacylog.nextval from dual");
		rs.nextRow();
		return rs.getLong(0);
	}

	public Long getSeqQna() {
		RecordSet rs = select("select seq_t_qna.nextval from dual");
		rs.nextRow();
		return rs.getLong(0);
	}

	public Long getSeqReversevisit() {
		RecordSet rs = select("select seq_t_reversevisit.nextval from dual");
		rs.nextRow();
		return rs.getLong(0);
	}

	public Long getSeqReversevisitApply() {
		RecordSet rs = select("select seq_t_reversevisit_apply.nextval from dual");
		rs.nextRow();
		return rs.getLong(0);
	}

	public Long getSeqSchedule01() {
		RecordSet rs = select("select seq_t_schedule01.nextval from dual");
		rs.nextRow();
		return rs.getLong(0);
	}

	public Long getSeqSchedule02() {
		RecordSet rs = select("select seq_t_schedule02.nextval from dual");
		rs.nextRow();
		return rs.getLong(0);
	}

	public Long getSeqSchedule03() {
		RecordSet rs = select("select seq_t_schedule03.nextval from dual");
		rs.nextRow();
		return rs.getLong(0);
	}

	public Long getSeqSettler() {
		RecordSet rs = select("select seq_t_settler.nextval from dual");
		rs.nextRow();
		return rs.getLong(0);
	}

	public Long getSeqSettlerchangehis() {
		RecordSet rs = select("select seq_t_settlerchangehis.nextval from dual");
		rs.nextRow();
		return rs.getLong(0);
	}

	public Long getSeqSettlerchangehisGroup() {
		RecordSet rs = select("select seq_t_settlerchangehis_group.nextval from dual");
		rs.nextRow();
		return rs.getLong(0);
	}

	public Long getSeqSettlerfamily() {
		RecordSet rs = select("select seq_t_settlerfamily.nextval from dual");
		rs.nextRow();
		return rs.getLong(0);
	}

	public Long getSeqSettlerqna() {
		RecordSet rs = select("select seq_t_settlerqna.nextval from dual");
		rs.nextRow();
		return rs.getLong(0);
	}

	public Long getSeqSmssendgroup() {
		RecordSet rs = select("select seq_t_smssendgroup.nextval from dual");
		rs.nextRow();
		return rs.getLong(0);
	}

	public Long getSeqSmssendtarget() {
		RecordSet rs = select("select seq_t_smssendtarget.nextval from dual");
		rs.nextRow();
		return rs.getLong(0);
	}

	public Long getSeqSmstemplate() {
		RecordSet rs = select("select seq_t_smstemplate.nextval from dual");
		rs.nextRow();
		return rs.getLong(0);
	}

	public Long getSeqVisit() {
		RecordSet rs = select("select seq_t_visit.nextval from dual");
		rs.nextRow();
		return rs.getLong(0);
	}

	public Long getSeqVisitor() {
		RecordSet rs = select("select seq_t_visitor.nextval from dual");
		rs.nextRow();
		return rs.getLong(0);
	}

}
