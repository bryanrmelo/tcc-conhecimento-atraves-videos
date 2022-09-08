import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  url = 'http://localhost:8080/api/v1/videos';
  title = 'frontend';

  constructor(private httpClient: HttpClient) {}

  buscarVideos() {
    return this.httpClient.get(this.url)
  }
}
