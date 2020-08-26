package com.ypk.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
public class CmfzAudio implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "audio_id", type = IdType.AUTO)
    private Integer audioId;

    private String audioName;

    private Integer albumId;

    private String audioUrl;

    private String audioSize;

    private Integer audioOrder;


}
