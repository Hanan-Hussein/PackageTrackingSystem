package ke.yh_world_enterprises.packagetrackingsystem.listeners;

import com.haulmont.cuba.core.app.events.EntityPersistingEvent;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.security.entity.Group;
import ke.yh_world_enterprises.packagetrackingsystem.entity.Admin;

import java.util.UUID;

import com.haulmont.cuba.core.app.events.EntityChangedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import javax.inject.Inject;

@Component("packagetrackingsystem_AdminChangedListener")
public class AdminChangedListener {
@Inject
private DataManager dataManager;
@Inject
private Metadata metadata;
    @EventListener
    public void beforeCommit(EntityPersistingEvent<Admin> event) {
        Admin newUser = event.getEntity();

        Group group;
        try {
            group = dataManager.load(Group.class)
                    .query("select g from sec$Group g where g.name = :group")
                    .parameter("group", "admin")
                    .one();
        } catch (IllegalStateException e) {
            Group parent = dataManager.load(Group.class)
                    .query("select g from sec$Group g where g.name = :group")
                    .parameter("group", "Company")
                    .one();

            group = metadata.create(Group.class);
            group.setName("admin");
            group.setParent(parent);
            group = dataManager.commit(group);

        }

        newUser.setGroup(group);
        newUser.setLogin(newUser.getEmail());

    }
}