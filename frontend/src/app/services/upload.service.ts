import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, map } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UploadService {

  url = 'http://localhost:8080/api/v1/fonte';

  constructor(private httpClient: HttpClient) { }

  postFile(fileToUpload: File): Observable<boolean> {
    const formData: FormData = new FormData();
    formData.append('file', fileToUpload, fileToUpload.name);
    console.log('Pré post')
    return this.httpClient.post(this.url, formData).pipe(
      map(() => {
        return true;
      })
    );
  }
}