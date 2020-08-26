package com.ypk.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

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
public class CmfzAdmin implements Serializable {


    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @NotEmpty
    private String username;

    @NotEmpty
    @Size(min = 6,max = 10,message = "密码长度必须在6到9之间")
    private String password;


}
