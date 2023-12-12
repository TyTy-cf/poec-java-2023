package fr.ktourret.poec.my_mvc.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {

    private Long id;

    private Date createdAt;

    private String email;

    private String name;

    private String nickname;

    private String password;

    private String profileImage;

    private String roles;

    private double wallet;

    private Country country;

    private List<Game> wishlist = new ArrayList<>();

    private List<UserOwnGame> ownedGames = new ArrayList<>();

    private List<Review> reviews = new ArrayList<>();

    public void addGameToWishList(Game game) {
        this.wishlist.add(game);
    }

    public void addOwnedGame(UserOwnGame uog) {
        this.ownedGames.add(uog);
    }

    public void addReview(Review review) {
        this.reviews.add(review);
    }

}