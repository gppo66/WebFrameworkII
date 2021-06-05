package kr.ac.hansung.cse.hellopspringhateoas.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.util.List;


// These are DTO objects which will be returned from controller classes as representation models.

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Relation(collectionRelation = "actors", itemRelation = "actor")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ActorModel extends RepresentationModel<ActorModel>
{
    private Long id;
    private String firstName;
    private String lastName;
    private String birthDate;

    private List<AlbumModel> albums;
}