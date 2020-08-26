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
public class CmfzCounter implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "counter_id", type = IdType.AUTO)
    private Integer counterId;

    private String counterName;

    private LocalDateTime counterDate;

    private String lessonId;

    private Integer userId;

    private Integer counterCount;

    private Integer counterStatus;


}
