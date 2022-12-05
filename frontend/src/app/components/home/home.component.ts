import { VideoService } from './../../services/video.service';
import { HttpClient } from '@angular/common/http';
import { Component, Injectable, OnInit } from '@angular/core';
import { NgxSpinnerService } from 'ngx-spinner';
import { YoutubeService } from 'src/app/services/youtube.service';
import { Video } from 'src/app/models/video';

@Injectable({
  providedIn: 'root',
})
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
  constructor(
    private httpClient: HttpClient,
    private spinner: NgxSpinnerService,
    private youTubeService: YoutubeService,
    private videoServico: VideoService
  ) {}

  videos!: any[];

  ngOnInit(): void {
    this.spinner.show();
    this.videoServico
      .getVideosByName(localStorage.getItem('search'))
      .subscribe((videos: Video[]) => {
        this.videos = videos;
      });
    /*
    this.youTubeService
      .getVideosPorID('UCsXVk37bltHxD1rDPwtNM8Q', 16)
      .subscribe((lista) => {
        for (let element of lista['items']) {
          this.videos!.push(element);
        }
        setTimeout(() => {
          this.spinner.hide();
        }, 3000);
      });
      */
  }

  refresh(): void {
    this.videos = [];
    this.ngOnInit();
  }
}
