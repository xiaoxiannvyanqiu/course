package com.qiujian.dto;

import java.util.Set;

public class PhoneDto {
    private int phId;
    private String phName;
    private Set<LeixingDto> leixingDtos;

    public int getPhId() {
        return phId;
    }

    public void setPhId(int phId) {
        this.phId = phId;
    }

    public String getPhName() {
        return phName;
    }

    public void setPhName(String phName) {
        this.phName = phName;
    }

    public Set<LeixingDto> getLeixingDtos() {
        return leixingDtos;
    }

    public void setLeixingDtos(Set<LeixingDto> leixingDtos) {
        this.leixingDtos = leixingDtos;
    }
}
