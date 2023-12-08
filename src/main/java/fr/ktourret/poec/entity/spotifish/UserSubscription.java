package fr.ktourret.poec.entity.spotifish;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserSubscription {

    private Long id;

    private Date createdAt;

    private Date finishedAt;

    private User user;

    private Subscription subscription;

}
