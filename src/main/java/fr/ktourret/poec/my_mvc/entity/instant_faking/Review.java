package fr.ktourret.poec.my_mvc.entity.instant_faking;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Review {

    private Long id;

    private String title;

    private String content;

    private Date createdAt;

    private int upVote;

    private int downVote;

    private double rating;

    private User user;

    private Game game;

}