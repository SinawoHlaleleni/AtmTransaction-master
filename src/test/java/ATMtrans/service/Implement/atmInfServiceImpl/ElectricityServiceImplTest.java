package ATMtrans.service.Implement.atmInfServiceImpl;

import ATMtrans.domain.atmInfor.Electricity;
import ATMtrans.factory.factoryAtmInfor.ElectricityFactory;
import ATMtrans.repository.Implement.atmInforImpl.ElectricityRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ElectricityServiceImplTest {

    private ElectricityRepositoryImpl repository;
    private Electricity electricity;


    @Before
    public void setUp() throws Exception {
        this.repository= (ElectricityRepositoryImpl) ElectricityRepositoryImpl.getRepository();
        this.electricity = ElectricityFactory.getAmount( 200 );
    }
    @Test
    public void d_getAll() {
        Set<Electricity> electricity = this.repository.getAll();
        System.out.println("In get all," + electricity);
    }

    @Test
    public void create() {
        Electricity created = this.repository.create(this.electricity);
        System.out.println("the create, done =" + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.electricity);
    }

    @Test
    public void update() {
        String newElectrId = "002345";
        Electricity updated = new Electricity.Builder().Id(newElectrId).build();
        System.out.println("the update, done = " + updated );
        this.repository.update(updated);
        Assert.assertEquals(newElectrId,updated.getId());
        d_getAll();
    }

    @Test
    public void delete() {
        this.repository.delete(electricity.getId());
        d_getAll();
    }

    @Test
    public void read() {
        Electricity read = this.repository.read(electricity.getId());
        System.out.println("the read, read = " + read);
        d_getAll();
        assertNotSame(read,electricity);
    }
}