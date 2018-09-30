package com.qiujian.dto;

public class SxPhDto {
    private int spId;
    private int spPrice;
    private ShuxingDto shuxingDto;
    private LeixingDto leixingDto;

    public LeixingDto getLeixingDto() {
        return leixingDto;
    }

    public void setLeixingDto(LeixingDto leixingDto) {
        this.leixingDto = leixingDto;
    }


    public ShuxingDto getShuxingDto() {
        return shuxingDto;
    }

    public void setShuxingDto(ShuxingDto shuxingDto) {
        this.shuxingDto = shuxingDto;
    }

    public int getSpId() {
        return spId;
    }

    public void setSpId(int spId) {
        this.spId = spId;
    }

    public int getSpPrice() {
        return spPrice;
    }

    public void setSpPrice(int spPrice) {
        this.spPrice = spPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SxPhDto sxPhDto = (SxPhDto) o;

        if (spId != sxPhDto.spId) return false;
        if (spPrice != sxPhDto.spPrice) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = spId;
        result = 31 * result + spPrice;
        return result;
    }
}
