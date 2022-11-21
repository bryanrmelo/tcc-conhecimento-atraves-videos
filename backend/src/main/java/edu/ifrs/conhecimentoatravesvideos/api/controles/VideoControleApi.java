package edu.ifrs.conhecimentoatravesvideos.api.controles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import edu.ifrs.conhecimentoatravesvideos.api.dto.VideoDTO;
import edu.ifrs.conhecimentoatravesvideos.api.hateoas.VideoAssembler;
import edu.ifrs.conhecimentoatravesvideos.model.Video;
import edu.ifrs.conhecimentoatravesvideos.servicos.VideoServico;

@CrossOrigin(origins = "http://localhost:4200")
@RestController()
@RequestMapping("api/v1/video")
public class VideoControleApi {

    @Autowired
    private VideoServico videoServico;

    @Autowired
    private VideoAssembler videoAssembler;

    @Autowired
    private PagedResourcesAssembler<Video> pagedResourcesAssemblerVideo;

    public Video buscarPorId(long id) {
        return null;

    }

    /*
     * @GetMapping
     * public CollectionModel<EntityModel<Video>> buscarTodos(@PageableDefault(sort
     * = { "id" }, direction = Direction.ASC) Pageable paginacao) {
     * Page<Video> videos = videoServico.buscarTodos(paginacao);
     * 
     * return pagedResourcesAssembler.toModel(videos, videoAssembler);
     * 
     * }
     */

    @PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.MULTIPART_FORM_DATA_VALUE })
    @ResponseStatus(code = HttpStatus.CREATED)
    public EntityModel<Video> salvar(@RequestBody VideoDTO videoDTO) {
        System.out.println(videoDTO.toString());

        Video video = videoServico.salvar(videoDTO);

        return videoAssembler.toModel(video);
    }
}
