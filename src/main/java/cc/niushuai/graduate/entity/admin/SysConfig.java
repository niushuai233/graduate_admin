package cc.niushuai.graduate.entity.admin;


/**
 * 系统配置信息
 * 
 * @author niushuai
 * @email niushuai951101@gmail.com
 */
@SuppressWarnings("deprecation")
public class SysConfig {
	private Long id;
	private String code;
	private String value; 
	private String remark;
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
