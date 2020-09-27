package com.startup.entity.technician;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author: Christ Amour NM
 * Desc: Entity
 * Date: 30 June 2020
 */

public class MaintenanceProf implements Serializable {

    private String maintenanceId;
    private String profession;

    private MaintenanceProf() {
    }

    private MaintenanceProf(Builder builder) {

        this.maintenanceId = builder.maintenanceId;
        this.profession = builder.profession;
    }

    public String getMaintenanceId() {
        return maintenanceId;
    }

    public String getProfession() {
        return profession;
    }

    public static class Builder{

        private String maintenanceId;
        private String profession;

        public Builder maintenanceId(String maintenanceId) {
            this.maintenanceId = maintenanceId;
            return this;
        }
        public Builder profession(String profession) {
            this.profession = profession;
            return this;
        }


        public Builder copy(MaintenanceProf maintenanceProf){
            this.maintenanceId = maintenanceProf.maintenanceId;
            this.profession = maintenanceProf.profession;

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
                ", profession='" + profession + '\'' +
                '}';
    }
}
