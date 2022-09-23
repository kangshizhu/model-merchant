package modules.controller;


import modules.dto.CompanyRegisterDto;
import modules.entity.CompanyRegisterInfo;
import modules.service.ICompanyRegisterInfoService;
import modules.vo.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 *
 * @author chenguitong
 * @since 2022-09-20
 */
@RestController
@RequestMapping("/company-register")
public class CompanyRegisterController {

    @Resource
    ICompanyRegisterInfoService iCompanyRegisterInfoService;

    @PostMapping(value = "/register")
    @ResponseBody
    public Result register(@RequestBody CompanyRegisterDto companyRegisterDto){
        CompanyRegisterInfo companyRegisterInfo=new CompanyRegisterInfo();
        BeanUtils.copyProperties(companyRegisterDto,companyRegisterInfo);
        return Result.OK(iCompanyRegisterInfoService.register(companyRegisterInfo));
    }


}
