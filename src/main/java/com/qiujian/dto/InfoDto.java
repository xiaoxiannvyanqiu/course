package com.qiujian.dto;

import java.util.Set;

public class InfoDto {
    private int ifId;
    private String ifName;

    public int getIfId() {
        return ifId;
    }

    public void setIfId(int ifId) {
        this.ifId = ifId;
    }

    public String getIfName() {
        return ifName;
    }

    public void setIfName(String ifName) {
        this.ifName = ifName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InfoDto infoDto = (InfoDto) o;

        if (ifId != infoDto.ifId) return false;
        if (ifName != null ? !ifName.equals(infoDto.ifName) : infoDto.ifName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ifId;
        result = 31 * result + (ifName != null ? ifName.hashCode() : 0);
        return result;
    }
}
