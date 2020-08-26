package com.ypk.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author yangy
 * @since 2020-08-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CmfzGuru implements Serializable {

    @Excel(name = "上师编号")
    @TableId(value = "guru_id", type = IdType.AUTO)
    private Integer guruId;
    @Excel(name = "上师名字")
    private String guruName;
    @Excel(name = "上师图片",imageType = 1,type = 2,width = 40,height = 20,
         savePath = "D:\\idea8-workspace\\last_homework\\cmfz\\src\\main\\webapp\\img")
    private String guruImage;
    @Excel(name = "上师法号")
    private String guruNickname;

    /**
     * 1冻结 冻结的同时需要下架相关的专辑和文章
     */
    @TableLogic(
            value = "0",
            delval ="1"
    )
    @Excel(name = "上师状态",replace = {"正常_0","冻结_0"})
    private Integer guruStatus;


}
