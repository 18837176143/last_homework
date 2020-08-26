package com.ypk.controller;


import com.ypk.entity.CmfzMenu;
import com.ypk.service.CmfzMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yangy
 * @since 2020-08-18
 */
@RestController
@RequestMapping("/cmfz_menu")
public class CmfzMenuController {

    @Autowired
    private CmfzMenuService cmfzMenuService;

    @RequestMapping("createMenu")
    public List<CmfzMenu> createMenu(){
        List<CmfzMenu> menus = cmfzMenuService.selectAllMenu();
        List<CmfzMenu> result=menus.stream()
                                .filter(cmfzMenu -> {
                                    return  cmfzMenu.getMenuParentId()==null;
                                })
                               .map(cmfzMenu -> {
                                 cmfzMenu.setMenus(createMenuList(cmfzMenu,menus));
                                 return cmfzMenu;
                               })
                              .collect(Collectors.toList());


        return  result;
    }

    @RequestMapping("exit")
    public void exit(HttpServletRequest request){
         request.getSession().invalidate();
    }

    private List<CmfzMenu> createMenuList(CmfzMenu cmfzMenu,List<CmfzMenu> list){
        List li=list.stream()
                 .filter(item->{
                    return   cmfzMenu.getMenuId().equals(item.getMenuParentId());
                 })
                .collect(Collectors.toList());

        return  li;
    }
}
