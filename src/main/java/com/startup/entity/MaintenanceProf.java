package com.startup.entity;

import java.util.Objects;

/**
 * @author: Christ Amour NM
 * Desc: Entity
 * Date: 30 June 2020
 */

public class MaintenanceProf {

    private String maintenanceId;
    private String professionId;

    public MaintenanceProf() {
    }

    private MaintenanceProf(Builder builder) {

        this.maintenanceId = builder.maintenanceId;
        this.professionId = builder.professionId;
    }

    public String getMaintenanceId() {
        return maintenanceId;
    }

    public String getProfession() {
        return professionId;
    }

    public static class Builder{

        private String maintenanceId;
        private String professionId;

        public Builder maintenanceId(String maintenanceId) {
            this.maintenanceId = maintenanceId;
            return this;
        }
        public Builder professionId(String professionId) {
            this.professionId = professionId;
            return this;
        }


        public Builder copy(MaintenanceProf maintenanceProf){
            this.maintenanceId = maintenanceProf.maintenanceId;
            this.professionId = maintenanceProf.professionId;

            return this;
        }

        public MaintenanceProf build() {
            return new MaintenanceProf(this);
        }

    }

    @Override
    public String toString() {
        return "MaintenanceProf{" +
                "maintenanceId='" + maintenanceId + '\'' +
                ", professionId='" + professionId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MaintenanceProf maintenanceProf = (MaintenanceProf) o;
        return maintenanceId.equals(maintenanceProf.maintenanceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maintenanceId);
    }
}
