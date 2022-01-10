package ke.yh_world_enterprises.packagetrackingsystem.service;

import com.haulmont.cuba.core.EntityManager;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.Transaction;
import com.haulmont.cuba.core.app.EmailService;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.EmailInfo;
import ke.yh_world_enterprises.packagetrackingsystem.entity.Package;
import ke.yh_world_enterprises.packagetrackingsystem.wrappers.ResponseWrapper;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service(CreateOrderService.NAME)
public class CreateOrderServiceBean implements CreateOrderService {
    @Inject
    private Persistence persistence;
@Inject
private EmailService emailService;
@Inject
private DataManager dataManager;
    @Inject
    private Logger log;

    @Override
    public ResponseWrapper createOrder(Package pg) {
        ResponseWrapper response = new ResponseWrapper();
        try (Transaction tx = persistence.createTransaction()) {

            EntityManager em = persistence.getEntityManager();
            persistence.getEntityManager().persist(pg);
//            final Package reload = dataManager.reload(pg, "package-view");

            tx.commit();
            log.info(">>>>>>>>>>>>>..SENDING EMAIL");
            emailService.sendEmailAsync(new EmailInfo(pg.getSenderEmail(), "Dear customer thank you for choosing us as you choice of Delivery your Tracking ID is ", pg.getTrackingId()));
            response.setData(pg);

        }
        return response;

    }
}