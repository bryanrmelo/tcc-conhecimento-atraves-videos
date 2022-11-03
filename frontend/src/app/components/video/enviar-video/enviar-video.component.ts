import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-enviar-video',
  templateUrl: './enviar-video.component.html',
  styleUrls: ['./enviar-video.component.css']
})
export class EnviarVideoComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  submit() {

  }

  voltar() {
    this.router.navigateByUrl('/')
  }

}
