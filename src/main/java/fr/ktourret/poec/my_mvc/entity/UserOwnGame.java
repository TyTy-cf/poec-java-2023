package fr.ktourret.poec.my_mvc.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserOwnGame {

    private Long id;

    private User user;

    private Game game;

    private int gameTime;

    private Date lastUsedAt;

    private Date createdAt;

    private boolean isInstalled;

}