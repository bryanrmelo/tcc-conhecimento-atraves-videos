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
  usuario;
  formUpload: FormGroup;

  constructor(
    private router: Router,
    private uploadService: UploadService,
    private formBuilder: FormBuilder
  ) {}

  ngOnInit(): void {
    this.usuario = JSON.parse(localStorage.getItem('currentUser'));
    this.criarForm();
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

  submit() {
    this.uploadService.enviarVideo(this.formUpload);
  }

  voltar() {
    this.router.navigateByUrl('/');
  }
}
