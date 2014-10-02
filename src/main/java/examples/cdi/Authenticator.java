package examples.cdi;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import lombok.Getter;
import lombok.Setter;

import org.picketlink.Identity;
import org.picketlink.Identity.AuthenticationResult;
import org.picketlink.idm.IdentityManager;
import org.picketlink.idm.credential.Password;
import org.picketlink.idm.model.basic.User;

/**
 * 
 * @author t_endo
 */
@Named
@ViewScoped
// @RequestScoped
// @Stateless
public class Authenticator implements Serializable {

    private static final long serialVersionUID = 680046351421162082L;

    @Inject
    private IdentityManager identityManager;

    @Inject
    private Identity identity;

    @Getter
    @Setter
    private String loginName;

    @Getter
    @Setter
    private String firstName;

    @Getter
    @Setter
    private String lastName;

    @Getter
    @Setter
    private String password;

    public String register() {
        User newUser = new User(this.loginName);

        newUser.setFirstName(this.firstName);
        newUser.setLastName(this.lastName);

        this.identityManager.add(newUser);

        Password password = new Password(this.password);

        this.identityManager.updateCredential(newUser, password);

        return "index?faces-redirect=true";
    }

    public String login() {
        AuthenticationResult result = identity.login();
        if (result.equals(AuthenticationResult.SUCCESS)) {
            return "home?faces-redirect=true";
        } else {
            return null;
        }
    }
}
