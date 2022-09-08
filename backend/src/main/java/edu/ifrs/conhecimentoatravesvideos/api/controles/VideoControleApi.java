package edu.ifrs.conhecimentoatravesvideos.api.controles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.ifrs.conhecimentoatravesvideos.api.hateoas.VideoAssembler;
import edu.ifrs.conhecimentoatravesvideos.model.Video;
import edu.ifrs.conhecimentoatravesvideos.servicos.VideoServico;

@RestController
public class VideoControleApi {
    
    @Autowired
    private VideoServico videoServico;

    @Autowired
    private VideoAssembler videoAssembler;

    @Autowired
    private PagedResourcesAssembler<Video> pagedResourcesAssembler;

    public Video buscarPorId(long id) {
        return null;

    }

    @GetMapping
    public CollectionModel<EntityModel<Video>> buscarTodos(@PageableDefault(sort = { "id" }, direction = Direction.ASC) Pageable paginacao) {
        Page<Video> videos = videoServico.buscarTodos(paginacao);

        return pagedResourcesAssembler.toModel(videos, videoAssembler);
        
    }
}
