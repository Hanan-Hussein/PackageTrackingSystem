package ke.yh_world_enterprises.packagetrackingsystem.rest.TwoFA;

import com.haulmont.addon.restapi.api.auth.OAuthTokenIssuer;
import com.haulmont.chile.core.model.Session;
import com.haulmont.cuba.core.app.EmailService;
import com.haulmont.cuba.core.global.*;
import com.haulmont.cuba.core.sys.AppContext;
import com.haulmont.cuba.core.sys.SecurityContext;
import com.haulmont.cuba.security.app.TrustedClientService;
import com.haulmont.cuba.security.global.LoginException;
import com.haulmont.cuba.security.global.UserSession;
import com.haulmont.cuba.web.auth.WebAuthConfig;

import ke.yh_world_enterprises.packagetrackingsystem.entity.Admin;
import ke.yh_world_enterprises.packagetrackingsystem.rest.TwoFA.model.LoginRequest;
import ke.yh_world_enterprises.packagetrackingsystem.rest.TwoFA.model.TwoFAVerificationRequest;
import ke.yh_world_enterprises.packagetrackingsystem.wrappers.ResponseWrapper;
import org.slf4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.Collections;
import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("v2/oauth")
public class TwoFAController {
    @Inject
    private TrustedClientService loginService;
    @Inject
    private Configuration configuration;
    @Inject
    private DataManager dataManager;
    @Inject
    private Metadata metadata;
    @Inject
    private EmailService emailService;
    @Inject
    private PasswordEncryption passwordEncryption;
    @Inject
    private MessageTools messageTools;
    @Inject
    private Session userSession;
    @Inject
    private Logger log;
    @Inject
    private OAuthTokenIssuer oAuthTokenIssuer;
    @PostMapping("token")
        // Disables the default login handler in favour of 2FA
    ResponseEntity<String> getToken() {
        return new ResponseEntity("Use 2FA to login", HttpStatus.UNAUTHORIZED);
    }

    @PostMapping("verify-login")
    ResponseEntity verifyLogin(@RequestBody LoginRequest loginRequest) {
        ResponseWrapper response = new ResponseWrapper();
        // obtain system session to be able to call middleware services
        WebAuthConfig webAuthConfig = configuration.getConfig(WebAuthConfig.class);
        UserSession systemSession;
        try {
            systemSession = loginService.getSystemSession(webAuthConfig.getTrustedClientPassword());
        } catch (LoginException e) {
            log.error("Error", e);
            throw new RuntimeException("Error during system auth");
        }
        // set security context
        AppContext.setSecurityContext(new SecurityContext(systemSession));
        try {
            systemSession = loginService.getSystemSession(webAuthConfig.getTrustedClientPassword());
        } catch (LoginException e) {
            log.error("Error", e);
            throw new RuntimeException("Error during system auth");
        }
        // set security context
        AppContext.setSecurityContext(new SecurityContext(systemSession));

            try{
        Admin user = dataManager.load(Admin.class)
                .query("select e from packagetrackingsystem_Admin e where e.login=:username and e.active=true")
                .parameter("username",loginRequest.getUsername())
                .one();
        log.info("user"+user);


        if (!passwordEncryption.checkPassword(user, loginRequest.getPassword())) {
            response.setCode(400);
            response.setMessage("Wrong password");
            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        }
        else if(passwordEncryption.checkPassword(user, loginRequest.getPassword())){
            OAuthTokenIssuer.OAuth2AccessTokenResult tokenResult =
                    oAuthTokenIssuer.issueToken(user.getLogin(), messageTools.getDefaultLocale(), Collections.emptyMap());
            OAuth2AccessToken accessToken = tokenResult.getAccessToken();

            HttpHeaders headers = new HttpHeaders();
            headers.set(HttpHeaders.CACHE_CONTROL, "no-store");
            headers.set(HttpHeaders.PRAGMA, "no-cache");
            return new ResponseEntity<>(accessToken, headers, HttpStatus.OK);
        }
            }catch (Exception e){
                log.error("Error",e);
            }
        response.setCode(404);
        response.setMessage("No user found with your provided username! try again");
        return new ResponseEntity(response,HttpStatus.UNAUTHORIZED);
        }
}
