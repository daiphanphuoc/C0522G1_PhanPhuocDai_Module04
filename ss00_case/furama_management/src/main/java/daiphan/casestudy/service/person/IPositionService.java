package daiphan.casestudy.service.person;

import daiphan.casestudy.model.person.Position;
import daiphan.casestudy.service.IFuramaService;

import java.util.List;

public interface IPositionService extends IFuramaService<Position> {
    List<Position> findAll();
}
