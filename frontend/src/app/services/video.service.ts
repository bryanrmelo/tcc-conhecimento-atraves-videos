import { map, Observable } from 'rxjs';
import { Usuario } from 'src/app/models/usuario';
import { environment } from './../../environments/environment';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class VideoService {
  url = environment.apiUrl;
  usuario: Usuario;

  constructor(private httpClient: HttpClient) {
    this.usuario = JSON.parse(localStorage.getItem('currentUser'));
  }

  getPlaylistsByUserId(id: number): Observable<Object> {
    console.log(id)
    return this.httpClient.get(`${this.url}/video/playlist/${id}`).pipe(
      map((res) => {
        return res;
      })
    );
  }
}
