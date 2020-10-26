package com.startup.entity.technician;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;

/**
 * @author: Christ Amour NM
 * Desc: Entity
 * Date: 30 June 2020
 */

@Entity
@IdClass(MaintenanceProfId.class)
public class MaintenanceProf implements Serializable {

    @Id
    @Column()
    private String maintenanceId, professionId;

    protected MaintenanceProf() {
    }

    private MaintenanceProf(Builder builder) {

        this.maintenanceId = builder.maintenanceId;
        this.professionId = builder.professionId;
    }

    public String getMaintenanceId() {
        return maintenanceId;
    }

    public String getProfessionId() {
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
                ", profession='" + professionId + '\'' +
                '}';
    }
}
