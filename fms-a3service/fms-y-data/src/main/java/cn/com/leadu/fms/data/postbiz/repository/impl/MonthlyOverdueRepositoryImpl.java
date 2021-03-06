package cn.com.leadu.fms.data.postbiz.repository.impl;

import cn.com.leadu.fms.data.postbiz.dao.MonthlyOverdueDao;
import cn.com.leadu.fms.data.postbiz.repository.MonthlyOverdueRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.postbiz.entity.MonthlyOverdue;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author wangxue
 * @ClassName: MonthlyOverdueRepositoryImpl
 * @Description: 逾期率统计Repository 实现层
 */
@Repository
public class MonthlyOverdueRepositoryImpl extends AbstractBaseRepository<MonthlyOverdueDao, MonthlyOverdue> implements MonthlyOverdueRepository {

    /**
     * @Title:
     * @Description: 新增逾期率统计
     * @param monthlyOverdue
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-9-25 17:12:17
     */
    @Override
    public int insertData(MonthlyOverdue monthlyOverdue) {
        return super.insert(monthlyOverdue);
    }

    /**
     * @Title:
     * @Description: 批量保存逾期率统计
     * @param monthlyOverdues
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-9-25 17:12:17
     */
    @Override
    public int insertDataList(List<MonthlyOverdue> monthlyOverdues){
        return super.insertListByJdbcTemplate(monthlyOverdues);
    }

    /**
     * @Title:
     * @Description: 修改逾期率统计
     * @param monthlyOverdue
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-9-25 17:12:17
     */
    @Override
    public int updateByPrimaryKeyData(MonthlyOverdue monthlyOverdue) {
        return super.updateByPrimaryKey(monthlyOverdue);
    }

    /**
     * @Title:
     * @Description: 批量修改逾期率统计
     * @param monthlyOverdues
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-9-25 17:12:17
     */
    @Override
    public int updateByPrimaryKeyDataList(List<MonthlyOverdue> monthlyOverdues){
        return super.updateListByPrimaryKey(monthlyOverdues);
    }

    /**
     * @Title:
     * @Description: 动态修改逾期率统计
     * @param monthlyOverdue
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-9-25 17:12:17
     */
    @Override
    public int updateByPrimaryKeySelectiveData(MonthlyOverdue monthlyOverdue) {
        return super.updateByPrimaryKeySelective(monthlyOverdue);
    }

    /**
     * @Title:
     * @Description: 批量动态修改逾期率统计
     * @param monthlyOverdues
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-9-25 17:12:17
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<MonthlyOverdue> monthlyOverdues) {
        return super.updateListByPrimaryKeySelective(monthlyOverdues);
    }

    /**
     * @Title:
     * @Description: 根据条件修改逾期率统计
     * @param monthlyOverdue
     * @param example
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-9-25 17:12:17
     */
    @Override
    public int updateByExampleData(MonthlyOverdue monthlyOverdue, Example example) {
        return super.updateByExample(monthlyOverdue,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改逾期率统计
     * @param monthlyOverdue
     * @param example
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-9-25 17:12:17
     */
    @Override
    public int updateByExampleSelectiveData(MonthlyOverdue monthlyOverdue, Example example){
        return super.updateByExampleSelective(monthlyOverdue,example);
    }
    
    /**
     * @Title:
     * @Description: 根据monthlyOverdueId删除逾期率统计
     * @param monthlyOverdue
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-9-25 17:12:17
     */
    @Override
    public int deleteData(MonthlyOverdue monthlyOverdue) {
        return super.delete(monthlyOverdue);
    }

    /**
     * @Title:
     * @Description: 根据monthlyOverdueId集合批量删除逾期率统计
     * @param monthlyOverdue
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-9-25 17:12:17
     */
    @Override
    public int deleteDataList(List monthlyOverdueIds,MonthlyOverdue monthlyOverdue){
        return super.deleteByIds(monthlyOverdueIds,monthlyOverdue);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除逾期率统计
     * @param example
     * @param monthlyOverdue
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-9-25 17:12:17
     */
    @Override
    public int deleteExampleData(Example example,MonthlyOverdue monthlyOverdue){
        return super.deleteByExample(example,monthlyOverdue);
    }

    /**
     * @Title:
     * @Description: 查询全部逾期率统计
     * @return List<MonthlyOverdue>
     * @throws
     * @author wangxue
     * @date 2018-9-25 17:12:17
     */
    @Override
    public List<MonthlyOverdue> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个逾期率统计
     * @param example
     * @return MonthlyOverdue
     * @throws
     * @author wangxue
     * @date 2018-9-25 17:12:17
     */
    @Override
    public MonthlyOverdue selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询逾期率统计
     * @param example
     * @return List<MonthlyOverdue>
     * @throws
     * @author wangxue
     * @date 2018-9-25 17:12:17
     */
    @Override
    public List<MonthlyOverdue> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过monthlyOverdueId查询逾期率统计
     * @param monthlyOverdueId
     * @return MonthlyOverdue
     * @throws
     * @author wangxue
     * @date 2018-9-25 17:12:17
     */
    @Override
    public MonthlyOverdue selectByPrimaryKey(Object monthlyOverdueId) {
        return super.selectByPrimaryKey(monthlyOverdueId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询逾期率统计
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<MonthlyOverdue>
     * @throws
     * @author wangxue
     * @date 2018-9-25 17:12:17
     */
    @Override
    public PageInfoExtend<MonthlyOverdue> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询逾期率统计vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author wangxue
     * @date 2018-9-25 17:12:17
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 修改逾期率统计
     * @param monthlyOverdue,并进行排他
     * @param exclusive
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-9-25 17:12:17
     */
    @Override
    public int updateByPrimaryKeyData(MonthlyOverdue monthlyOverdue,boolean exclusive) {
        return super.updateByPrimaryKey(monthlyOverdue,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量修改逾期率统计,并进行排他
     * @param monthlyOverdues
     * @param exclusive
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-9-25 17:12:17
     */
    @Override
    public int updateByPrimaryKeyDataList(List<MonthlyOverdue> monthlyOverdues,boolean exclusive){
        return super.updateListByPrimaryKey(monthlyOverdues,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据主键动态修改逾期率统计,并进行排他
     * @param monthlyOverdue
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int updateByPrimaryKeySelectiveData(MonthlyOverdue monthlyOverdue,boolean exclusive) {
        return super.updateByPrimaryKeySelective(monthlyOverdue,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量动态修改逾期率统计,并进行排他
     * @param monthlyOverdues
     * @param exclusive
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-9-25 17:12:17
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<MonthlyOverdue> monthlyOverdues,boolean exclusive) {
        return super.updateListByPrimaryKeySelective(monthlyOverdues,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件修改逾期率统计,并进行排他
     * @param monthlyOverdue
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-9-25 17:12:17
     */
    @Override
    public int updateByExampleData(MonthlyOverdue monthlyOverdue, Example example,boolean exclusive) {
        return super.updateByExample(monthlyOverdue,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件动态修改逾期率统计,并进行排他
     * @param monthlyOverdue
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-9-25 17:12:17
     */
    @Override
    public int updateByExampleSelectiveData(MonthlyOverdue monthlyOverdue, Example example,boolean exclusive){
        return super.updateByExampleSelective(monthlyOverdue,example,exclusive);
    }

}
