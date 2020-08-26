package com.ypk.entity;

import lombok.Data;

import java.util.Date;

@Data
public class CmfzLog {
  private Integer logId;
  private String username;
  private Date logDate;
  private String logIp;
  private String logType;
  private String logContent;
}
