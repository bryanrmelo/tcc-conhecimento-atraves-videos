import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { map, Observable } from 'rxjs';
import { Usuario } from 'src/app/models/usuario';
import { Playlist } from '../models/playlist';
import { Video } from '../models/video';
import { environment } from './../../environments/environment';

@Injectable({
  providedIn: 'root',
})
export class VideoService {
  url = environment.apiUrl;
  usuario: Usuario;

  constructor(private httpClient: HttpClient) {
    this.usuario = JSON.parse(localStorage.getItem('currentUser'));
  }

  getPlaylistsByUserId(id: number): Observable<Playlist[]> {
    return this.httpClient.get(`${this.url}/video/playlist/${id}`).pipe(
      map((data: any) => {
        return data._embedded.playlistList as Playlist[];
      })
    );
  }

  getVideos(): Observable<Video[]> {
    return this.httpClient.get(`${this.url}/video`).pipe(
      map((data: any) => {
        return data._embedded.videoList as Video[];
      })
    );
  }

  getVideosByName(search: String): Observable<Video[]> {
    return this.httpClient.get(`${this.url}/video?search=${search}`).pipe(
      map((data: any) => {
        return data._embedded.videoList as Video[];
      })
    );
  }

  getVideo(id: number): Observable<Video> {
    return this.httpClient.get(`${this.url}/video/${id}`).pipe(
      map((data: any) => {
        return data._embedded.video as Video;
      })
    );
  }
  atualizar(formUpload: FormGroup<any>, id: number) {
    this.httpClient.put<Video>(`${this.url}/video${id}`, formUpload);
  }
}
