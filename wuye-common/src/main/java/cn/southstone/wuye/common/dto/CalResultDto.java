package cn.southstone.wuye.common.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by fengs on 2016/8/23.
 */
public class CalResultDto implements Serializable{


    private static final long serialVersionUID = -4007189460373140471L;
    private Long fkgxId;
    private Long sfbzId;
    private BigDecimal amount;

    public Long getFkgxId() {
        return fkgxId;
    }

    public void setFkgxId(Long fkgxId) {
        this.fkgxId = fkgxId;
    }

    public Long getSfbzId() {
        return sfbzId;
    }

    public void setSfbzId(Long sfbzId) {
        this.sfbzId = sfbzId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
