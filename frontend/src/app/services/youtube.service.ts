import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class YoutubeService {
  apiKey: string = '111AIzaSyA1J-Zqdunq8hCq2KcH-vNhp9PG02hWCWo';

  constructor(public http: HttpClient) {}

  getVideosPorID(channel: string, maxResults: number): Observable<Object> {
    let url =
      'https://www.googleapis.com/youtube/v3/search?key=' +
      this.apiKey +
      '&channelId=' +
      channel +
      '&order=date&part=snippet &type=video,id&maxResults=' +
      maxResults;
    return this.http.get(url).pipe(
      map((res) => {
        return res;
      })
    );
  }
  getVideosPorNomeUsuario(
    channel: string,
    maxResults: number
  ): Observable<Object> {
    let url =
      'https://www.googleapis.com/youtube/v3/search?key=' +
      this.apiKey +
      '&forUsername=' +
      channel +
      '&part=id&order=date&part=snippet &type=video,id&maxResults=' +
      maxResults;
    return this.http.get(url).pipe(
      map((res) => {
        return res;
      })
    );
  }
}
