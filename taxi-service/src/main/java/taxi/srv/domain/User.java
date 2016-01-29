package taxi.srv.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by anton.shevchenko on 25.11.2015.
 */
@Entity
@Table(name = "USERS")
public class User {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "USERS_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "USER_ID")
    private long id;

    @Column(name = "USER_NAME")
    private String name;

    @Column(name = "USER_PASS")
    private String password;

    @Column(name = "USER_PREVIOUS_PASS")
    private String prevPass;

    @Column(name = "USER_BLOCKED")
    private boolean blocked;

    @Column(name = "USER_PASS_EXPIRED_DATE")
    private Date expPassDate;

    @Column(name = "USER_ATTEMPTS_LOGIN")
    private int attempts;

    public User() {
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
        this.prevPass = "";
        this.blocked = false;
        //one month, starts from now
        this.expPassDate = new Date(System.currentTimeMillis()+2629800000L);
    }

    public User(String name, String password, Date expPassDate) {
        this.name = name;
        this.password = password;
        this.prevPass = "";
        this.blocked = false;
        this.expPassDate = expPassDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPrevPass() {
        return prevPass;
    }

    public void setPrevPass(String prevPass) {
        this.prevPass = prevPass;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public Date getExpPassDate() {
        return expPassDate;
    }

    public void setExpPassDate(Date expPassDate) {
        this.expPassDate = expPassDate;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", prevPass='" + prevPass + '\'' +
                ", blocked=" + blocked +
                ", expPassDate=" + expPassDate +
                ", attempts=" + attempts +
                '}';
    }
}
