package ATMtrans.repository.repositoryAtmInf;

import ATMtrans.domain.atmInfor.Electricity;
import ATMtrans.repository.IRepository.IRepository;

import java.util.Set;

public interface ElectricityRepository extends IRepository<Electricity,String> {
    Set<Electricity> getAll();
}
