package com.startup.entity.technician;

import java.util.Objects;

/**
 * @author: Christ Amour NM
 * Desc: Entity
 * Date: 30 June 2020
 */


public class Maintenance {

    private String maintenanceId;
    private String name;
    private String lastname;
    private MaintenanceProf maintenanceProf;

    public Maintenance() {
    }

    private Maintenance(Builder builder) {
        this.maintenanceId = builder.maintenanceId;
        this.name = builder.name;
        this.lastname = builder.lastname;
        this.maintenanceProf = builder.maintenanceProf;
    }

    public String getMaintenanceId() {
        return maintenanceId;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public MaintenanceProf getMaintenanceProf() {
        return maintenanceProf;
    }

    public static class Builder {

        private String maintenanceId;
        private String name;
        private String lastname;
        private MaintenanceProf maintenanceProf;


        public Builder maintenanceId(String maintenanceId) {
            this.maintenanceId = maintenanceId;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder lastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public Builder maintenanceProf(MaintenanceProf maintenanceProf) {
            this.maintenanceProf = maintenanceProf;
            return this;
        }


//        public Builder copy(Maintenance maintenance){
//            this.maintenanceId = maintenance.maintenanceId;
//            this.name = maintenance.name;
//            this.lastname = maintenance.lastname;
//
//            return this;
//        }

        public Maintenance build() {
            return new Maintenance(this);
        }

    }

    @Override
    public String toString() {
        return "Maintenance{" +
                "maintenanceId='" + maintenanceId + '\'' +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", maintenanceProf=" + maintenanceProf +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Maintenance maintenance = (Maintenance) o;
        return maintenanceId.equals(maintenance.maintenanceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maintenanceId);
    }
}
