package com.ypk.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
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
public class CmfzAlbum implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "album_id", type = IdType.AUTO)
    private Integer albumId;

    private String albumName;

    private String albumAuthor;

    private String albumTeller;

    @TableField("album_Episodes")
    private Integer albumEpisodes;

    private LocalDateTime albumDate;

    private String albumContent;

    private String albumImage;

    private Integer albumStar;


}
