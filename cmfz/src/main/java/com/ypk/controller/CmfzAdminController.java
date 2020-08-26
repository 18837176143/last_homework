package com.ypk.controller;


import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.ICaptcha;
import com.ypk.app.R;
import com.ypk.entity.CmfzAdmin;
import com.ypk.service.CmfzAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotEmpty;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yangy
 * @since 2020-08-18
 */
@Validated
@RestController
@RequestMapping("/cmfz_admin")
public class CmfzAdminController {
  @Autowired
    private CmfzAdminService cmfzAdminService;

  @RequestMapping("login")
  public Map<String,Object>login(String username, String password, String ucode,HttpServletRequest request){
      Map<String, Object> map=new HashMap<>();
      String code = (String) request.getSession().getAttribute("code");
      System.out.println(ucode);
      System.out.println(code);
      if (code.equals(ucode)){
          CmfzAdmin admin = cmfzAdminService.selectAdmin(username, password);
          if (admin !=null){
              map.put("status",true);
              request.getSession().setAttribute("admin",admin);
          }else {
              map.put("status",false);
              map.put("msg","账号或密码错误");
          }
      }else {
          map.put("status",false);
          map.put("msg","验证码错误");
      }
      return  map;
  }

  @RequestMapping("createCode")
  public void  createCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
      ICaptcha captcha= CaptchaUtil.createCircleCaptcha(100, 50, 4, 10);
      ServletOutputStream outputStream = response.getOutputStream();
      captcha.write(outputStream);
      request.getSession().setAttribute("code",captcha.getCode());
      outputStream.close();
  }


  @GetMapping("addAdmin")
  public R addAdmin(@Validated CmfzAdmin cmfzAdmin){
      return R.ok();
  }
}
