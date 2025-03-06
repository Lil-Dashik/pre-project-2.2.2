package preproject.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "cars")
public class CarConfig {
    private int maxCars;
    private List<String> enabledSortFields;

    public int getMaxCars() {
        return maxCars;
    }

    public void setMaxCars(int maxCars) {
        this.maxCars = maxCars;
    }

    public List<String> getEnabledSortFields() {
        return enabledSortFields;
    }

    public void setEnabledSortFields(List<String> enabledSortFields) {
        this.enabledSortFields = enabledSortFields;
    }
}
