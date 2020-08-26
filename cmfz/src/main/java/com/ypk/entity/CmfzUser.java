package com.ypk.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

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
public class CmfzUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    private String userTelphone;

    private String userPassword;

    private String userImage;

    private String userNickname;

    private String userName;

    private String userSex;

    /**
     * 个性签名
     */
    private String userAutograph;

    private String userProvince;

    private String userCity;

    private Integer guruId;

    private Integer userStatus;


    private Date userCreateDate;

    /**
     * name值为省份名称
     */
    @TableField(exist = false)
    private String name;


}
