package com.qiujian.dto;

public class ShuxingDto {
    private int sxId;
    private String sxName;
    private InfoDto infoDto;

    public InfoDto getInfoDto() {
        return infoDto;
    }

    public void setInfoDto(InfoDto infoDto) {
        this.infoDto = infoDto;
    }

    public int getSxId() {
        return sxId;
    }

    public void setSxId(int sxId) {
        this.sxId = sxId;
    }

    public String getSxName() {
        return sxName;
    }

    public void setSxName(String sxName) {
        this.sxName = sxName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShuxingDto that = (ShuxingDto) o;

        if (sxId != that.sxId) return false;
        if (sxName != null ? !sxName.equals(that.sxName) : that.sxName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sxId;
        result = 31 * result + (sxName != null ? sxName.hashCode() : 0);
        return result;
    }
}
