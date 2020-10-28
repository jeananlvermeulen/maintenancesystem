package com.startup.entity.technician;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author: Christ Amour NM
 * Desc: Entity
 * Date: 30 June 2020
 */


@Entity
public class Maintenance implements Serializable{

    @Id
    private String maintenanceId;
    private String name;
    private String lastname;


    protected Maintenance() {
    }

    private Maintenance(Builder builder) {
        this.maintenanceId = builder.maintenanceId;
        this.name = builder.name;
        this.lastname = builder.lastname;
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


    public static class Builder {

        private String maintenanceId;
        private String name;
        private String lastname;


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


        public Builder copy(Maintenance maintenance){
            this.maintenanceId = maintenance.maintenanceId;
            this.name = maintenance.name;
            this.lastname = maintenance.lastname;

            return this;
        }

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
