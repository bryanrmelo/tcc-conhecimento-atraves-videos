package edu.ifrs.conhecimentoatravesvideos.api.hateoas;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.SimpleRepresentationModelAssembler;

import edu.ifrs.conhecimentoatravesvideos.api.controles.VideoControleApi;
import edu.ifrs.conhecimentoatravesvideos.model.Video;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

public class VideoAssembler implements SimpleRepresentationModelAssembler<Video>  {

    @Override
    public void addLinks(EntityModel<Video> resource) {
        Long id = resource.getContent().getId();

        Link selfLink = linkTo(methodOn(VideoControleApi.class).buscarPorId(id))
                .withSelfRel()
                .withType("GET");

        resource.add(selfLink);
    }

    @Override
    public void addLinks(CollectionModel<EntityModel<Video>> resources) {
        Link selfLink = linkTo(methodOn(VideoControleApi.class).buscarTodos(null))
                .withSelfRel()
                .withType("GET");

        resources.add(selfLink);
    }
}
