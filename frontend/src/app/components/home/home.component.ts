import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgxSpinnerService } from 'ngx-spinner';
import { YoutubeService } from 'src/app/services/youtube.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
  constructor(
    private httpClient: HttpClient,
    private spinner: NgxSpinnerService,
    private youTubeService: YoutubeService
  ) {}

  videos!: any[];

  ngOnInit(): void {
    this.spinner.show();
    this.videos = [];
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
  }
}
