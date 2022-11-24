import { VideoService } from './services/video.service';
import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { NgxSpinnerService } from 'ngx-spinner';
import { LoginService } from 'src/app/services/login.service';
import { YoutubeService } from './services/youtube.service';
import { Video } from './models/video';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'Conhecimento entre videos';
  user = localStorage.getItem('currentUser');
  videos: Video[];
  search : String = "teste";

  constructor(
    private spinner: NgxSpinnerService,
    private youTubeService: YoutubeService,
    private loginService: LoginService,
    private videoService: VideoService
  ) {
    const user = localStorage.getItem('currentUser');
  }

  buscarVideoPorNome() {
    return this.videoService.getVideosByName(this.search).subscribe((videos : Video[]) => {
      this.videos = videos;
    });
  }

  logout() {
    this.loginService.logout();
    location.reload();
  }

  ngOnInit(): void {
    console.log(this.user);
  }
}
