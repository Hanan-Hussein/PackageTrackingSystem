package ke.yh_world_enterprises.packagetrackingsystem.service;

import com.haulmont.cuba.core.EntityManager;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.Transaction;
import com.haulmont.cuba.core.app.EmailService;
import com.haulmont.cuba.core.global.EmailInfo;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.core.global.PasswordEncryption;
import com.haulmont.cuba.core.global.Security;
import ke.yh_world_enterprises.packagetrackingsystem.entity.Admin;
import ke.yh_world_enterprises.packagetrackingsystem.wrappers.ResponseWrapper;
import org.checkerframework.checker.units.qual.A;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service(CreateAdminService.NAME)
public class CreateAdminServiceBean implements CreateAdminService {
    private static final Logger log = LoggerFactory.getLogger(CreateAdminServiceBean.class);
    @Inject
    private Persistence persistence;
    @Inject
    private Metadata metadata;
    @Inject
    private Security security;
    @Inject
    PasswordEncryption passwordEncryption;
    @Inject
    private EmailService emailService;
    @Override
    public ResponseWrapper createAdmin(Admin admin) {
        ResponseWrapper response = new ResponseWrapper();
        try (Transaction tx = persistence.createTransaction()) {

            EntityManager em = persistence.getEntityManager();
            persistence.getEntityManager().persist(admin);

            Admin admin1 = em.createQuery("select e from packagetrackingsystem_Admin e where e.email=:email", Admin.class)
                    .setParameter("email", admin.getEmail()).getFirstResult();
            Admin admin2 = em.createQuery("select e from packagetrackingsystem_Admin e where e.phoneNumber=:phoneNumber", Admin.class)
                    .setParameter("phoneNumber", admin.getPhoneNumber()).getFirstResult();
            Admin admin3 = em.createQuery("select e from packagetrackingsystem_Admin e where e.nationalId=:nationalId", Admin.class)
                    .setParameter("nationalId", admin.getNationalId()).getFirstResult();
            if(admin1!=null){
                response.setMessage("Email already exists");
                response.setCode(409);
                return response;
            }
            if(admin2!=null){
                response.setCode(409);
                response.setMessage("PhoneNumber already exists");
                return response;
            }
            if (admin3 !=null){
                response.setCode(409);
                response.setMessage("National Id already exists");
            }
            String pass = admin.getPassword();

            admin.setPassword(passwordEncryption.getPasswordHash(admin.getId(), pass));

            tx.commit();
            response.setData(admin);

        }
        return response;

    }
}