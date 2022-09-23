package modules.service;

import com.baomidou.mybatisplus.extension.service.IService;
import modules.entity.CompanyRegisterInfo;

/**
 *
 * @author chenguitong
 * @since 2022-09-20
 */
public interface ICompanyRegisterInfoService extends IService<CompanyRegisterInfo> {

    Object register(CompanyRegisterInfo companyRegisterInfo);

}
