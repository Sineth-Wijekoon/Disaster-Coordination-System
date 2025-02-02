package org.example.disastersystem.Objects;

public class DisasterCount {
    private String disasterType;
    private Long count;

    public DisasterCount(String disasterType, Long count) {
        this.disasterType = disasterType;
        this.count = count;
    }

    public String getDisasterType() {
        return disasterType;
    }

    public void setDisasterType(String disasterType) {
        this.disasterType = disasterType;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
