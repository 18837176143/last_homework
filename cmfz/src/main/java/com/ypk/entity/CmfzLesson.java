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
public class CmfzLesson implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "lesson_id", type = IdType.AUTO)
    private Integer lessonId;

    private String lessonName;

    private Integer userId;

    private Integer lessonStatus;


}
