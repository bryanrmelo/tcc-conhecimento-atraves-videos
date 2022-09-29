import { Component, OnInit } from '@angular/core';
import { DomSanitizer, SafeResourceUrl } from '@angular/platform-browser';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-assistir',
  templateUrl: './assistir.component.html',
  styleUrls: ['./assistir.component.css'],
})
export class AssistirComponent implements OnInit {
  safeSrc!: SafeResourceUrl;
  id!: number;

  constructor(
    private sanitizer: DomSanitizer,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      this.id = params['id'];
    });
    this.safeSrc = this.sanitizer.bypassSecurityTrustResourceUrl(
      `https://www.youtube.com/embed/${this.id}?enablejsapi=1&origin=http://localhost:4200'`
    );
    console.log(this.id);
  }
}
