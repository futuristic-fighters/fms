package cn.com.leadu.fms.system.validator.sysuserinfo.vo;

import cn.com.leadu.fms.common.constant.ValidatorConstants;
import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.system.entity.SysUserInfo;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import java.util.Date;

/**
 * @author qiaomengnan
 * @ClassName: SysUserInfoVo
 * @Description: 消息用户操作管理修改时载体及验证
 * @date 2018-04-25
 */
@Data
public class SysUserInfoModifyVo extends BaseVo<SysUserInfo> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 消息用户操作id
	 * @author qiaomengnan
	 */
	@NotBlank(message = ValidatorConstants.ID_NOT_NULL)
	private String userInfoId;

	/**
	 * @Fields  : 消息id
	 * @author qiaomengnan
	 */
	private String infoId;

	/**
	 * @Fields  : 用户
	 * @author qiaomengnan
	 */
	private String user;

	/**
	 * @Fields  : 操作状态
	 * @author qiaomengnan
	 */
	private String readStatus;

	/**
	 * @Fields  : 已读时间
	 * @author qiaomengnan
	 */
	private Date readTime;

	/**
	 * @Fields  : 消息业务类型
	 * @author ningyangyang
	 */
	private String infoCodeType;

}