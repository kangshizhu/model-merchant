package modules.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import modules.entity.CompanyRegisterInfo;
import modules.mapper.CompanyRegisterInfoMapper;
import modules.service.ICompanyRegisterInfoService;
import modules.vo.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author chenguitong
 * @since 2022-09-20
 */
@Service
public class CompanyRegisterInfoServiceImpl extends ServiceImpl<CompanyRegisterInfoMapper, CompanyRegisterInfo> implements ICompanyRegisterInfoService {

    @Resource
    CompanyRegisterInfoMapper companyRegisterInfoMapper;

    @Override
    public Object register(CompanyRegisterInfo companyRegisterInfo) {
        QueryWrapper<CompanyRegisterInfo> queryWrapper=new QueryWrapper<>();
        //验证商户是否已注册
        queryWrapper.eq("company_name",companyRegisterInfo.getCompanyName());
        CompanyRegisterInfo registerInfo = companyRegisterInfoMapper.selectOne(queryWrapper);
        if(registerInfo==null){
            companyRegisterInfoMapper.insert(companyRegisterInfo);
            return Result.OK("公司注册成功!");
        }else{
            return Result.error("公司名称已存在!");
        }

    }
}
