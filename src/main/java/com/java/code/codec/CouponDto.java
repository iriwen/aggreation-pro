package com.java.code.codec;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * created by iriwen on 2021/04/16.
 */
@NoArgsConstructor
@Data
@AllArgsConstructor
public class CouponDto implements Serializable {

    private Long applyId;

    private String orderSource;

    private Long cpId;

    private String cpName;

    private Long applyUserId;

    private String applyUserName;

    private String deptName;

    private String bizNumber;

    private Long batchNumber;

    private Integer sceneType;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date activeTime;

    private Integer applyCardForm;

    private List<UseApplyCardType> useApplyCardTypeList;

}
