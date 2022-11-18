import { Usuario } from 'src/app/models/usuario';
import { VideoService } from './../../../services/video.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UploadService } from './../../../services/upload.service';

@Component({
  selector: 'app-enviar-video',
  templateUrl: './enviar-video.component.html',
  styleUrls: ['./enviar-video.component.css'],
})
export class EnviarVideoComponent implements OnInit {
  usuario: Usuario;
  formUpload: FormGroup;
  videos;


  constructor(
    private router: Router,
    private uploadService: UploadService,
    private formBuilder: FormBuilder,
    private videoService: VideoService
  ) {}

  ngOnInit(): void {
    this.usuario = JSON.parse(localStorage.getItem('currentUser'));
    this.criarForm();
    this.getPlaylistsByUser();
  }

  criarForm() {
    this.formUpload = this.formBuilder.group({
      titulo: ['', [Validators.required]],
      link: ['', [Validators.required]],
      autor: [this.usuario, [Validators.required]],
      privado: ['', [Validators.required]],
      categoria: ['', [Validators.required]],
    });

  }

  getPlaylistsByUser() {
    this.videoService.getPlaylistsByUserId(this.usuario.id).subscribe((lista) => {
      for (let element of lista['items']) {
        this.videos.push(element);
      }
    });
    console.log("VIDEOS: " + this.videos);
  }

  submit() {
    this.uploadService.enviarVideo(this.formUpload);
  }

  voltar() {
    this.router.navigateByUrl('/');
  }
}
