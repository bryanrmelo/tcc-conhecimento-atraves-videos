import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, map } from 'rxjs';
import { FormGroup } from '@angular/forms';
import { Video } from '../models/video';

@Injectable({
  providedIn: 'root'
})
export class UploadService {

  url = 'http://localhost:8080/api/v1';

  constructor(private httpClient: HttpClient) { }

  postFile(fileToUpload: File) {
    const formData: FormData = new FormData();
    formData.append('file', fileToUpload, fileToUpload.name);
    console.log('Pré post')
    console.log(formData)
    this.httpClient.post(`${this.url}/fonte`, formData)
  }
  enviarVideo(formUpload: FormGroup<any>) {
    this.httpClient.post(`${this.url}/video`, formUpload)
  }
}
