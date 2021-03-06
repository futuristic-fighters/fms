package cn.com.leadu.fms.baseinfo.validator.basfilegroup.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasFileGroup;
import lombok.Data;
import java.util.Date;

/**
 * @author ningyangyang
 * @ClassName: BasFileGroupVo
 * @Description: 附件组保存时载体及验证
 */
@Data
public class BasFileGroupSaveVo extends BaseVo<BasFileGroup> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 附件组id
	 * @author ningyangyang
	 */
	private String basFileGroupId;

	/**
	 * @Fields  : 附件类型上级
	 * @author ningyangyang
	 */
	private String fileTypePar;

	/**
	 * @Fields  : 附件类型下级
	 * @author ningyangyang
	 */
	private String fileTypeChi;

}