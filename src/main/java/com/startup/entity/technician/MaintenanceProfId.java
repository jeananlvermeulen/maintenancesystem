package com.startup.entity.technician;

import java.io.Serializable;
import java.util.Objects;

public class MaintenanceProfId implements Serializable {

    private String maintenanceId, professionId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MaintenanceProfId that = (MaintenanceProfId) o;
        return maintenanceId.equals(that.maintenanceId) &&
                professionId.equals(that.professionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maintenanceId, professionId);
    }
}
