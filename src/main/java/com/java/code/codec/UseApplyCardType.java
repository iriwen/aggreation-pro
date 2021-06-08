package com.java.code.codec;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * created by iriwen on 2021/04/16.
 */

@NoArgsConstructor
@Data
@AllArgsConstructor
public class UseApplyCardType implements Serializable {

    private Long applyCardTypeId;
    private Long applyId;

    private Integer cardType;
    private Long canUseTime;
    private Long amoutOrTimes;
    private Integer applyNum;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date bindingEndTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date useEndTime;
    private String cardRange;
    private Long prePrice;

}
