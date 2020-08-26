package com.ypk.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
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
public class CmfzBanner implements Serializable {

    @TableId(value = "banner_id", type = IdType.AUTO)
    private Integer bannerId;

    private String bannerImageUrl;

    /**
     * 原有名称
     */
    private String bannerOldName;

    private Integer bannerState;

    /**
     * 上传时间
     */
    private LocalDateTime bannerDate;

    private String bannerDescription;


}
