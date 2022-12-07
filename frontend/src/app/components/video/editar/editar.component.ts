import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { Playlist } from 'src/app/models/playlist';
import { Usuario } from 'src/app/models/usuario';
import { Video } from 'src/app/models/video';
import { UploadService } from './../../../services/upload.service';
import { VideoService } from './../../../services/video.service';

@Component({
  selector: 'app-editar-video',
  templateUrl: './editar.component.html',
  styleUrls: ['./editar.component.css'],
})
export class EditarVideoComponent implements OnInit {
  usuario: Usuario;
  formUpload: FormGroup;
  playlists: Playlist[] | undefined;
  routeSub: Subscription;
  video: Video;

  constructor(
    private router: Router,
    private uploadService: UploadService,
    private formBuilder: FormBuilder,
    private videoService: VideoService,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.usuario = JSON.parse(localStorage.getItem('currentUser'));
    this.criarForm();
    this.getPlaylistsByUser();
    this.routeSub = this.route.params.subscribe((params) => {
      this.getVideo(params['id']);
    });
  }

  criarForm() {
    this.formUpload = this.formBuilder.group({
      titulo: [this.video.titulo, [Validators.required]],
      link: [this.video.link, [Validators.required]],
      autor: [this.usuario.nome, [Validators.required]],
      privado: [this.video.privado, [Validators.required]],
      categoria: [this.video.categoria, [Validators.required]],
      playlist: [this.video.playlist],
    });
  }

  getPlaylistsByUser() {
    this.videoService
      .getPlaylistsByUserId(this.usuario.id)
      .subscribe((playlists: Playlist[]) => {
        this.playlists = playlists;
      });
  }
  /*
    async getPlaylistsByUser() {
      this.playlists = await firstValueFrom(
        this.videoService.getPlaylistsByUserId(this.usuario.id)
      )
      console.log(this.playlists);
    */

  getVideo(id: number) {
    this.videoService.getVideo(id).subscribe((res: Video) => {
      this.video = res;
    });
  }

  submit() {
    this.videoService.atualizar(this.formUpload, this.video.id);
    this.router.navigateByUrl('/');
  }

  voltar() {
    this.router.navigateByUrl('/');
  }
}
