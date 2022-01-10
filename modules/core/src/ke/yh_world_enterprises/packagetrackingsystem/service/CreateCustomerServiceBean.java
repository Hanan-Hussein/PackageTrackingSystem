package ke.yh_world_enterprises.packagetrackingsystem.service;

import com.haulmont.cuba.core.EntityManager;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.Transaction;
import ke.yh_world_enterprises.packagetrackingsystem.entity.Customer;
import ke.yh_world_enterprises.packagetrackingsystem.wrappers.ResponseWrapper;
import org.checkerframework.checker.units.qual.C;
import org.springframework.stereotype.Service;

import javax.inject.Inject;


@Service(CreateCustomerService.NAME)
public class CreateCustomerServiceBean implements CreateCustomerService {
@Inject
private Persistence persistence;

    @Override
    public ResponseWrapper createCustomer(Customer customer) {
        ResponseWrapper response = new ResponseWrapper();
        try (Transaction tx = persistence.getTransaction()) {
            EntityManager em = persistence.getEntityManager();

            persistence.getEntityManager().persist(customer);

            Customer essentialWorkers1 = em.createQuery("select e from packagetrackingsystem_Customer e where e.phoneNumber=:employeeNumber", Customer.class)
                    .setParameter("employeeNumber", customer.getPhoneNumber()).getFirstResult();
            Customer essentialWorkers2 = em.createQuery("select e from packagetrackingsystem_Customer e where e.nationalId=:nationalId", Customer.class)
                    .setParameter("nationalId", customer.getNationalId()).getFirstResult();
            Customer essentialWorkers3 = em.createQuery("select e from packagetrackingsystem_Customer e where e.email=:email", Customer.class)
                    .setParameter("email", customer.getEmail()).getFirstResult();
            if (essentialWorkers1 != null) {
                response.setMessage("Phone number already exists");
                response.setCode(409);
                return response;
            }
            if (essentialWorkers2 != null) {
                response.setMessage("National Id already exists");
                response.setCode(409);
                return response;
            }
            if (essentialWorkers3 != null) {
                response.setMessage("Email already exists");
                response.setCode(409);
                return response;
            }
            response.setData(customer);
            tx.commit();

        }

        return response;
    }
}