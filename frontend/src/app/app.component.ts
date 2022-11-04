import { LoginService } from 'src/app/services/login.service';
import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { NgxSpinnerService } from 'ngx-spinner';
import { YoutubeService } from './services/youtube.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  url = 'http://localhost:8080/api/v1/videos';
  title = 'Conhecimento entre videos';
  user = localStorage.getItem('currentUser');

  constructor(private httpClient: HttpClient,private spinner: NgxSpinnerService, private youTubeService: YoutubeService, private loginService: LoginService) {}

  buscarVideos() {
    return this.httpClient.get(this.url)
  }

  logout() {
    this.loginService.logout();
  }

  ngOnInit(): void {
  }
}
