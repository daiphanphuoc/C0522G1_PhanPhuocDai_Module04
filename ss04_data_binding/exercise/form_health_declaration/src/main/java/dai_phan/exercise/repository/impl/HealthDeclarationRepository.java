package dai_phan.exercise.repository.impl;

import dai_phan.exercise.model.HealthDeclaration;
import dai_phan.exercise.repository.IHealthDeclarationRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class HealthDeclarationRepository implements IHealthDeclarationRepository {

    private static Map<Integer, HealthDeclaration> healthDeclarationMap = new HashMap<>();

    static {
        healthDeclarationMap.put(1, new HealthDeclaration(1, "Phan Phước Đại", "01/01/1990",
                true, "Việt nam", 241399524, "Xe ô tô", "51H-1057",
                8, "01-01-2020", "02/01/2020", "none"));
        healthDeclarationMap.put(2, new HealthDeclaration(2, "Phan Đại", "01/01/1990",
                true, "Việt nam", 241399524, "Xe ô tô", "51H-1057",
                8, "01-01-2020", "02/01/2020", "none"));
        healthDeclarationMap.put(3, new HealthDeclaration(3, "Phan Phước", "01/01/1990",
                true, "Việt nam", 241399524, "Xe ô tô", "51H-1057",
                8, "01-01-2020", "02/01/2020", "none"));
        healthDeclarationMap.put(4, new HealthDeclaration(4, "Phước Đại", "01/01/1990",
                true, "Việt nam", 241399524, "Xe ô tô", "51H-1057",
                8, "01-01-2020", "02/01/2020", "none"));
        healthDeclarationMap.put(5, new HealthDeclaration(5, "Phan Phước Đạt", "01/01/1999",
                true, "Việt nam", 241399524, "Xe ô tô", "51H-1057",
                8, "01-01-2020", "02/01/2020", "none"));
        healthDeclarationMap.put(6, new HealthDeclaration(6, "Phan Phúc", "01/01/1995",
                true, "Việt nam", 241399524, "Xe ô tô", "51H-1057",
                8, "01-01-2020", "02/01/2020", "none"));
    }

    @Override
    public Map<Integer, HealthDeclaration> displayAll() {
        return healthDeclarationMap;
    }

    @Override
    public HealthDeclaration finById(int id) {
        return healthDeclarationMap.get(id);
    }

    @Override
    public HealthDeclaration update(HealthDeclaration healthDeclaration) {
        if (healthDeclarationMap.get(healthDeclaration.getId()) != null) {
            healthDeclarationMap.put(healthDeclaration.getId(), healthDeclaration);
            return healthDeclaration;
        }
        return null;
    }

    @Override
    public HealthDeclaration insert(HealthDeclaration healthDeclaration) {
        if (healthDeclarationMap.get(healthDeclaration.getId()) == null) {
            return healthDeclarationMap.put(healthDeclaration.getId(), healthDeclaration);
        }
        return null;
    }

    @Override
    public List<String> countryList() {
        List<String> strings = new ArrayList<>();
        strings.add("Việt Nam");
        strings.add("Nhật Bản");
        strings.add("Trung quốc");
        strings.add("Anh");
        strings.add("Cambodia");
        return strings;
    }

    @Override
    public List<String> travelInfo() {
        List<String> strings = new ArrayList<>();
        strings.add("Máy bay");
        strings.add("Ô tô");
        strings.add("Thuyền");
        strings.add("Tàu hỏa");
        strings.add("Khác");
        return strings;
    }

}
